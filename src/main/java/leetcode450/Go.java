package leetcode450;

/**
 * @author zhongying
 * @description
 * @date 2020/8/17
 */
public class Go {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 6, 2, 4, null, 7};

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return null;
    }


    /**
     * 将一个数插入二叉树中
     *
     * @param node
     * @param value
     */
    public static void addToTree(TreeNode node, int value) {

        if (node.getVal() > value) {
            //当前结点的值比value大，则成为其左子结点
            if (node.getLeft() != null) {
                //看这个结点的左子结点是否存在，如果存在
                node = node.getLeft();
                //递归调用该方法
                addToTree(node, value);
            } else {
                //不存在
                TreeNode TNode = new TreeNode(value);
//                TNode.setParent(node);
                node.setLeft(TNode);
            }
        } else {
            //当前结点的值比value小，则成为其右子结点
            if (node.getRight() != null) {
                //看这个结点的右子结点是否存在，如果存在
                node = node.getRight();
                addToTree(node, value);
            } else {
                //不存在
                TreeNode TNode = new TreeNode(value);
//                TNode.setParent(node);
                node.setRight(TNode);
            }
        }
    }
}
