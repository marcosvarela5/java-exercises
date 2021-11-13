import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkMap implements NetworkManager{

    Map<String, List<TopicOfInterest>> mapName = new HashMap<>();

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if(!mapName.containsKey(user)) mapName.put(user, topicsOfInterest);
        else {
            throw new IllegalArgumentException("This user already exists!");
        }
    }

    @Override
    public void removeUser(String user) {
        mapName.remove(user);
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        if(mapName.containsKey(user) && !mapName.get(user).contains(topicOfInterest)) {mapName.get(user).add(topicOfInterest);}
        else{
            throw new IllegalArgumentException("Can't add a topic to this user");}
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest){
        if(mapName.containsKey(user)){
            mapName.get(user).remove(topicOfInterest);
        }
        else{
            throw new IllegalArgumentException("Can't remove this topic from this user.");
        }
    }

    @Override
    public List<String> getUsers() {
        List<String> userList = new ArrayList<>();
        mapName.forEach((key, value) -> userList.add(key));
        return userList;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> interestList = new ArrayList<>();
        mapName.forEach((key, value) -> interestList.addAll(value));
        return interestList;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        return mapName.get(user);
    }
}
