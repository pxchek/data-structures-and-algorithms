import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiSetHashMapImpl<E> implements Multiset<E> {
    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E object) {
        Integer c = map.getOrDefault(object, 0);
        map.put(object, c++);
    }

    @Override
    public void add(E object, int copies) {
        Integer c = map.getOrDefault(object, 0);
        map.put(object, c + copies);
    }

    @Override
    public boolean contains(E object) {
        return map.containsKey(object);
    }

    @Override
    public int count(E object) {
        return map.size();
    }

    @Override
    public void removeAllCopies(E object) {
        if (map.containsKey(object)) {
            map.remove(object);
        }
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}
