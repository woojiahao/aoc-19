package main

import (
	"fmt"
	"io/ioutil"
	"strconv"
	"strings"
)

func part1(data []int) int {
	fmt.Println("Data is", data)
	in := make([]int, len(data))
	copy(in, data)
	fmt.Println("in is", in)

	idx, cur := 0, in[0]
F:
	for {
		cur = in[idx]
		fmt.Printf("idx: %d, cur: %d\n", idx, cur)
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
		fmt.Println("data:", in)
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
	fmt.Println("Data is", data)
	fmt.Println("Part 1", part1(data))
}
