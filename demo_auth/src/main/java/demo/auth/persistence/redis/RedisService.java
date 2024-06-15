package demo.auth.persistence.redis;

import demo.auth.common.login.bo.LoginUser;

import java.util.HashSet;
import java.util.Set;

public class RedisService {

    private static final Set<LoginUser> USER_SET = new HashSet<>();

    public static Set<LoginUser> getUserSet(){
        return USER_SET;
    }

    public static void addUser(LoginUser user){
        USER_SET.add(user);
    }

    public static void removeUser(LoginUser user){
        USER_SET.remove(user);
    }


}
