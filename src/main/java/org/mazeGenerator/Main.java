/*
 * This file is part of Random Maze Generator.
 *  Random Maze Generator is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 *  Random Maze Generator is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with Random Maze Generator. If not, see <https://www.gnu.org/licenses/>.
 */

package org.mazeGenerator;

public class Main {

  public static void main(String[] args) {
    var mazeGenerator = new PrimsMazeGenerator();
    int M = 6;
    int N = 8;
    var maze = mazeGenerator.generateMaze(M, N);
    MazePrinter.printMaze(M, N, maze);
  }
}
