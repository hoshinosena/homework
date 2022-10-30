package week9.session.cake;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CakeDB {
    private static Map<String, Cake> cake = new LinkedHashMap<>();
    static {
        cake.put("1", new Cake("A类蛋糕"));
        cake.put("2", new Cake("B类蛋糕"));
        cake.put("3", new Cake("C类蛋糕"));
        cake.put("4", new Cake("D类蛋糕"));
        cake.put("5", new Cake("E类蛋糕"));
    }
    public static Collection<Cake> getAll() {
        return cake.values();
    }
    public static Cake getCake(String id) {
        return cake.get(id);
    }
}
