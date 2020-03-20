package main

import (
  "fmt"
  "io/ioutil"
  "strconv"
  "strings"
  "time"
)

func part2(data []int) int {
  for noun := 0; noun < 100; noun++ {
    for verb := 0; verb < 100; verb++ {
      data[1], data[2] = noun, verb
      if part1Recursive(data, 0) == 19690720 {
        return 100*noun + verb
      }
    }
  }
  panic("no such noun/verb")
}

func part1Recursive(data []int, idx int) int {
  tmp := make([]int, len(data))
  copy(tmp, data)
  cur := data[idx]
  switch cur {
  case 1:
    sum, pos := data[data[idx+1]]+data[data[idx+2]], data[idx+3]
    tmp[pos] = sum
    idx += 4
    return part1Recursive(tmp, idx)
  case 2:
    product, pos := data[data[idx+1]]*data[data[idx+2]], data[idx+3]
    tmp[pos] = product
    idx += 4
    return part1Recursive(tmp, idx)
  case 99:
    return data[0]
  default:
    panic("invalid code")
  }
}

func part1(data []int) int {
  in := make([]int, len(data))
  copy(in, data)

  idx, cur := 0, in[0]
F:
  for {
    cur = in[idx]
    switch cur {
    case 1:
      sum, pos := in[in[idx+1]]+in[in[idx+2]], in[idx+3]
      in[pos] = sum
      idx += 4
    case 2:
      product, pos := in[in[idx+1]]*in[in[idx+2]], in[idx+3]
      in[pos] = product
      idx += 4
    case 99:
      break F
    default:
      panic("Invalid code")
    }
  }
  return in[0]
}

func check(err error) {
  if err != nil {
    panic(err)
  }
}

func readData() []int {
  out, err := ioutil.ReadFile("data.txt")
  check(err)
  rawData := strings.Split(strings.TrimSuffix(string(out), "\n"), ",")

  data := make([]int, len(rawData))
  for i, d := range rawData {
    val, err := strconv.Atoi(d)
    check(err)
    data[i] = val
  }

  return data
}

func main() {
  data := readData()
  start := time.Now()

  fmt.Println("Part 1 recursive", part1Recursive(data, 0))
  fmt.Println("Part 1", part1(data))
  fmt.Println("Part 2", part2(data))

  end := time.Now()
  elapsed := end.Sub(start)
  fmt.Printf("Took %dns to process", elapsed.Microseconds())
}
