public class TopicOfInterest {
    private final String name;

    TopicOfInterest(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return this.getName();
    }

}
