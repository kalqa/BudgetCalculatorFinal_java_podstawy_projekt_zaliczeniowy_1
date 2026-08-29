package pl.javaready.projects;

// Person to NASZA wlasna klasa - napisana od zera, w tym projekcie.
// String i Scanner powstaly dokladnie w ten sam sposob, tylko ze
// napisali je tworcy Javy, a nie my.
public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString() ma KAZDA klasa w Javie, wiec tez i nasza -
    // String je ma "wbudowane", w Person musimy je sami napisac (nadpisac)
    @Override
    public String toString() {
        return name + " (" + age + " lat)";
    }
}
