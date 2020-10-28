package designMode.observer;

/**
 * @author zhongying
 * @description
 * @date 2020/7/30
 */
public interface Subject {
    void registerObserver(Observer observer);
    void notifyObserver(String str);
}
