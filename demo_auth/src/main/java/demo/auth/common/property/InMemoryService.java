package demo.auth.common.property;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class InMemoryService {

    private static final Map<String, UserDetails> USER_MAP = new HashMap<>();

    public static UserDetails getUser(String user){
        return USER_MAP.get(user);
    }

    public static void addUser(UserDetails user){
        USER_MAP.put(user.getUsername(), user);
    }

//    public static void removeUser(String user){
//        USER_MAP.remove(user);
//    }

}
