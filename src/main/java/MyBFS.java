import java.util.Arrays;

/**
 * Created by zhongying on 2020/3/26.
 */
public class MyBFS {
    private static String[] index = {"2","3","4","5","6","7","8","9","10","J","Q","K",""};
    public static void main(String[] args) {
        int[] arr={2,2,3,3,4,4,0,1,5,6};
        int[] bucket = new int[index.length];

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        System.out.println(Arrays.toString(bucket));
        //广度优先
        bfs(bucket);
//        System.out.println("MIN>>>>>"+min);

    }

    private static int bfs(int[] bucket) {
        //判断是否桶已空
        int number = 0;
        while (!isZero(bucket)){

        }
        return number;
    }

    /**
     * 判断所有桶是否空
     * @param bucket
     * @return
     */
    private static boolean isZero(int[] bucket){
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i]!=0){
                return false;
            }
        }
        return true;
    }
}
