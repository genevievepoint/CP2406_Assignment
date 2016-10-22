
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Genevieve on 22-Oct-16.
 */
public class STMainGUI extends JFrame {

    JLabel question = new JLabel("Number of players");
    Font bigFont = new Font ("Arial", Font.BOLD, 16);
    JTextField answer = new JTextField(10);
    JButton pressMe = new JButton("NEW GAME");
    JLabel greeting = new JLabel("");
    final int WIDTH = 275;
    final int HEIGHT = 225;

    private STGame game;
    PlayerView playerView;

    public static void main(String[] args){
        STMainGUI frame = new STMainGUI();
        frame.setVisible(true);
    }

    public STMainGUI(){
        super("ST Game");
        setSize(WIDTH, HEIGHT);
//        setLayout(new FlowLayout());
        question.setFont(bigFont);
        greeting.setFont(bigFont);
        add(question, BorderLayout.NORTH);
        add(answer, BorderLayout.WEST);
        add(pressMe, BorderLayout.SOUTH);
        pressMe.setToolTipText("I do not have any info, sorry");
        add(greeting, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pressMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ////Todo get number of players from textfield

                game = new STGame(4);
                game.selectDealer();
                game.dealRandomCardsToEachPlayer();

                game.selectYouAsPlayer();

                STPlayer humanPlayer = game.getHumPlayer();

                if (playerView != null){
                    remove(playerView);
                }

                playerView = new PlayerView(humanPlayer);
                //remove item from location

                add(playerView, BorderLayout.CENTER);
//                How to trigger repaint


                System.out.println("WHAAAATTTT");
            }
        });
//        pressMe.addActionListener(new MyActivateButton());

    }
}
