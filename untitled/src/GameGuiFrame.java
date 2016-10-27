import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.sun.glass.ui.Cursor.setVisible;

public class GameGuiFrame extends JFrame {
//    public HumanCardsPanel humanCardsPanel;
    STPlayer player;
    public CardTable cardTable = new CardTable();

    public GameGuiFrame(STPlayer[] players) throws IOException {
        super("SUPER TRUMPS GAME");
//        humanCardsPanel = new HumanCardsPanel(players[0]);
        setLayout(new BorderLayout());
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

//        JScrollPane playerViewScroll = new JScrollPane(humanCardsPanel,
//                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);


//        add(playerViewScroll, BorderLayout.SOUTH);
        add(cardTable, BorderLayout.NORTH);
        add(cardTable, BorderLayout.CENTER);


    }

}