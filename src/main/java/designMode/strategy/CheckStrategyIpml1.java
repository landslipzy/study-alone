package designMode.strategy;

/**
 * @author zhongying
 * @description
 * @date 2020/7/30
 */
public class CheckStrategyIpml1 implements CheckStrategy{
    @Override
    public boolean execute(String str) {
        return str.matches("[a-z]+");
    }
}
