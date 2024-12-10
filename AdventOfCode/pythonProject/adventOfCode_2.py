safe_numbers_counter = 0

def is_sequence_safe(numbers):
    is_increasing = all(numbers[i] <= numbers[i + 1] for i in range(len(numbers) - 1))
    is_decreasing = all(numbers[i] >= numbers[i + 1] for i in range(len(numbers) - 1))

    if not (is_increasing or is_decreasing):
        return False

    if all(1 <= abs(numbers[i] - numbers[i + 1]) <= 3 for i in range(len(numbers) - 1)):
        return True
    else:
        return False

def check_if_line_is_safe_with_dampener(line):
    numbers = [int(x) for x in line.split()]

    if is_sequence_safe(numbers):
        return True

    for i in range(len(numbers)):
        modified_numbers = numbers[:i] + numbers[i + 1:]
        if is_sequence_safe(modified_numbers):
            return True

    return False

with open("input.txt", "r") as file:
    lines = file.readlines()

for line in lines:
    if check_if_line_is_safe_with_dampener(line.strip()):
        safe_numbers_counter += 1

print(safe_numbers_counter)
