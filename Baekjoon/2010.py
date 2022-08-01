import sys
N = int(sys.stdin.readline().rstrip())
tap_number = list()
for i in range(N):
    tap_number.append(int(sys.stdin.readline().rstrip()))
print(sum(tap_number) - (N - 1))
