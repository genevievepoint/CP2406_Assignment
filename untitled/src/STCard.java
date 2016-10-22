
public class STCard {
    private int id;
    private String name;


//    public STCard(int id){
//        this.id = id;
//    }


    public STCard(int i, String s){
        id = i;
        name = s;
    }

    public STCard(int i) {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return "id=" + id;
    }


}
