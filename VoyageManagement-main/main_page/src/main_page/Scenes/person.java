package main_page.Scenes;

/**
 *
 * @author amir
 *
 * this class is for the table in the Admin_reports_page
 *
 * i don't fully know how it works.
 * 
 * 
 */
public class person {

    private String first_name;
    private String email;
    private int age;

    public person() {
        this.first_name = "ds";
        this.age = 18;
        this.email = "";
    }

    public person(String first_name, String email, int age) {
        this.first_name = first_name;
        this.age = age;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
