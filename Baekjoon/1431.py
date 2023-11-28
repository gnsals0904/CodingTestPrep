import sys


def sum_only_num(s):
    result = 0
    for s1 in s:
        if s1.isdigit():
            result += int(s1)
    return result


N = int(input())
serial_number = []
for _ in range(N):
    serial_number.append(sys.stdin.readline().rstrip())
serial_number.sort(key=lambda x: (len(x), sum_only_num(x), x))
for i in range(N):
    print(serial_number[i])

