import java.util.*;

class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {

        return this.value;
    }

}

public class pairsTut {
    public static void main(String[] args) {
        ArrayList<Pair<Integer, Integer>> arr = new ArrayList<>();
        arr.add(new Pair(3, 1));
        arr.add(new Pair(1, 4));
        arr.add(new Pair(2, 5));
        Collections.sort(arr, Comparator.comparing(Pair::getKey));
        for (Pair<Integer, Integer> x : arr) {
            System.out.println(x.getKey());
        }

    }
}