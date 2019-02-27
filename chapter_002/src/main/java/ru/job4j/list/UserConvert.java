package ru.job4j.list;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class UserConvert {
    public HashMap<Integer,User> process (List<User> list) {
        Map<Integer, User> users = new HashMap<>();
          for (User user : list) {
                users.put(user.getId(),user);
          }
        return (HashMap <Integer, User>) users;
    }
}
