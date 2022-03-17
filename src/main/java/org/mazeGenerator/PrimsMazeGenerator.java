package org.mazeGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class PrimsMazeGenerator implements IMazeGenerator {
  int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  List<Cell> getNeighbors(int x, int y, int M, int N) {
    return Arrays.stream(neighbors)
      .map(neighbor -> new int[] {x+neighbor[0], y+neighbor[1]})
      .filter(neighbor -> neighbor[0] >= 0 && neighbor[0] < M && neighbor[1] >= 0 && neighbor[1] < N)
      .map(neighbor -> new Cell(neighbor[0], neighbor[1]))
      .collect(Collectors.toList());
  }

  Cell getRandomStart(int M, int N) {
    int randomRow = (int)((Math.random()*1927) % M);
    int randomCol = (int)((Math.random()*1927) % N);

    return new Cell(randomRow, randomCol);
  }

  HashSet<Cell> prims(int M, int N, boolean[][][] maze) {
    var startCell = new Cell(0, 0);
    var endCell = new Cell(M-1, N-1);

    var startingCell = getRandomStart(M, N);
    var visitedCells = new HashSet<Cell>();
    visitedCells.add(startingCell);

    var frontier = new PriorityQueue<Cell>();
    getNeighbors(startingCell.getX(), startingCell.getY(), M, N).stream()
      .filter(cell -> !visitedCells.contains(cell))
      .forEach(frontier::add);

    while(!frontier.isEmpty()) {
      var candidate = frontier.poll();

      if (visitedCells.contains(startCell) && visitedCells.contains(endCell)) {
        break;
      }

      if (visitedCells.contains(candidate)) continue;

      visitedCells.add(candidate);
      var neighbors = getNeighbors(candidate.getX(), candidate.getY(), M, N);
      neighbors.stream()
        .filter(visitedCells::contains).min(Comparator.comparingInt(Cell::getWeight))
        .ifPresent(cell -> openDoor(maze, cell, candidate));

      neighbors.stream()
        .filter(cell -> !visitedCells.contains(cell))
        .forEach(frontier::add);
    }
    return visitedCells;
  }
  /// 0 is rows, 1, cols
  void openDoor(boolean[][][] maze, Cell current, Cell next) {
    // UP
    if (next.getX() < current.getX()) {
      maze[0][next.getX()][next.getY()] = false;
    }
    // DOWN
    else if (next.getX() > current.getX()) {
      maze[0][current.getX()][current.getY()] = false;
    }
    // RIGHT
    else if (next.getY() > current.getY()) {
      maze[1][current.getX()][current.getY()] = false;
    }
    // LEFT
    else {
      maze[1][next.getX()][next.getY()] = false;
    }
  }

  void closeDoors(boolean[][][] maze) {
    for(int i = 0 ; i < 2 ; i++) {
      for(int j = 0 ; j < maze[i].length ; j++) {
        Arrays.fill(maze[i][j], true);
      }
    }
  }

  @Override
  public boolean[][][] generateMaze(int M, int N) {
    boolean[][][] maze = new boolean[2][M][N];
    closeDoors(maze);
    prims(M, N, maze);
    return maze;
  }
}

