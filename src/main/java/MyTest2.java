import designMode.optional.Car;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhongying
 * @description
 * @date 2020/5/26
 */
public class MyTest2 {


    public static void main(String[] args) {
        String str2 = "20131030";
        String str1 = "20131011";

        Car car2 = new Car(str2, null);
        Car car1 = new Car(str1, null);

        List<Integer> value = Stream.of(1, 3, 5, 3, 2, 3, 5)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.toList()))


                .lastEntry()
                .getValue();
//                .forEach(System.out::println);



//        List<Car> list = Arrays.asList(car1,car2);
//        Optional<Car> max = list.stream().max(Comparator.comparing(Car::getName));
//        System.out.println(max.get().getName());
    }


}
