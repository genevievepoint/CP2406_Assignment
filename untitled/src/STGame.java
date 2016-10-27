import com.sun.media.jfxmedia.events.PlayerStateEvent;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class STGame {

    private static final int NUM_CARDS_TO_DEAL = 8;
    public static Object currGame;
    private int randomDealer;
    private int numPlayers;
    private STDeck deck;
    int yourPlayerId;
    private int nextPlayerID;
    public STPlayer[] players;
    public int dealerID;

    public STGame(int numPlayers) {
        this.numPlayers = numPlayers ;
        deck = new STDeck();
    }

    public STGame() {

    }

    public int selectDealer() {
        Random rand = new Random();//randomly selecting a dealer
        randomDealer = rand.nextInt((5 - 3)+1)+3;
        //System.out.println("random dealer = " + randomDealer);
        // System.out.println("");
        return randomDealer;
    }

    public void dealRandomCardsToEachPlayer() {
        players = new STPlayer[numPlayers];
        for(int i = 0; i < numPlayers; i++){
            players[i] = new STPlayer("player = " + i);
        }
        for (STPlayer player : players) {
            ArrayList<STCard> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);
        }
    }

    public void selectYouAsPlayer() {
        yourPlayerId = 0 ;
    }

    public STPlayer getHumPlayer() {
        return players[yourPlayerId];
    }

    private int calculateNextPlayerID(int nextPlayer) {
        nextPlayer++;
        if(nextPlayer >= this.numPlayers) {
            nextPlayer = 0;
        }
        return nextPlayer;

    }
    public int getNextPlayerID() {
        return nextPlayerID = setNextPlayerID();
    }
    public int setNextPlayerID() {
        return this.nextPlayerID = calculateNextPlayerID(randomDealer);
    }

    public void dealRandomCards() {
        return;
    }

    public void setHumPlayer() {
        return;
    }

    public static void setNumPlayers(int numPlayers) {

    }
}