package week10.JavaBean.user;

import java.io.Serializable;

public class User implements Serializable {
    private static final long seralVersionUID = 1L;
    private String username;
    private String password;

    public User() {

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
}
