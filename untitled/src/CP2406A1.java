import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CP2406A1 {

    private static final int NEW_GAME = 1;



    public static void main(String[] args)
    {

        showWelcome();
        menu();
        int opt = getUserMenuChoice();
        STGame game;
        if (opt == NEW_GAME) {
            game = startNewGame();
            game.playTheGame();
        }

        // import XML
        boolean isRead ;

        // returns true if read the xml file correctly
        // parameters true=> displays the imported file
        isRead = ImportXML.readCardsDetails(true) ;

        // displays the input array
        System.out.println(ImportXML.myCardsPackMain[2].title);

    }
//
//    }

    private static STGame startNewGame(){
        int numPlayers = getNumPlayers();
        STGame game = new STGame(numPlayers);
        game.selectDealer();
        game.dealRandomCardsToEachPlayer();

        game.selectYouAsPlayer();

        STPlayer humPlayer = game.getHumPlayer();
        showPlayer(humPlayer);

//        game.playTheGame();
        return game;

    }

    private static void showPlayer(STPlayer humPlayer){
        System.out.println("Human player=" + humPlayer);
    }

    private static int getNumPlayers(){
        //// TODO: see prac how to get number
        return 2;
    }

    private static int getUserMenuChoice(){
        //// TODO: see prac
        return 1;
    }

    private static int menu(){
        System.out.println("1. Start game ");
        System.out.println("2. Instructions ");
        System.out.println("3. Exit ");
        Scanner scanchoice = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter \"1\", \"2\" or \"3\"");
        int choiceentry = scanchoice.nextInt();

        while (choiceentry != 3){
            else if(choiceentry == 1){
                STGame startNewGame;
            }
            else if (choiceentry == 2){
                //instruction
            }
            else if (choiceentry == 3){
                //exit
            }
            else{
                System.out.println("Enter \"1\", \"2\" or \"3\"");
                choiceentry = scanchoice.nextInt();
            }
        }
        return selection;
    }

    private static void showWelcome(){
        System.out.println("Welcome to Super Trumps");
    }


    }