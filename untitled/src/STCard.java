import jdk.nashorn.internal.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.print.attribute.standard.ReferenceUriSchemesSupported.FILE;

public class STCard {
    private int id;
    private String cardTitle = "";
    private String cardChemistry = "";
    private String cardClassification = "";
    private String cardCrystalSystem = "";
    private String cardOccurence = "";
    private String cardHardness = "";
    private String cardSpecificGravity = "";
    private String cardClevage = "";
    private String cardCrustalAbundance = "";
    private String cardEconomicValue = "";

    public STCard(int id){
        this.id = id;
    }


    public String toString(){
        return "id=" + id;
    }

//    private static CVSUtils loadCards() {
//        CVSUtils cards = new CVSUtils();
//        return cards;
//    }


}
