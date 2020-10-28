/**
 * Created by zhongying on 2020/3/31.
 */
public class Solution {
    //利用动态规划的方法来解决问题
    public int maxDistance(int[][] grid) {
        int [][]dp=new int [grid.length][grid[0].length];
        int i,j;
        int res=0;//返回值res
        for(i=0;i<grid.length;i++)
            for(j=0;j<grid.length;j++)
                dp[i][j]=400;
        //定义初始值为400，这样之后取最小值就可以当作是该点到陆地的最近距离

        for(i=0;i<grid.length;i++)
            for(j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    dp[i][j]=0;
                if(i<grid.length-1)
                    dp[i+1][j]=Math.min(dp[i][j]+1,dp[i+1][j]);
                if(j<grid[0].length-1)
                    dp[i][j+1]=Math.min(dp[i][j]+1,dp[i][j+1]);
            }

        for(i=grid.length-1;i>=0;i--)
            for(j=grid[0].length-1;j>=0;j--)
            {
                if(i>=1)
                    dp[i-1][j]=Math.min(dp[i-1][j],dp[i][j]+1);
                if(j>=1)
                    dp[i][j-1]=Math.min(dp[i][j]+1,dp[i][j-1]);
            }

        for(i=0;i<grid.length;i++)
            for(j=0;j<grid[0].length;j++)
                res=Math.max(res,dp[i][j]);
        //如果返回值是0代表所有格子都被陆地占据，此时依题意应当返回-1
        //如果返回值是400标明所有格子都是海洋，也要返回-1
        if(res==0)
            return -1;
        else if(res==400)
            return -1;
        return res;
    }


    public static void main(String[] args) {

    }
}
