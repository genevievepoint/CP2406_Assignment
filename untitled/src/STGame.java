import com.sun.media.jfxmedia.events.PlayerStateEvent;

import java.util.ArrayList;
import java.util.Random;

public class STGame {
    private static final int NUM_CARDS_TO_DEAL = 8;
    private ArrayList<STCard> cards;
    private int numPlayers;
    private int dealerID;
    private STPlayer[] players;
    private STDeck deck;
    int yourPlayerId;

    public STGame(int numPlayers){
        this.numPlayers = numPlayers;
        deck = new STDeck();
    }

    public void selectDealer(){
        Random rand = new Random();
        int i = new Random().nextInt(2);
        dealerID = 1;
    }

    public void dealRandomCardsToEachPlayer(){

        players = new STPlayer[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            players[i] = new STPlayer("PlayerId= " + i);
        }
        for (STPlayer player : players){
            ArrayList<STCard> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);
        }
    }
    public void selectYouAsPlayer(){
        yourPlayerId = 0;
    }
    public STPlayer getHumPlayer(){
        return players[yourPlayerId];
    }
//    private int getNumPlayers(){ return numPlayers}
    public void playTheGame(){
        boolean gameIsOn = true;

//        while(gameIsOn) {
//            Players players = numPlayers.values().toArray(new Players[numPlayers.size()]);
//            String[] playerNames = numPlayers.keySet().toArray(new String[numPlayers.size()]);
//            for(int idxPlayer = 0; idxPlayer < players.length; idxPlayer++){
//            }
        }
    }
