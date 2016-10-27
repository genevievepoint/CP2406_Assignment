import javax.swing.*;
import java.util.ArrayList;

public class PlayerView extends JPanel {

    private static final int NUM_OF_PLAYER_CARDS = 60;
    STPlayer player;
    JLabel playerName = new JLabel("Not Set");

    public PlayerView(STPlayer player) {
        this.player = player;

        add(playerName);

        addAllCards();
    }

    public PlayerView(int i) {
        this.player = player;
    }

    private void addAllCards() {
//        ArrayList<STCard> cards = player.getCards();
        ArrayList<STCard> cards = new ArrayList<>();
        for (int i = 0; i < NUM_OF_PLAYER_CARDS; i++) {

            cards.add(new STCard(i, "Quataz", "P"));
            cards.add(new STCard(i, "Plagioclase", "P"));
            cards.add(new STCard(i, "Orthoclase", "P"));
            cards.add(new STCard(i, "Biotite", "P"));
            cards.add(new STCard(i, "Muscovite", "P"));
            cards.add(new STCard(i, "Hornblende", "P"));
            cards.add(new STCard(i, "Actinolite", "P"));
            cards.add(new STCard(i, "Glaucophane", "P"));
            cards.add(new STCard(i, "Olivine", "P"));
            cards.add(new STCard(i, "Garnet", "P"));
            cards.add(new STCard(i, "Titanite", "P"));
            cards.add(new STCard(i, "Zircon", "P"));
            cards.add(new STCard(i, "Augite", "P"));
            cards.add(new STCard(i, "Orthopyroxene", "P"));
            cards.add(new STCard(i, "Chlorite", "P"));
            cards.add(new STCard(i, "Antigorite", "P"));
            cards.add(new STCard(i, "Talc", "P"));
            cards.add(new STCard(i, "Kaolinite", "P"));
            cards.add(new STCard(i, "Andalusite", "P"));
            cards.add(new STCard(i, "Kyanite", "P"));
            cards.add(new STCard(i, "Sillimanite", "P"));
            cards.add(new STCard(i, "Staurolite", "P"));
            cards.add(new STCard(i, "Epidote", "P"));
            cards.add(new STCard(i, "Tourmaline", "P"));
            cards.add(new STCard(i, "Topaz", "P"));
            cards.add(new STCard(i, "Beryl", "P"));
            cards.add(new STCard(i, "Pyrite", "P"));
            cards.add(new STCard(i, "Pyrrhotite", "P"));
            cards.add(new STCard(i, "Chalcopyrite", "P"));
            cards.add(new STCard(i, "Galena", "P"));
            cards.add(new STCard(i, "Sphalerite", "P"));
            cards.add(new STCard(i, "Molybdenite", "P"));
            cards.add(new STCard(i, "Gold", "P"));
            cards.add(new STCard(i, "Diamond", "P"));
            cards.add(new STCard(i, "Graphite", "P"));
            cards.add(new STCard(i, "Halite", "P"));
            cards.add(new STCard(i, "Fluorite", "P"));
            cards.add(new STCard(i, "Gypsum", "P"));
            cards.add(new STCard(i, "Barite", "P"));
            cards.add(new STCard(i, "Apatite", "P"));
            cards.add(new STCard(i, "Monazite", "P"));
            cards.add(new STCard(i, "Calcite", "P"));
            cards.add(new STCard(i, "Dolomite", "P"));
            cards.add(new STCard(i, "Magnesite", "P"));
            cards.add(new STCard(i, "Siderite", "P"));
            cards.add(new STCard(i, "Magnetite", "P"));
            cards.add(new STCard(i, "Hematite", "P"));
            cards.add(new STCard(i, "Chromite", "P"));
            cards.add(new STCard(i, "Ilmenite", "P"));
            cards.add(new STCard(i, "Rutile", "P"));
            cards.add(new STCard(i, "Corundum", "P"));
            cards.add(new STCard(i, "Cassiterite", "P"));
            cards.add(new STCard(i, "Gibbsite", "P"));
            cards.add(new STCard(i, "Goethite", "P"));
//            cards.add(new STCard(i, "The Miner", "T", "Economic value"));
//            cards.add(new STCard(i, "The Petrologist", "T", "Crustal abundance"));
//            cards.add(new STCard(i, "The Gemmologist", "T", "Hardness"));
//            cards.add(new STCard(i, "The Mineralogist", "T", "Cleavage"));
//            cards.add(new STCard(i, "The Geophysicist", "T", "Specific gravity"));
//            cards.add(new STCard(i, "The Geologist", "T", "Change to trumps category of your choice"));
//        }
//    }}
            STCard card = cards.get(i);
            CardView cardView = new CardView(card);
            System.out.println("new card i = " + i);
            add(cardView);
        }

        repaint();
    }
}
