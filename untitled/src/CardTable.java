import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CardTable extends JPanel {

    public static JLabel currCardView;

    public CardTable() throws IOException{

        super();
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 400, 200));
        setBackground(Color.BLUE);
//        CardView =  new JLabel("Current card");
        JLabel currCategory = new JLabel("Current category" + new SelectCategoryGUI().getCategory());
        add(currCategory);
//        add(CardView);

    }
}

