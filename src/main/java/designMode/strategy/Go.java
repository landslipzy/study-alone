package designMode.strategy;

/**
 * @author zhongying
 * @description
 * @date 2020/7/30
 */
public class Go {
    public static void main(String[] args) {

        Validator validator = new Validator(new CheckStrategyIpml1());
        System.out.println(validator.check("1111111"));
        Validator validator1 = new Validator((str)-> str.matches("\\d+"));
        System.out.println(validator1.check("1111111"));

    }
}
