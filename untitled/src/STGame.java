/**
 * Created by Genevieve on 03-Sep-16.
 */
public class STGame {
    private int numPlayers;
    private int dealerID;
    private STPlayer[] players;
    private STDeck deck;

    public STGame(int numPlayers){
        this.numPlayers = numPlayers;
    }

    public void selectDealer(){
        // TODO: google how to get random int in Java
        dealerID = 1;
    }

    public void dealRandomCardsToEachPlayer(){
        players = new STPlayer[numPlayers];
        for (STPlayer player : players){
            STCard card = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards();
        }
    }
}
