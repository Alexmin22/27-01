import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
        Mouse mouse1 = new Mouse(30.2, "Stan", 5);
        Mouse mouse2 = new Mouse(20.7, "Margo", 4);
        Mouse mouse3 = new Mouse(25.2, "Tony", 8);
        Mouse mouse4 = new Mouse(38.2, "Wolf", 18);
        Mouse mouse5 = new Mouse(14.0, "Poly", 2);

        List<Mouse> mouseList = new ArrayList<>();
        mouseList.add(mouse1);
        mouseList.add(mouse2);
        mouseList.add(mouse3);
        mouseList.add(mouse4);
        mouseList.add(mouse5);

        Predicate<Mouse> pr =  mouse -> mouse.lenghth>22.0;
        Predicate<Mouse> pr2 =  x -> x.age<7;
        selectMouse(mouseList, pr2.or(pr));

        List<Mouse> mouseList1 = manyMouse(() -> new Mouse(33.3, "XXX", 10) );
        System.out.println(mouseList1);

        upgradeMouse(mouseList1.get(0), mouse ->
        {mouse.lenghth *=1.5; mouse.name = mouse.name.toLowerCase(); });

        System.out.println(mouseList1);

        Function<Mouse, Double> func = mouse -> mouse.lenghth;

        double average = middle(mouseList, mouse -> (double)mouse.age);
        System.out.println(average + " средний возраст");
    }

    static void selectMouse(List<Mouse> list, Predicate<Mouse> predicate) {
        for (Mouse mouse : list) {
            if (predicate.test(mouse)) {
                System.out.println(mouse);
            }
        }
    }

    public static List<Mouse> manyMouse(Supplier<Mouse> sup) {
        List<Mouse> ml = new ArrayList<>();
        ml.add(sup.get());
        return ml;
    }

    static void upgradeMouse(Mouse mouse, Consumer<Mouse> cm) {
        cm.accept(mouse);
    }

    static double middle(List<Mouse> l, Function<Mouse, Double> f) {
        double res = 0;
        for (Mouse mouse : l) {
            res += f.apply(mouse);
        }
        return res /= l.size();
    }
}
