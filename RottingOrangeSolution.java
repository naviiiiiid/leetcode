package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangeSolution {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int minutes = 0;
        int freshOrange = 0;

        Queue<int[]> q
                = new LinkedList<>();

        do {

            freshOrange =0;

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {

                    if(grid[i][j] == 1) {
                        freshOrange++;
                    }

                    if (!visited[i][j]) {

                        if (grid[i][j] == 2) {

                            visited[i][j] = true;

                            if (i + 1 < m && grid[i + 1][j] == 1) {
                                q.add(new int[]{i + 1, j});
                            }

                            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                                q.add(new int[]{i - 1, j});

                            }

                            if (j + 1 < n && grid[i][j + 1] == 1) {
                                q.add(new int[]{i, j + 1});

                            }

                            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                                q.add(new int[]{i, j - 1});
                            }
                        }
                    }
                }


            if(q.isEmpty())
                break;

            while(!q.isEmpty()) {

                int[] x = q.remove();

                int i0 = x[0];
                int j0 = x[1];

                if (grid[i0][j0] == 1) {
                    grid[i0][j0] = 2;
                    freshOrange--;

                }
            }

            minutes++;


        } while (true);

        return freshOrange ==0? minutes: -1 ;

    }

}
