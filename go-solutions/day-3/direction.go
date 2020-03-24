package main

type Direction string

const (
  Right Direction = "R"
  Left  Direction = "L"
  Up    Direction = "U"
  Down  Direction = "D"
)

func ParseDirection(s string) Direction {
  switch s {
  case "R":
    return Right
  case "L":
    return Left
  case "U":
    return Up
  case "D":
    return Down
  default:
    panic("invalid direction code")
  }
}
