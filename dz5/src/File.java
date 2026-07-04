import java.io.*;
import java.nio.file.*;
import java.util.*;

public class File {

    public static void main(String[] args) {
        String file="";
        try {
            file = Files.readString(Path.of("input.txt"));
        }catch (IOException exp){
            System.out.println("Ошибка "+exp);
        }
        String[] words = file.split("\\s+");

        Map<String, Integer> arr_word = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                arr_word.put(word, arr_word.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : arr_word.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}