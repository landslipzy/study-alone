package leetcode450;

import lombok.Data;

/**
 * @author zhongying
 * @description
 * @date 2020/8/17
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
