
//public class STCard {
//    private int id;
//
//    public STCard(int id){
//        this.id = id;
//    }
//
//
//    public String toString(){
//        return "id=" + id;
//    }


public class STCard {
    private int id;
    private String title;
    private String type;

    public STCard(int id,String title,String type){
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public String toString() {
        return "title = "+title+ " type = " + type;
    }
}
