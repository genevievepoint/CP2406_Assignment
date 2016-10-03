/**
 * Created by Genevieve on 03-Oct-16.
 */
/**
 *
 * Card Details
 */

public class CardDetails{

    public String fileName ;
    public String imageName ;
    public String cardType ;
    public String title ;
    public String chemistry ;
    public String classification ;
    public String crystalSystem ;
    public String occurrence ;
    public String hardness ;
    public String specificGravity ;
    public String cleavage ;
    public String crustalAbundance ;
    public String economicValue ;

    public String subTitle ;                // only for 6 trump cards
    public double hardnessDouble ;          // String of double hardness
    public double specificGravityDouble ;   // String of double specific gravity



    public void set(String pKey, String pString )
    {
        if      ( pKey.equals( "fileName" ) )        fileName = pString ;
        else if ( pKey.equals( "imageName") )        imageName = pString ;
        else if ( pKey.equals( "card_type") )        cardType = pString ;
        else if ( pKey.equals( "title") )            title = pString ;
        else if ( pKey.equals( "chemistry") )        chemistry = pString ;
        else if ( pKey.equals( "classification") )   classification = pString ;
        else if ( pKey.equals( "crystal_system") )   crystalSystem = pString ;
        else if ( pKey.equals( "occurrence") )       occurrence = pString ;
        else if ( pKey.equals( "cleavage") )         cleavage = pString ;
        else if ( pKey.equals( "crustal_abundance")) crustalAbundance = pString ;
        else if ( pKey.equals( "economic_value") )   economicValue = pString ;
        else if ( pKey.equals( "subtitle") )         subTitle = pString ;
        else if ( pKey.equals( "hardness") )
        {
            hardness = pString ;
            hardnessDouble = Double.parseDouble( findRest( pString, "- " ) ) ;
        }
        else if ( pKey.equals( "specific_gravity") )
        {
            specificGravity = pString ;
            specificGravityDouble = Double.parseDouble( findRest( pString, "- " ) ) ;
        }
    }


    public void displayAll()
    {
        System.out.println( "File Name :\t\t" +        fileName ) ;
        System.out.println( "Image Name :\t\t" +       imageName ) ;
        System.out.println( "Card Type :\t\t" +        cardType ) ;
        System.out.println( "Title :\t\t" +            title ) ;
        System.out.println( "Chemistry :\t\t" +        chemistry    ) ;
        System.out.println( "Classification :\t\t" +   classification ) ;
        System.out.println( "CrystalSystem :\t\t" +    crystalSystem ) ;
        System.out.println( "Occurrence :\t\t" +       occurrence) ;
        System.out.println( "Hardness  :\t\t" +        hardness ) ;
        System.out.println( "Specific Gravity :\t\t" + specificGravity ) ;
        System.out.println( "Cleavage :\t\t" +         cleavage ) ;
        System.out.println( "Crustal Abundance :\t\t"+ crustalAbundance ) ;
        System.out.println( "Economic Value :\t\t" +   economicValue ) ;
        System.out.println( "Sub Title  :\t\t" +       subTitle ) ;
    }


    public boolean isCategoryHigher( int pCategoryNumber, double pCurrentValue  )
    {
        boolean myFound = false ;
        switch (pCategoryNumber)
        {
            case 1 :    // hardness
                myFound = hardnessDouble > pCurrentValue ;
                break ;
            case 2 :
                myFound = specificGravityDouble > pCurrentValue ;
                break ;
            default :
                break ;
        }
        return myFound ;
    }



    // Search for a character and returns the rest
    public static String findRest( String pString, String pFindChar )
    {
        int myFound = -1 ;
        String myRest ;

        for (int i=0; i<pFindChar.length(); i++)
        {
            myFound = pString.indexOf( pFindChar.charAt(i) ) ;
            if ( myFound >= 0 )
            {
                break ;
            }
        }
        myRest = pString.substring( myFound + 1 ) ;
        return ( myRest ) ;
    }


}