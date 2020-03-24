package main

import (
  "fmt"
)

type (
  Coord struct {
    x int
    y int
  }
  WirePath struct {
    coords []Coord
  }
)

func NewWirePath(coords []Coord) *WirePath {
  coordTrack, newCoords := make(map[Coord]bool), make([]Coord, 0)
  for _, coord := range coords {
    if !coordTrack[coord] {
      coordTrack[coord] = true
      newCoords = append(newCoords, coord)
    }
  }
  return &WirePath{newCoords}
}

// Returns all coordinates within the set
// TODO Instead of mapping the entire wire's path, make use of linear equations to calculate whether two lines intersect based on their coordinates from one another
func mapWirePath(wire []Movement) *WirePath {
  cur, coords := Coord{0, 0}, make([]Coord, 0)
  for _, d := range wire {
    switch d.direction {
    case Up:
      for i := cur.y; i <= cur.y+d.distance; i++ {
        coords = append(coords, Coord{cur.x, i})
      }
      cur.y += d.distance
    case Down:
      for i := cur.y; i >= cur.y-d.distance; i-- {
        coords = append(coords, Coord{cur.x, i})
      }
      cur.y -= d.distance
    case Right:
      for i := cur.x; i <= cur.x+d.distance; i++ {
        coords = append(coords, Coord{i, cur.y})
      }
      cur.x += d.distance
    case Left:
      for i := cur.x; i >= cur.x-d.distance; i-- {
        coords = append(coords, Coord{i, cur.y})
      }
      cur.x -= d.distance
    }
  }

  return NewWirePath(coords)
}

func part1(w1, w2 []Movement) int {
  w1Path, w2Path := mapWirePath(w1), mapWirePath(w2)
  // Get intersections
  
  return 0
}

func main() {
  w1, w2 := readData()
  part1(w1, w2)
}
