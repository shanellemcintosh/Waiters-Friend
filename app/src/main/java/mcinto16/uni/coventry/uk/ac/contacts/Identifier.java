package mcinto16.uni.coventry.uk.ac.contacts;

/**
 * Created by Shans' on 3/12/2015.
 */
public class Identifier {

    private String _table, _starter, _main, _dessert;

    public Identifier(String table, String starter, String main, String dessert) {

        _table = table;
        _starter = starter;
        _main = main;
        _dessert = dessert;
    }


    public String getTable() {
        return _table;
    }

    public String getStarter() {return _starter;}

    public String getMain() {
        return _main;
    }

    public String getDessert() {
        return _dessert;
    }


}


