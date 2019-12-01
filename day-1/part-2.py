def calculate_fuel(mass: int) -> int:
    total_fuel = 0
    while mass > 0:
        mass = int(mass / 3) - 2
        if not mass > 0:
            break
        total_fuel += mass
    return total_fuel

with open('problem-1-data.txt', 'r') as file:
    total = sum({calculate_fuel(int(line.replace('\n', ''))) for line in file.readlines()})
    print(total)
