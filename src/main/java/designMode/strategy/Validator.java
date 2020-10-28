package designMode.strategy;

/**
 * @author zhongying
 * @description
 * @date 2020/7/30
 */
public class Validator {

    private CheckStrategy strategy;

    public Validator(CheckStrategy strategy){
        this.strategy=strategy;
    }

    public boolean check(String str){
        return strategy.execute(str);
    }
}
