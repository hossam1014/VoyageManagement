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

    private String firs_name;
    private String email;
    private int age;

    public person() {
        this.firs_name = "";
        this.age = 18;
        this.email = "";
    }

    public person(String first_name, String email, int age) {
        this.firs_name = first_name;
        this.age = age;
        this.email = email;
    }

    public String getFirs_name() {
        return firs_name;
    }

    public void setFirs_name(String firs_name) {
        this.firs_name = firs_name;
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
