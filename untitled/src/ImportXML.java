/**
 * Created by Genevieve on 03-Oct-16.
 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class ImportXML
{

    public  static final int NUMBER_OF_CARDS = 60 ;     // Number of cards in the pack
    // myCardsPackMain[0] is empty, myCardsPackMain[1-60] filled with carddetails
    public  static CardDetails[] myCardsPackMain = new CardDetails[ NUMBER_OF_CARDS + 1  ] ;  // Main Card Pack

    private static final String XML_FILE = "MstCards_151021.xml" ; //"MstCards_151021.xml" ;



    // Read XML file and copy it to card pack
    public static boolean readCardsDetails(boolean pDisplay)    // MyCard[] pCardsPackMain
    {
        boolean isFileRead = false ;
        String myKey, myString ;
        myCardsPackMain[0] = new CardDetails() ;     // Pack starts from 1, leave 0 empty

        try
        {
            File myXmlFile = new File( XML_FILE ) ;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance() ;
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder() ;
            Document myDoc = docBuilder.parse( myXmlFile ) ;
            myDoc.getDocumentElement().normalize() ;
            NodeList nodeList = myDoc.getElementsByTagName( "dict" ) ;
            //System.out.println("Root : " + myDoc.getDocumentElement().getNodeName());


            for (int i=0; i < NUMBER_OF_CARDS; i++ )
            {
                Node myNode = nodeList.item( i ) ;
                // " Element : " + myNode.getNodeName()
                if ( pDisplay )
                {
                    System.out.println( i+1 );
                }

                if ( myNode.getNodeType() == Node.ELEMENT_NODE )
                {
                    myCardsPackMain[ i+1 ] = new CardDetails() ;
                    Element myElement = ( Element ) myNode ;

                    //System.out.println("Staff id : " + myElement.getAttribute("id"));
                    int j=0, keyCounter=0, stringCounter=0 ;
                    while ( j < ( myElement.getElementsByTagName( "key" ).getLength() - 1 ) )
                    {
                        myKey = myElement.getElementsByTagName( "key" ).item( keyCounter ).getTextContent() ;
                        keyCounter++ ;

                        if ( myKey.equals( "card_type" ) ) //( j == 2 )
                        {
                            // two <key> tags are found in the 3rd row (card_type)
                            myString = myElement.getElementsByTagName( "key" ).item( keyCounter ).getTextContent() ;
                            keyCounter++ ;
                        }
                        else
                        {
                            myString = myElement.getElementsByTagName( "string" ).item( stringCounter ).getTextContent() ;
                            stringCounter++ ;
                            if ( myKey.equals("occurrence")) //( j == 7 )
                            {
                                // three <string> tags are found in the 8th row (occurrence)
                                while ( myElement.getElementsByTagName( "string" ).item( stringCounter ).getParentNode().getNodeName()
                                        == "array" )
                                {
                                    myString += ", " + myElement.getElementsByTagName( "string" ).item( stringCounter ).getTextContent() ;
                                    stringCounter++ ;
                                }
                            }
                        }

                        // Display card information
                        if ( pDisplay )
                        {
                            System.out.print(j);
                            System.out.print("\t" + myKey);
                            System.out.print("\t" + myString);
                            System.out.println("");
                        }

                        myCardsPackMain[i+1].set( myKey, myString ) ;
                        j++ ;
                    }
                    if ( pDisplay )
                    {
                        System.out.println( "-----------------------" ) ;
                    }
                }
            }

            if (pDisplay)
            {
                for (int i=0; i <= NUMBER_OF_CARDS; i++ )
                {
                    myCardsPackMain[i].displayAll();
                    System.out.println("-----------------\n");
                }
            }
            isFileRead = true ;
        }
        catch ( Exception e )
        {
            System.out.println( e ) ;
        }

        return ( isFileRead ) ;
    }

}