
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class STMainGUI extends JFrame {
 
    public static STMainGUI mainUI;
    JLabel question = new JLabel("Number of players");
    Font bigFont = new Font ("Arial", Font.BOLD, 16);
    JTextField answer = new JTextField(10);
    JButton pressMe = new JButton("NEW GAME");
    JLabel greeting = new JLabel("");
    final int WIDTH = 500;
    final int HEIGHT = 500;

    private STGame game;
    PlayerView playerView;

    public static void main(String[] args){
        STMainGUI frame = new STMainGUI();
        frame.setVisible(true);
    }

    public STMainGUI(){
        super("Super Trumps Game");
        mainUI = this;
        setSize(WIDTH, HEIGHT);
        question.setFont(bigFont);
        greeting.setFont(bigFont);
        final JPanel panel1 = new JPanel();

        panel1.add(question);
        panel1.add(answer);
        add(panel1, BorderLayout.NORTH);
//        add(question, BorderLayout.NORTH);
//        add(answer, BorderLayout.WEST);
        add(pressMe, BorderLayout.SOUTH);
        pressMe.setToolTipText("I do not have any info, sorry");
        add(greeting, BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pressMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(pressMe);
                remove(panel1);
                revalidate();
                repaint();

                String textFieldValue = answer.getText();
                int numOfPlayers = Integer.parseInt(textFieldValue);


                System.out.println("WHAAAATTTT!!!");
            }
        });
//        pressMe.addActionListener(new MyActivateButton());

    }

    public void reload() {
        if (playerView != null){
            remove(playerView);
        }
//        todo: add panel currentCardView
        STPlayer humanPlayer = game.getHumPlayer();

        playerView = new PlayerView(humanPlayer);
        add(playerView, BorderLayout.CENTER);
    }
}
