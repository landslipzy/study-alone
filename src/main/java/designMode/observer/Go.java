package designMode.observer;

import java.util.function.Supplier;

/**
 * @author zhongying
 * @description
 * @date 2020/7/30
 */
public class Go {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();



        subject.registerObserver(str -> {
            if (str.contains("ha")){
                System.out.println("i am ha haha");
            }
        });
        subject.registerObserver(str -> {
            if (str.contains("he")){
                System.out.println("i am he hehehe");
            }
        });

        subject.notifyObserver("hahahahahhahe");
    }
}
