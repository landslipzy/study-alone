package designMode.extend;

/**
 * @author zhongying
 * @description
 * @date 2020/8/3
 */
public interface A {
    default void hello(){
        System.out.println("hello A");
    }
}
