
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class STMainGUI extends JFrame {
    // JFrame properties
    final int WIDTH = 1200;
    final int HEIGHT = 700;
    STGame game;

    Container con = this.getContentPane();
    JPanel welcomePanel = new JPanel();
    JPanel playPanel = new JPanel();

    //Labels
    JLabel question = new JLabel("Enter the Players");
    JTextField answer = new JTextField(10);
    // Buttons
    JButton newGameBtn = new JButton("START A NEW GAME");


    public static void main(String[] args) {
        STMainGUI frame = new STMainGUI();
        frame.setVisible(true);
    }

    public STMainGUI() {
        //title,size and layout of the JFrame
        super("THE MINERAL SUPER TRUMP GAME");
        setSize(WIDTH, HEIGHT);

        //welcome label font size

        //container and set properties
        con.setLayout(new FlowLayout());
        con.setBackground(new Color(0, 155, 0));

        getNumberOfPlayers();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void getNumberOfPlayers() {
        //New Panel properties

        welcomePanel.setLayout(new GridLayout());
        welcomePanel.setBackground(new Color(0, 156, 0));
        con.add(welcomePanel);

        welcomePanel.add(question);
        welcomePanel.add(answer);

        String numOfPlayers = answer.getText();

        //Adding new game button to the Panel and its action
        welcomePanel.add(newGameBtn);

        newGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(welcomePanel);
                con.revalidate();
                con.repaint();

                playTheGame();
            }
        });
    }

    private void playTheGame() {
        playPanel.setBackground(new Color(0, 156, 0));
        playPanel.setLayout(new BorderLayout());
        con.add(playPanel);

        int numOfPlayers = Integer.parseInt(answer.getText());

        JLabel playersLabel = new JLabel("Number of players are " + numOfPlayers);
        playPanel.add(playersLabel, BorderLayout.NORTH);

        STGame game = new STGame(numOfPlayers);
        JLabel dealerLabel = new JLabel("The Dealer is " +  game.selectDealer());
        playPanel.add(dealerLabel, BorderLayout.CENTER);

        JLabel nextPlayer = new JLabel("Next Player is "+ game.getNextPlayerID());
        playPanel.add(nextPlayer, BorderLayout.SOUTH);

        game.dealRandomCardsToEachPlayer(); // randomly deal 8 cards to each player
        game.selectYouAsPlayer(); // show user player id
        STPlayer humPlayer = game.getHumPlayer();


        JLabel userPlayer = new JLabel(String.valueOf(humPlayer));
        con.add(userPlayer, BorderLayout.SOUTH);
    }

}
