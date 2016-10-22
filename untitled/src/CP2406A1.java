import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CP2406A1 {

    private static final int NEW_GAME = 1;
    private static final Object PLAYERS = 3;



    public static void main(String[] args)
    {
        showWelcome();
        menu();
        int opt = getUserMenuChoice();
        switch(opt){
            case 1: {
                getNumPlayers();
                startNewGame();
                break;
        }
            case 2 :{
                //how to play
                break;
            }
            case 3:{
                System.exit(opt);
            }
        }

        // import XML
        boolean isRead ;

        // returns true if read the xml file correctly
        // parameters true=> displays the imported file
        isRead = ImportXML.readCardsDetails(true) ;

        // displays the input array
//        System.out.println(ImportXML.myCardsPackMain[2].title);

    }



    private static STGame startNewGame(){
        int numPlayers = getNumPlayers();
        STGame game = new STGame(getNumPlayers());
        game.selectDealer();
        game.dealRandomCardsToEachPlayer();

        game.selectYouAsPlayer();


        STPlayer humPlayer = game.getHumPlayer();
        showPlayer(humPlayer);

        return game;

    }

    private static void showPlayer(STPlayer humPlayer){
        System.out.println("Human player=" + humPlayer);
    }

    private static int getNumPlayers(){
        System.out.println("How many players> ");
        Scanner userInput = new Scanner(System.in);
        int numChoice = userInput.nextInt();

        while (numChoice < 3 || numChoice > 5) {
                System.out.println("How many players> ");
                return numChoice;
            }
            return numChoice;
    }


    private static int getUserMenuChoice(){
        Scanner scanChoice = new Scanner(System.in);
        int choiceentry = scanChoice.nextInt();

        while (choiceentry != 3){
            if(choiceentry == 1){
                return choiceentry;
            }
            else if (choiceentry == 2){
                return choiceentry;
            }
            else if (choiceentry == 3){
                return choiceentry;
            }
            else{
                System.out.println("Enter \"1\", \"2\" or \"3\"");
                choiceentry = scanChoice.nextInt();
            }
        }
        return choiceentry;
    }

    private static void menu(){

        System.out.println("1. Start game ");
        System.out.println("2. Instructions ");
        System.out.println("3. Exit ");
        System.out.println();
        System.out.println("Enter \"1\", \"2\" or \"3\"");
    }

    private static void showWelcome(){
        System.out.println("Welcome to Super Trumps");
    }


    }