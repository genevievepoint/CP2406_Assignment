import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Genevieve on 27-Oct-16.
 */
public class STMenuView {

    private JFrame frame;
    private JPanel panel;
    private JButton instructionsButton;
    private JButton playGameButton;
    private JComboBox selectPlayers;
    public static int PLAYERCOUNT;

    public static STGame game = new STGame();

    public STMenuView() {

        frame = new JFrame("SUPER TRUMPS CARD GAME");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    panel = new JPanel();
        panel.setBackground(Color.gray);
    selectPlayers = new JComboBox();
    instructionsButton = new JButton("INSTRUCTIONS");
        instructionsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame2 = new JFrame("INSTRUCTIONS");
            frame2.setVisible(true);
            frame2.setSize(600, 700);
            JPanel panel2 = new JPanel();
            panel2.setVisible(true);
            JTextArea area = new JTextArea();
            area.setEditable(false);
            area.append(CP2406A1.instructions());
            panel2.add(area);
            frame2.add(panel2);
        }
    });
    playGameButton = new JButton("Play Game");
        playGameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            game.selectDealer();
            game.dealRandomCards();
            game.setHumPlayer();
            try {
                GameGuiFrame gameGuiFrame = new GameGuiFrame(game.players);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            //game logic
        }

    });
    JLabel numberOfPlayersString = new JLabel("Select the number of players");
        selectPlayers.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String stringNumPlayers = selectPlayers.getSelectedItem().toString();
            int numPlayers = Integer.parseInt(stringNumPlayers);
            STGame.setNumPlayers(numPlayers);
        }
    });
        selectPlayers.addItem(2);
        selectPlayers.addItem(3);
        selectPlayers.addItem(4);
        panel.add(instructionsButton);
        panel.add(playGameButton);
        panel.add(numberOfPlayersString);
        panel.add(selectPlayers);
        frame.add(panel);
        frame.revalidate();
}
    public static void aiPlayCard() {
        Random rand = new Random();
//        PLAYERCOUNT ++;
        if (rand.nextInt(10) < 5) {
            JOptionPane.showMessageDialog(null, "Computer Can play a card");
            STCard aiCard = game.players[1].cards.remove(rand.nextInt(game.players[1].cards.size()));
            if (STMenuView.game.players[1].cards.size() == 0) {
                JOptionPane.showMessageDialog(null, "COMPUTER WINS!");
                System.exit(1);
            }
            try {
                CardImg card3 = new CardImg(aiCard);
                CardTable.currCardView.setIcon(new ImageIcon(card3.cardImage));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else {JOptionPane.showMessageDialog(null, "Computer Cannot play a card");

        }

    }
}
