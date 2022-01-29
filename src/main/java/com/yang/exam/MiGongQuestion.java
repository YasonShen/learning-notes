package com.yang.exam;

import java.util.LinkedList;
import java.util.Queue;

public class MiGongQuestion {


    //存储路径
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //地图map
    static int[][] map = new int[][] {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0}
    };;

    //n为宽，m为长
    static int n = map.length;
    static int m = map[0].length;

    //保存走过的路，数组d的元素表示当前走了多少步
    //没有走过的话，该值为默认值0
    static int[][] d = new int[n][m];

    //用于记录当前位置是从之前哪个位置过来的，便于输出路径
    static Pair[][] prev = new Pair[n][m];


    public static void main(String[] args) {

        System.out.println(bfs());
    }

    public static int bfs() {
        //初始化队列
        Queue<Pair> q = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        //加入起点0, 0
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            //最短路径通过广度优先遍历保证，因为一层一层的遍历，每次将该节点上下左右临近的节点依次加入队列，
            //然后依次出队，再将临近节点加入队里，先到达终点的会直接break，故求得的是最短路径
            if (pair.x == n - 1 && pair.y == m - 1) {
                break;
            }

            //上（-1,0）右（0,1）下左 遍历
            for (int i = 0; i < 4; i++) {
                int x = pair.x + dx[i];
                int y = pair.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 0 && d[x][y] == 0) {
                    q.offer(new Pair(x, y));
                    d[x][y] = d[pair.x][pair.y] + 1;
                    //存储能到当前x,y的位置
                    prev[x][y] = pair;
                }
            }
        }

        //从终点往前遍历到起点
        int x = n - 1, y = m - 1;
        while (x != 0 || y != 0) {
            System.out.println(x + " " + y);
            //prev[x][y] 存储的是能到达当前位置的位置
            Pair tmp = prev[x][y];
            x = tmp.x;
            y = tmp.y;
        }

        return d[n - 1][m - 1];
    }

}
