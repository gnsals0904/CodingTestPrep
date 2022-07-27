import sys

for i in range(3):
    t = int(sys.stdin.readline().strip())
    num_sum = 0
    for j in range(t):
        n = int(sys.stdin.readline().strip())
        num_sum = num_sum + n
    if num_sum > 0:
        print("+")
    elif num_sum < 0:
        print("-")
    else:
        print("0")
