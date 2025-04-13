import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("A", 1);
        map.put("B", 2);

        System.out.println("Value of A: " + map.get("A"));

        // Using computeIfAbsent (atomic update)
        map.computeIfAbsent("C", key -> 3);
        map.computeIfAbsent("A", key -> 100);

        System.out.println("Updated Map: " + map);
    }
}
