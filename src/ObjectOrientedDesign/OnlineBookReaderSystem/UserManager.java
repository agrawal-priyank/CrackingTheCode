package ObjectOrientedDesign.OnlineBookReaderSystem;

import java.util.HashMap;

public class UserManager {

    private HashMap<Integer, User> users;

    public User addUser(int id, String details, int accountType){
        if(users.containsKey(id)){
            return null;
        }
        User user = new User(id, details, accountType);
        users.put(id, user);
        return user;
    }

    public boolean removeUser(User u){
        return remove(u.getId());
    }

    public boolean remove(int id){
        if(!users.containsKey(id)){
            return false;
        }
        users.remove(id);
        return true;
    }

    public User findUser(int id){
        return users.get(id);
    }

}