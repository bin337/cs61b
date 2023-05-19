package deque;

import java.util.Comparator;

public class MaxArrayDeque<Item> extends ArrayDeque<Item> {
    private Comparator<Item> comparator;

    public MaxArrayDeque(Comparator<Item> c) {
        super();
        comparator = c;

    }

    public Item max() {
        if (isEmpty()) {
            return null;
        }
        Item max = items[nextFirst - 1];
        for (Item item : items) {
            if (comparator.compare(max, item) > 0) {
                max = item;
            }
        }
        return max;
    }

    public Item max(Comparator<Item> c){
        if (isEmpty()) {
            return null;
        }

        Item max = items[nextFirst - 1];
        for (Item item : items) {
            if (c.compare(max, item) > 0) {
                max = item;
            }
        }
        return max;

    }

}
