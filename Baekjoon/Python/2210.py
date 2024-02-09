import sys
sys.setrecursionlimit(1000000)


def dfs(x, y, temp_six_digit_number, temp_six_digit_number_set, count):
    if x < 0 or x >= 5 or y < 0 or y >= 5 or count > 6:
        return
    elif count == 6:
        temp_six_digit_number_set.add(temp_six_digit_number)
        return
    else:
        temp_six_digit_number = temp_six_digit_number + str(numbers_board[y][x])
        count += 1
        dfs(x - 1, y, temp_six_digit_number, temp_six_digit_number_set, count)
        dfs(x, y - 1, temp_six_digit_number, temp_six_digit_number_set, count)
        dfs(x + 1, y, temp_six_digit_number, temp_six_digit_number_set, count)
        dfs(x, y + 1, temp_six_digit_number, temp_six_digit_number_set, count)
        return


numbers_board = list()
six_digit_number_set = set()
for i in range(5):
    numbers_board.append(list(map(int, input().split())))
for x in range(5):
    for y in range(5):
        count = 0
        six_digit_number = ''
        dfs(x, y, six_digit_number, six_digit_number_set, count)
print(len(six_digit_number_set))
