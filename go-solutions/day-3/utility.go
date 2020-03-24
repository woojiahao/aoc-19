package main

import (
  "io/ioutil"
  "strings"
)

func check(err error) {
  if err != nil {
    panic(err)
  }
}

func readData() (w1, w2 []Movement) {
  out, err := ioutil.ReadFile("data.txt")
  check(err)
  rawData := strings.Split(strings.TrimSuffix(string(out), "\n"), "\n")

  return LoadMovements(rawData[0]), LoadMovements(rawData[1])
}
