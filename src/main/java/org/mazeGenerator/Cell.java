package org.mazeGenerator;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(exclude = "weight")
public class Cell implements Comparable<Cell>{
  int x;
  int y;
  int weight;

  Cell(int x, int y) {
    this.x = x;
    this.y = y;
    this.weight = (int) (2999*Math.random());
  }

  @Override
  public int compareTo(Cell o) {
    return Integer.compare(weight, o.weight);
  }
}