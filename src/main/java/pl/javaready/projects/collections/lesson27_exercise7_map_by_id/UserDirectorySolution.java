package pl.javaready.projects.collections.lesson27_exercise7_map_by_id;

import java.util.HashMap;
import java.util.Map;

public class UserDirectorySolution {

    public static void main(String[] args) {
        Map<Integer, User> users = new HashMap<>();

        // 1: the key is the id, the value is the whole object
        users.put(5, new User(5, "Ann"));
        users.put(7, new User(7, "Tom"));
        users.put(9, new User(9, "Eve"));

        // 2
        User found = users.get(7);
        System.out.println(found.getName());   // Tom

        // 3: get() returns null for a missing key, so check before using the result
        User missing = users.get(100);
        if (missing == null) {
            System.out.println("no such user");
        } else {
            System.out.println(missing.getName());
        }

        // 4
        users.remove(5);
        System.out.println(users.size());   // 2

        // 5
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue().getName());
        }
    }
}
