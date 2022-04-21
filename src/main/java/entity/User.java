package entity;

public class User {

    private int id;
    private String username;
    private String name;
    private String natId;
    private int age;
    private String pass;


    public User(){}

    public User(int id, String username, String name, String natId, int age, String pass) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.natId = natId;
        this.age = age;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNatId() {
        return natId;
    }

    public void setNatId(String natId) {
        this.natId = natId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
