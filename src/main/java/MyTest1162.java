import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhongying on 2020/3/31.
 * 你现在手里有一份大小为 N x N 的「地图」（网格） grid，
 * 上面的每个「区域」（单元格）都用 0 和 1 标记好了。
 * 其中 0 代表海洋，1 代表陆地，请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 */
public class MyTest1162 {
//    private static int [][] grid = {{1,1,1},{1,1,1},{1,1,1}};
//private static int [][] grid = { {0,0,0,0,0},
//                                {0,0,0,0,0},
//                                {0,0,0,0,0},
//                                {0,0,0,0,0},
//                                {0,0,0,0,0} };

    public static void main(String[] args) {
        int [][] grid = { {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0} };
        int theFarthest = findTheFarthest(grid);
        System.out.println(theFarthest);
    }

    private static int findTheFarthest(int [][] grid){
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
        //从所有陆地出发
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    //陆地全部入队
                    queue.offer(new int[]{i,j});
                }
            }
        }

        //队列不为空则遍历
        int[] poll = null;
        while (!queue.isEmpty()){
            poll = queue.poll();
            //依次上下左右 该点入队
            for (int i = 0; i <direction.length ; i++) {
                int newX=poll[0]+direction[i][0];
                int newY=poll[1]+direction[i][1];
                if(isSea(newX,newY,grid)){
                    grid[newX][newY] = grid[poll[0]][poll[1]]+1;
                    queue.offer(new int[]{newX,newY});
                }
            }

        }
        //如果全是海 或者 全是陆地
        if (poll==null||grid[poll[0]][poll[1]]==1){
            return -1;
        }else {
            System.out.println(Arrays.toString(poll));
            return grid[poll[0]][poll[1]];
        }

    }
    //判断是否能通过
    private static boolean isSea(int i, int j,int [][] grid) {
        //越界
        if(i<0||i>grid.length-1) return false;
        if(j<0||j>grid[0].length-1) return false;
        //是陆地
        if(grid[i][j]==1) return false;
        //已经走过
        if(grid[i][j]>1) return false;
        return true;
    }
}
