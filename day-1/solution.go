package main

import (
  "fmt"
  "io/ioutil"
  "math"
  "strconv"
  "strings"
)

func check(e error) {
  if e != nil {
    panic(e)
  }
}

func calculateFuel(mass int) int {
  return int(math.Floor(float64(mass)/3.0)) - 2
}

func day1(data []int) int {
  sum := 0
  for _, d := range data {
    sum += calculateFuel(d)
  }
  return sum
}

func day2(data []int) int {
  totalSum := 0

  for _, d := range data {
    sum, remainingMass := 0, d
    fuelNeeded := calculateFuel(remainingMass)
    for fuelNeeded > 0 {
      sum += fuelNeeded
      remainingMass = fuelNeeded
      fuelNeeded = calculateFuel(remainingMass)
    }
    totalSum += sum
  }

  return totalSum
}

func processInput(raw []string) []int {
  input := make([]string, 0)
  for _, d := range raw {
    if d != "" {
      input = append(input, d)
    }
  }

  data := make([]int, len(input))
  for i, d := range input {
    val, err := strconv.Atoi(d)
    check(err)
    data[i] = val
  }

  return data
}

func main() {
  out, err := ioutil.ReadFile("problem-1-data.txt")
  check(err)
  data := processInput(strings.Split(string(out), "\n"))
  fmt.Println("Answer for day 1 is:", day1(data))
  fmt.Println("Answer for day 2 is:", day2(data))
}
