package com.expensetracker;
import java.util.HashMap;
import java.util.Map;

public class UserService {
	
    private Map<String, User> users = new HashMap<>();
    
    public boolean registerUser(String username, String password) {

        if (users.containsKey(username)) {
            return false; 
        }
        
        users.put(username, new User(username, password));
        return true;
    }
    
    public User loginUser(String username, String password) {
        
    	User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
