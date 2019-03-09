package ru.job4j.collection;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.Comparator;
        import java.util.Collection;
        import java.util.List;
        import java.util.Set;
        import java.util.TreeSet;
public class SortUser {
    public Set<User> sort(List<User> user) {
        Set<User> users = new TreeSet<>();
        for (User use : users){
            users.add(use);
        }
        return users;
    }
    public List<User> sortNameLength(List<User>user) {
        Set<User> users = new TreeSet<>();
        for (User use : user) {
            user.sort(
                    new Comparator <User>() {
                        @Override
                        public int compare(User o1, User o2) {
                            return o1.getName().length() - o2.getName().length();
                        }
                    }
            );
            users.add(use);
        }
        return (List <User>) users;
    }
}
