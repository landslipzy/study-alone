package stream;

/**
 * @author zhongying
 * @description
 * @date 2020/12/4
 */
public class Empty<T> implements MyList<T>{
    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }
    @Override
    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }
}
