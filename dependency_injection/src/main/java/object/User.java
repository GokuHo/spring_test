package object;

import java.util.Date;

public class User {

    private String username, password;
    private int age;
    private Date createDate;

    public User() {
        System.out.println("User non-parameter constructor");
    }

    public User(String username, String password, int age) {
        System.out.println("User parameter constructor");
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", createDate=" + createDate +
                '}';
    }
}
