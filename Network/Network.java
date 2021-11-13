import java.util.List;

public class Network implements NetworkManager {
    NetworkManager network;
    Network(NetworkManager implementation) {
        this.network = implementation;
    }

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        network.addUser(user, topicsOfInterest);
    }

    @Override
    public void removeUser(String user) {
        network.removeUser(user);
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        network.addInterest(user, topicOfInterest);
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        network.removeInterest(user, topicOfInterest);
    }

    @Override
    public List<String> getUsers() {
        return network.getUsers();
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        return network.getInterests();
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        return network.getInterestsUser(user);
    }
}
