import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class STCard {
    private int id;
    private String[] cardTitle = {};
    private String[] cardChemistry = {};
    private String[] cardClassification = {};
    private String[] cardCrystalSystem = {};
    private String[] cardOccurence = {};
    private String[] cardHardness = {};
    private String[] cardSpecificGravity = {};
    private String[] cardClevage = {};
    private String[] cardCrustalAbundance = {};
    private String[] cardEconomicValue = {};

    public STCard(int id){
        this.id = id;
    }

    public String toString(){
        return "id=" + id;
    }

}
