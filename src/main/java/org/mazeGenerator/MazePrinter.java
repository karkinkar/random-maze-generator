/*
 * This file is part of Random Maze Generator.
 *  Random Maze Generator is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 *  Random Maze Generator is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with Random Maze Generator. If not, see <https://www.gnu.org/licenses/>.
 */

package org.mazeGenerator;

public class MazePrinter {
  public static void printMaze(int M, int N, boolean[][][] maze) {
    int width = 2;
    printBoundary(N, width);

    for (int row = 0; row < M; row++) {
      System.out.print("|");
      for (int col = 0; col < N; col++) {
        if (maze[1][row][col]) {
          System.out.print(" ".repeat(width));
          System.out.print("|");
        } else {
          System.out.print(" ".repeat(width));
          System.out.print(" ");
        }
      }
      System.out.println();
      System.out.print("+");
      for (int col = 0; col < N; col++) {
        if (maze[0][row][col]) {
          System.out.print("-".repeat(width));
          System.out.print("+");
        } else {
          System.out.print(" ".repeat(width));
          System.out.print("+");
        }
      }
      System.out.println();
    }
    // printBoundary(N, width);
  }

  private static void printBoundary(int N, int width) {
    System.out.print("+");
    for (int col = 0; col < N; col++) {
      System.out.print("-".repeat(width));
      System.out.print("+");
    }
    System.out.println();
  }
}
