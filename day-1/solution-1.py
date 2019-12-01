with open('problem-1-data.txt', 'r') as file:
    total_fuel = sum([int(int(line.replace('\n', '')) / 3) - 2 for line in file.readlines()])
    print(total_fuel)
