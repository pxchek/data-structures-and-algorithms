import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MultiSetListImpl<E> implements Multiset<E> {
    List<E> elements = new ArrayList<>();

    @Override
    public void add(E object) {
        if (Objects.nonNull(object))
            elements.add(object);
    }

    @Override
    public void add(E object, int copies) {
        if (Objects.nonNull(object) && Integer.signum(copies) == 1) {
            while (copies != 0) {
                elements.add(object);
                --copies;
            }
        }
    }

    @Override
    public boolean contains(E object) {
        if (Objects.nonNull(object))
            return elements.contains(object);
        else
            return Boolean.FALSE;
    }

    @Override
    public int count(E object) {
        var count = 0;
        if (Objects.nonNull(object)) {
            for (E e : elements) {
                if (elements.contains(e)) {
                    ++count;
                }
            }
        } else {
            count = 0;
        }

        return count;
    }

    @Override
    public void removeAllCopies(E object) {
        if (Objects.nonNull(object)) {
            Iterator<E> iterator = iterator();
            while(iterator.hasNext()) {
                iterator.next();
                if(this.contains(object)) {
                    iterator.remove();
                }
            }
        }

    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(elements) || elements.size() == 0;
    }

    @Override
    public int size() {
        return Objects.nonNull(elements) ? elements.size() : 0;
    }

    @Override
    public Iterator<E> iterator() {
        return Objects.nonNull(elements) ? elements.iterator() : null;
    }

}
