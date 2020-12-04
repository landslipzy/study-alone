package stream;

/**
 * @author zhongying
 * @description
 * @date 2020/12/4
 */
public interface MyList<T> {
    T head();
    MyList<T> tail();
    default boolean isEmpty(){
        return false;
    }
}
