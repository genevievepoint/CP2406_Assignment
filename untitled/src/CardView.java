import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Genevieve on 22-Oct-16.
 */
public class CardView extends JPanel{
    final STCard card;
    JLabel cardName;

    public CardView(final STCard card){
        this.card = card;
        cardName = new JLabel(cardName.getName() + " id" + card.getId());
        add(cardName);

//        card.getImage();

//        addMouseListener(new MouseInputAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//
//                STGame.currGame.validCardToPlay(card);
//                cardName.setText("I was clicked");
        addMouseListener(new MyMouse());
            }
//        });



//        Load images

    class MyMouse extends MouseInputAdapter{
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            STGame game = STGame.currGame;
            boolean ok = STGame.currGame.validCardToPlay(card);
            if (!ok){
                cardName.setText("Not OK to play");
            }

            game.getHumPlayer().getCards().remove(card);
//            game.setCurrentCard(card);

            STMainGUI.mainUI.reload();
            game.playCard(card);
            cardName.setText("I was clicked");

        }


//        Place card to play table
//        remove card from player

    }

    }
