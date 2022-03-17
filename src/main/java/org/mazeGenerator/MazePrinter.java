package org.mazeGenerator;

public class MazePrinter {
  public static void printMaze(int M, int N, boolean[][][] maze) {
    int width = 2;
    printBoundary(N, width);

    for(int row = 0; row < M; row++) {
      System.out.print("|");
      for(int col = 0; col < N; col++) {
        if (maze[1][row][col]) {
          System.out.print(" ".repeat(width));
          System.out.print("|");
        }
        else {
          System.out.print(" ".repeat(width));
          System.out.print(" ");
        }
      }
      System.out.println();
      System.out.print("+");
      for(int col = 0; col < N; col++) {
        if (maze[0][row][col]) {
          System.out.print("-".repeat(width));
          System.out.print("+");
        }
        else {
          System.out.print(" ".repeat(width));
          System.out.print("+");
        }
      }
      System.out.println();
    }
    //printBoundary(N, width);
  }

  private static void printBoundary(int N, int width) {
    System.out.print("+");
    for(int col = 0; col < N; col++) {
      System.out.print("-".repeat(width));
      System.out.print("+");
    }
    System.out.println();
  }
}
