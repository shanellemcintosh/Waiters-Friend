package mcinto16.uni.coventry.uk.ac.contacts;

/**
 * Created by Shans' on 3/12/2015.
 */
public class Identifier {

    private String _table, _starter, _main, _dessert;
    private String _sAmount, _mAmount, _dAmount;

    public Identifier (String table, String starter, String main, String dessert, String starterA, String mainA, String dessertA) {

        _table = table;
        _starter = starter;
        _main = main;
        _dessert = dessert;
        _sAmount = starterA;
        _mAmount = mainA;
        _dAmount = dessertA;
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

    public String getStarterA() { return _sAmount;}

    public String getMainA() {return _mAmount;}

    public String getDessertA() {return _dAmount;}


}


