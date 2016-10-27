import java.util.ArrayList;
import java.util.List;

public class STPlayer {
    private String s;
    public ArrayList<STCard> cards;
    private int playerId;
    private List<STCard> cardsInHand;

    public STPlayer(int playerId){
        this.playerId = playerId;
    }

    public STPlayer(String s) {
        this.s = s;
    }

    public void setCards(ArrayList<STCard> cards){
        this.cards = cards;
    }

    public String toString(){
        return  "cards= " + cards;
    }

    public List<STCard> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<STCard> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public int getPlayerID() {return playerId;}
    public void setPlayerID(int playerID) {
        this.playerId = playerID;
    }
}