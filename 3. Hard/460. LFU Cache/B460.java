import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class B460 {
    private Map<Integer, Integer> vals; // map to store the key-value pairs
    private Map<Integer, Integer> counts; // map to store the use count for each key
    private Map<Integer, LinkedHashSet<Integer>> lists; // map to store the keys with the same use count in a LinkedHashSet, in order of insertion
    private int cap; // capacity of the cache
    private int min = -1; // the minimum use count among all keys in the cache

    public void LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>()); // initialize the LinkedHashSet for the use count 1
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1; // key not found in the cache
        int count = counts.get(key);
        counts.put(key, count + 1); // increment the use count for the key
        lists.get(count).remove(key);
        if (count == min && lists.get(count).size() == 0) min++; // if the key with the minimum use count is removed, update the minimum use count
        if (!lists.containsKey(count + 1)) lists.put(count + 1, new LinkedHashSet<>());
        lists.get(count + 1).add(key); // add the key to the LinkedHashSet with the new use count
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) return; // if the capacity is 0, do nothing
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key); // call get() to increment the use count for the key and update the LinkedHashSet
            return;
        }
        if (vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
            counts.remove(evit); // if the cache is full, remove the key with the minimum use count
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key); // add the new key with a use count of 1
    }
}
