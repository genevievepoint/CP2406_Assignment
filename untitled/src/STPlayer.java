import java.util.ArrayList;

public class STPlayer {
    private ArrayList<STCard> cards;
    private String playerId;

    public STPlayer(String playerId){
        this.playerId = playerId;
    }

    public void setCards(ArrayList<STCard> cards){
        this.cards = cards;
    }

    public ArrayList<STCard> getCards() {
        return cards;
    }

    public String toString(){
        return "PlayedID= " + playerId + "\n cards=" + cards;
    }


}
