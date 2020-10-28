import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by zhongying on 2020/4/14.
 */
public class Steam {
    static int number = 12;
     int number1 = 12;

    public static void main(String[] args) {

        Supplier<Apple> a = Apple::new;

        List<String> list = new ArrayList<>();
        Callable<Integer> c = () -> 42;
        Runnable  o = () -> System.out.println("Tricky example>>"+number);
        new Thread(o).start();
        number = 123;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number = 12366666;
        new Thread(o).start();
        System.out.println(number);
    }


    private String method1(){
        Runnable  o = () -> System.out.println("Tricky example>>"+number1);
        return "";
    }
}
