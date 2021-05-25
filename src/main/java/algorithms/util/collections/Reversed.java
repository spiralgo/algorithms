package algorithms.util.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Reversed<T> implements Iterable<T> {
    private final List<T> original;

    public Reversed(Collection<T> original) {
        this.original = new ArrayList<>(original);
    }

    public Reversed(List<T> original, boolean isList) {
        this.original = original;
    }

    public Iterator<T> iterator() {
        final ListIterator<T> i = original.listIterator(original.size());

        return new Iterator<T>() {
            public boolean hasNext() {
                return i.hasPrevious();
            }

            public T next() {
                return i.previous();
            }

            public void remove() {
                i.remove();
            }
        };
    }

    public static <T> Reversed<T> reversedList(List<T> original) {
        return new Reversed<T>(original, true);
    }

    public static <T> Reversed<T> reversed(Collection<T> original) {
        return new Reversed<T>(original);
    }
}
