import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhongying on 2020/3/25.
 */
public class MyTestBFS {
    static Stack<Integer> stack = new Stack();
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 5, 3, 2, 9, 7};
        int[] res = findMaxRight(arr);
        System.out.println(Arrays.toString(res));
    }


    static int[] findMaxRight(int[] nums)
    {
        int[] res =new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i]>nums[stack.peek()]){
                res[stack.pop()]=nums[i];
            }
            stack.push(i);
        }
        while (!stack.empty()){
            res[stack.pop()]=-1;
        }
        return res;
    }
}
