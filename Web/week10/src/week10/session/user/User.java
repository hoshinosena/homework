package week10.session.user;

public class User {
    public String username = "", password = "", id = "NXmE8zZGQQ6tJE8T2Cyw";

    public User() {

    }
    public User(String id) { //使用cookie验证
        if (this.id.equals(id)) {
            this.username = "root";
            this.password = "admin";
        }
    }
}
