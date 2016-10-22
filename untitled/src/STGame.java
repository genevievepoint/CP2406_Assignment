import com.sun.media.jfxmedia.events.PlayerStateEvent;

import java.util.ArrayList;
import java.util.Random;

public class STGame {
    private static final int NUM_CARDS_TO_DEAL = 8;
    public static STGame currGame;
    private ArrayList<STCard> cards;
    private int numPlayers;
    private int dealerID;
    private STPlayer[] players;
    private STDeck deck;
    int yourPlayerId;

    public STGame(int numPlayers){
        this.numPlayers = numPlayers;
        deck = new STDeck();

        currGame = this;
    }

    public void selectDealer(){
        Random rand = new Random();
        int i = new Random().nextInt(2);
        dealerID = 1;
    }

    public boolean validCardToPlay(){
        return true;
    }

    public void dealRandomCardsToEachPlayer(){

        players = new STPlayer[numPlayers];
//        players = new STPlayer[1];

        for (int i = 0; i < numPlayers; i++){
            players[i] = new STPlayer("PlayerId= " + i);
        }
//        for (STPlayer player : players){
//            ArrayList<STCard> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
//            player.setCards(cards);
//        }
    }
    public void selectYouAsPlayer(){
        yourPlayerId = 0;
    }
    public STPlayer getHumPlayer(){
        return players[yourPlayerId];
    }

//    public int getNumPlayers(){ return numPlayers}
    public void playTheGame() {

    }

    public boolean validCardToPlay(STCard card) {
        return true;
    }

    public boolean playCard(STCard card) {
        //play card by human
        //loop over the rest of bots
        STMainGUI.mainUI.reload();
        //and wait 1 sec
        return true;

    }

    public void setCurrentCard(STCard card) {

    }
}
