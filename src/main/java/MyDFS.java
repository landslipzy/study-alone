import java.util.Arrays;

/**
 * Created by zhongying on 2020/3/25.
 */
public class MyDFS {
    private static String[] index = {"2","3","4","5","6","7","8","9","10","J","Q","K"};
    private static int min = 999;
    public static void main(String[] args) {
        //4455662378
        int[] arr={2,2,3,3,4,4,0,1,5,6};
        int[] bucket = new int[12];

        //数据放入桶
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(bucket));
        //深度优先
        putOut(bucket,0);
        System.out.println("MIN>>>>>"+min);

    }

    private static void putOut(int[] bucket, int number) {
        if(number>min){
          return;
        }
        //无牌,结束
        if(isZore(bucket)){
            System.out.println(">>"+number);
            min = min<number?min:number;
            return;
        }
        //判断能否出连对
        for (int i = 0; i < bucket.length-2; i++) {
            if(bucket[i]>=2 && bucket[i+1]>=2 && bucket[i+2]>=2){
                //打出连对
                bucket[i]-=2;
                System.out.print(i+" "+i+" ");
                bucket[i+1]-=2;
                System.out.print((i+1)+" "+(i+1)+" ");
                bucket[i+2]-=2;
                System.out.print((i+2)+" "+(i+2)+" ");
                System.out.print("|");
                //继续出牌
                putOut(bucket,number+1);
                bucket[i]+=2;
                bucket[i+1]+=2;
                bucket[i+2]+=2;
            }
        }
        //判断能否出顺子
        for (int i = 0; i < bucket.length-4; i++) {
            if(bucket[i]>=1 && bucket[i+1]>=1 && bucket[i+2]>=1 && bucket[i+3]>=1 && bucket[i+4]>=1){
                //打出顺子
                bucket[i]--;
                System.out.print(i+" ");
                bucket[i+1]--;
                System.out.print(i+1+" ");
                bucket[i+2]--;
                System.out.print(i+2+" ");
                bucket[i+3]--;
                System.out.print(i+3+" ");
                bucket[i+4]--;
                System.out.print(i+4+" ");
                System.out.print("|");
                //继续出牌
                putOut(bucket,number+1);
                bucket[i]++;
                bucket[i+1]++;
                bucket[i+2]++;
                bucket[i+3]++;
                bucket[i+4]++;
            }
        }
        //判断能否出对子
        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i]>=2){
                //打出对子
                bucket[i]-=2;
                System.out.print(i+" "+i+" ");
                System.out.print("|");
                //继续出牌
                putOut(bucket,number+1);

                bucket[i]+=2;
            }
        }
        //最后出单个
        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i]>=1){
                //打出单张
                bucket[i]--;
                System.out.print(i);
                System.out.print("|");
                //继续出牌
                putOut(bucket,number+1);
                bucket[i]++;

            }
        }
    }

    private static boolean isZore(int[] bucket){
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i]!=0){
                return false;
            }
        }
        return true;
    }

}
