package mcinto16.uni.coventry.uk.ac.contacts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    EditText tableTxt, starterTxt, mainTxt, dessertTxt, amountS, amountM, amountD;
    List<Identifier> Identifiers = new ArrayList<>();
    ListView orderListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableTxt = (EditText) findViewById(R.id.txtTable);
        starterTxt = (EditText)findViewById(R.id.txtStarter);
        mainTxt = (EditText) findViewById(R.id.txtMain);
        dessertTxt = (EditText) findViewById(R.id.txtDessert);
        amountS = (EditText) findViewById(R.id.sAmount);
        amountM = (EditText) findViewById(R.id.mAmount);
        amountD = (EditText) findViewById(R.id.dAmount);
        orderListView = (ListView) findViewById(R.id.listView);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("newOrder");
        tabSpec.setContent(R.id.tabNewOrder);
        tabSpec.setIndicator("NewOrder");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("orders");
        tabSpec.setContent(R.id.tabOrderList);
        tabSpec.setIndicator("Orders");
        tabHost.addTab(tabSpec);

        final Button addBtn = (Button) findViewById(R.id.btnAdd);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addIdentifier(tableTxt.getText().toString(), starterTxt.getText().toString(), mainTxt.getText().toString(), dessertTxt.getText().toString(), amountS.getText().toString(), amountM.getText().toString(), amountD.toString());
                populateList(); //Function called when button is clicked new order will be added to order list, then will populate the list.
                Toast.makeText(getApplicationContext(),"table " + tableTxt.getText().toString() + " has been added to your orders!", Toast.LENGTH_SHORT).show();
            }
        });

        tableTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addBtn.setEnabled(!tableTxt.getText().toString().trim().isEmpty());
                //Add button isn't enabled if text in 'tableTxt' equal to nothing.

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void populateList() {
        ArrayAdapter<Identifier> adapter = new OrderListAdapter();
        orderListView.setAdapter(adapter);
    }

    private void addIdentifier(String table, String starter, String main, String dessert, String starterA, String mainA, String dessertA) {
        Identifiers.add(new Identifier(table, starter, main, dessert, starterA, mainA, dessertA));

    }

    private class OrderListAdapter extends ArrayAdapter<Identifier> {
        public OrderListAdapter() {
            super(MainActivity.this, R.layout.listview_item, Identifiers);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);
            //checks to see if the view is inflated by the layout

            Identifier currentIdentifier = Identifiers.get(position);

            TextView table = (TextView) view.findViewById(R.id.tableNumber);
            table.setText(currentIdentifier.getTable());

            TextView starter = (TextView) view.findViewById(R.id.oStarter);
            starter.setText(currentIdentifier.getStarter());

            TextView main = (TextView) view.findViewById(R.id.oMain);
            main.setText(currentIdentifier.getMain());

            TextView dessert = (TextView) view.findViewById(R.id.oDessert);
            dessert.setText(currentIdentifier.getDessert());

            return view;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
