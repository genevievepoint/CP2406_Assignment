import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CP2406A1 {

    private static final int NEW_GAME = 1;

    public CP2406A1() {
    }

    public static void main(String[] args){

//        loadCards();
        showWelcome();
        showMenu();
        int opt = getUserMenuChoice();
        STGame game;
        if (opt == NEW_GAME) {
            game = startNewGame();
            game.playTheGame();
        }
    }

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

    private static void showMenu(){
        System.out.println("1. Start game ");
        System.out.println("2. Instructions ");
        System.out.println("3. Exit ");
    }

    private static void showWelcome(){
        System.out.println("Welcome to Super Trumps");
    }

//    private static String loadCards(CVSUtils){
//        loadCards = new CVSUtils();
//        System.out.println(someLine);
//
///
//    }

}
