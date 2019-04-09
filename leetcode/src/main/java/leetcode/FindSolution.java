package leetcode;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @Date 2019-04-09 15:00
 * @Description:  在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class FindSolution {
    public boolean Find(int target,int[][] array){
        if (array.length == 0 || array[0].length==0)
            return false;
        int m = array[0].length-1;
        int n = 0;
        int temp = array[n][m];
        while (target != temp){
            if (m>0 && n<array.length-1){
                if (target>temp){
                    n = n+1;
                }else if (target<temp){
                    m = m-1;
                }
                temp = array[n][m];
            }else {
                return false;
            }
        }
        return true;
    }
}
