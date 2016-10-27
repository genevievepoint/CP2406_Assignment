import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardImg extends JPanel{
    BufferedImage cardImage;
    String workingDirectory = System.getProperty("user.dir");
    JButton cardView;
    JLabel currentCardView = CardTable.currCardView;
    fileName = ("C:\\Users\\Genevieve\\IdeaProjects\\CP2406_Assignment\\untitled\\src\\images");


    public CardImg(STCard card) throws IOException {
        try {
            cardImage = ImageIO.read(new File(workingDirectory + "/res/" + card.fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        cardImage = cardResize(cardImage, 100, 150, BufferedImage.TYPE_INT_ARGB);//250, 350
        cardView = new JButton(new ImageIcon(cardImage));
        add(cardView);
        cardView.addActionListener(e -> {
            STMenuView.game.players[0].cards.size();
            currentCardView.setIcon(new ImageIcon(cardImage));
            remove(cardView);
            STMenuView.game.players[0].cards.remove(card);
            System.out.println(STMenuView.game.players[0].cards.size());
            revalidate();
            if (STMenuView.game.players[0].cards.size() == 0) {
                JOptionPane.showMessageDialog(null, "CONGRATULATIONS YOU WON!");
                System.exit(1);
            }
            JOptionPane.showMessageDialog(null, "Computer is selecting a card to play");
            STMenuView.aiPlayCard();
            revalidate();
        });
    }

    private BufferedImage cardResize(BufferedImage cardImage, int i, int i1, int typeIntArgb) {
        BufferedImage cardResized = new BufferedImage(i, i1, typeIntArgb);
        Graphics2D g = cardResized.createGraphics();
        g.drawImage(cardImage, 0, 0, i, i1, null);
        g.dispose();
        return cardResized;
    }

}
//}
