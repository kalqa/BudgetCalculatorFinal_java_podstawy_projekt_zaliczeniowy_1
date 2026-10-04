package pl.javaready.projects;

import java.util.Objects;

public class User extends Object {

    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(age, user.age);
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                '}';
//    }
}
