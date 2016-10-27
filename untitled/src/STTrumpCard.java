public class STTrumpCard extends STCard {
    private int id;
    private String title;
    private String type;
    private String subtitle;

    public STTrumpCard(int id,String title,String type,String subtitle){
        super(id, title, type);
        this.subtitle = subtitle;
    }

    public String toString() {
        return "\nid ="+id+" title = "+title+ "    type = " + type+" subtitle = "+subtitle;
    }
}