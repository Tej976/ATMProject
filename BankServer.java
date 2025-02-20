import java.util.HashMap;
import java.util.Map;

public class BankServer {
    private Map<String, User> users;
    private User loggedInUser ;

    public BankServer() {
        users = new HashMap<>();
        // Adding a sample user
        users.put("user1", new User("user1", "password1", 1000.0));
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser  = user;
            return true;
        }
        return false;
    }

    public void logout() {
        loggedInUser  = null;
    }

    public User getLoggedInUser () {
        return loggedInUser ;
    }
}