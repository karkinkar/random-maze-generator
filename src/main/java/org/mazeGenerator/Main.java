package org.mazeGenerator;

public class Main {

  public static void main(String[] args) {
    var mazeGenerator = new PrimsMazeGenerator();
    int M = 6; int N = 8;
    var maze = mazeGenerator.generateMaze(M, N);
    MazePrinter.printMaze(M, N, maze);
  }
}
