package mockingdemo;

/**
 *
 * @author hvd
 */
public class Person {
    
    private final String name;
    private final String homeTown;
    private final String emailAddres;

    public Person(String name, String homeTown, String emailAddres) {
        this.name = name;
        this.homeTown = homeTown;
        this.emailAddres = emailAddres;
    }

    public String getName() {
        return name;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public String getEmailAddres() {
        return emailAddres;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", homeTown=" + homeTown + ", emailAddres=" + emailAddres + '}';
    }
}