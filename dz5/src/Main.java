import java.util.*;

public class Main {

    public static <K, V> Map<V, K> swap(Map<K, V> map) {
        Map<V, K> swapped = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            swapped.put(entry.getValue(), entry.getKey());
        }
        return swapped;
    }

    public static void main(String[] args) {
        Map<String, Integer> car = new HashMap<>();
        car.put("BMW", 340);
        car.put("Mercedes", 200);
        car.put("AUDI", 6);

        Map<Integer, String> swapped = swap(car);

        System.out.println("Исходная: " + car);
        System.out.println("Обратная: " + swapped);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

    }
}