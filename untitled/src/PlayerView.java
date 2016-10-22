import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Genevieve on 22-Oct-16.
 */
public class PlayerView extends JPanel{

    STPlayer player;
    JLabel playerName = new JLabel("Not Set");

    public PlayerView(STPlayer player){
        this.player = player;

        add(playerName);

        addAllCards();
    }

    private void addAllCards(){
//        ArrayList<STCard> cards = player.getCards();
        ArrayList<STCard> cards = new ArrayList<>();

        cards.add(new STCard(11, "11"));
        cards.add(new STCard(12, "12"));
        cards.add(new STCard(13, "13"));
        cards.add(new STCard(14, "14"));

        for (int i = 0; i < cards.size(); i++){
            STCard card = cards.get(i);
            CardView cardView = new CardView(card);
            System.out.println("new card i = " + i);
            add(cardView);
        }

        repaint();
    }
}
