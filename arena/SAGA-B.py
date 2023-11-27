import sys

N = int(input())
water = list(map(int, sys.stdin.readline().split()))
is_use = [True for _ in range(N)]
Q = int(input())
result = sum(water)
print(result)
for _ in range(Q):
    query = list(map(int, sys.stdin.readline().split()))
    # control
    if query[0] == 1:
        if is_use[query[1] - 1]:
            result -= water[query[1] - 1]
            water[query[1] - 1] = query[2]
            result += query[2]
        else:
            water[query[1] - 1] = query[2]
    # on off
    else:
        if not is_use[query[1] - 1]:
            is_use[query[1] - 1] = True
            result += water[query[1] - 1]
        else:
            is_use[query[1] - 1] = False
            result -= water[query[1] - 1]
    print(result)
