package leetcode;


import javax.swing.tree.TreeNode;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @Date 2019-04-08 11:37
 * @Description:  完全二叉树的节点个数
 */
public class CountNodes {
    /*class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int val) {
            this.val = val;
        }

    }*/
    /*private boolean orderUntil(TreeNode root, int tarDeep, int nowDeep, StringBuilder path){
        if (root == null){
            return false;
        }
        if (nowDeep == tarDeep){
            return true;
        }
        boolean ok = orderUntil(root.right,tarDeep,nowDeep+1,path.append("1"));
        if (ok){
            return true;
        }
        path.deleteCharAt(path.length()-1);
        ok = orderUntil(root.left,tarDeep,nowDeep+1,path.append("0"));
        if (ok){
            return true;
        }
        path.deleteCharAt(path.length()-1);
        return false;
    }

    public int countNodes(TreeNode root){
        int leftDeep = 0;
        TreeNode left = root;
        while (left != null){
            left = left.left;
            leftDeep += 1;
        }

        //找右子树深度
        int rightDeep = 0;
        TreeNode right = root;
        while (right != null){
            right = right.right;
            rightDeep += 1;
        }

        //左右深度相等则直接返回结果
        if(leftDeep == rightDeep){
            return (int)Math.pow(2,leftDeep) - 1;
        }

        //右子树优先遍历,到第一次找到深度为左子树深度的位置结束  并返回遍历路径
        StringBuilder sb = new StringBuilder();
        orderUntil(root, leftDeep, 1, sb);

        //解码路径
        char[] tmp = sb.toString().toCharArray();
        int code = 0;
        int bit = 1;
        for(int i = tmp.length - 1; i>= 0; i--){
            code += (tmp[i] - '0')*bit;
            bit <<= 1;
        }

        return (int)Math.pow(2, rightDeep) + code;
    }*/
}
