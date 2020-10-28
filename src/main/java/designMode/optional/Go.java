package designMode.optional;

import lombok.Data;

import java.util.Optional;

/**
 * @author zhongying
 * @description
 * @date 2020/8/4
 */
@Data
public class Go {

    private String name;
    public static void main(String[] args) {

        Insurance insurance = new Insurance();
        insurance.setName("pingan");

        Car car = new Car("ct-4",insurance);
//        car=null ;

        Person p = new Person();
        p.setCar(car);
        p.setName("zhangsan");

        Optional<Person> optional = Optional.ofNullable(p);

//        Car finalCar = car;
        Optional<Car> optional1 = Optional.ofNullable(car).map(n -> {
            if (1 == 1) return null;
            else return n;
        });


       optional.map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .ifPresent(n->n=n+"123");
        String s = optional.map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .get();

        System.out.println(s);
    }


}
