package designMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongying
 * @description
 * @date 2020/7/30
 */
public class SubjectImpl implements Subject {

    private final List<Observer> list = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void notifyObserver(String str) {
        list.forEach(n->n.notify(str));
    }
}
