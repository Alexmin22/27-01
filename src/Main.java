import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.format("%02d", i));
        }

        Collections.sort(list, (s1, g2) -> -s1.compareTo(g2));


        for (String st : list) {
            System.out.println(st);
        }
    }
}