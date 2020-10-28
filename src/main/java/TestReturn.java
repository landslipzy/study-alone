/**
 * @author zhongying
 * @description
 * @date 2020/8/28
 */
public class TestReturn {
    public static void main(String[] args) {
        System.out.println(method());
    }

    public static int method(){
        try {
            return 1;
        }catch (Exception e){

        }finally {
            return 2;
        }
    }
}
