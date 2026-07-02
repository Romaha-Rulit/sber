import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static void main() {
        Pair<Integer,String> car=new Pair<>(340,"BMW");
        System.out.println("model: "+car.getKey());
        System.out.println("marks: "+car.getValue());
        car.setKey(63);
        car.setValue("Mers AMG");
        System.out.println(car.getValue()+"\n"+car.getKey());

        Map<Integer, String> person= new HashMap<>();
        person.put(90,"Bob");
        System.out.println(person);
        List<String> list= new ArrayList<>();
        list.add("1");list.add("2");
        System.out.println(list);
    }
}
