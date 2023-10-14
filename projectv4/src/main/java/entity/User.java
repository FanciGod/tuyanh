package entity;

public class User {
    private int Id;
    private String username;
    private String password;
    private String name;

    public User() {
    }

    public User(int id, String username, String password, String name) {
        Id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
