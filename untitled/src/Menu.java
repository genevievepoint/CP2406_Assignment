/**
 * Created by Genevieve on 03-Sep-16.
 */
public class Menu {

    private static void startNewGame(){
        int numPlayers = getNumPlayers();
        STGame game = new STGame(numPlayers);
        game.selectDealer();
        game.dealRandomCards();
    }

    private static int getNumPlayers(){
        //// TODO: see prac
        return 2;
    }

    private static int getUserMenuChoice(){
        //// TODO: see prac
        return 1;
    }

    private static void showMenu(){
        System.out.println("1. Start game ");
        System.out.println("2. Exit ");
    }

    private static void showWelcome(){

    }
}
