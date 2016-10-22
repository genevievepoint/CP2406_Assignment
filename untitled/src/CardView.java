import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Genevieve on 22-Oct-16.
 */
public class CardView extends JPanel{
    STCard card;
    JLabel cardName;

    public CardView(final STCard card){
        this.card = card;
        cardName = new JLabel(cardName.getName() + " id" + card.getId());
        add(cardName);

        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                STGame.currGame.validCardToPlay(card);
                cardName.setText("I was clicked");
            }
        });

//        Load images

    }

}
