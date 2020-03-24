package main

import (
  "strconv"
  "strings"
)

type Movement struct {
  direction Direction
  distance  int
}

func NewMovement(s string) *Movement {
  direction := ParseDirection(string(s[0]))
  distance, err := strconv.Atoi(s[1:])
  check(err)
  return &Movement{
    direction: direction,
    distance:  distance,
  }
}

func LoadMovements(data string) []Movement {
  arr := strings.Split(strings.TrimSuffix(data, "\r"), ",")
  d := make([]Movement, len(arr))
  for i, coord := range arr {
    d[i] = *NewMovement(coord)
  }
  return d
}
