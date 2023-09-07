# to make 1
x = int(input())

# DP Table
d = [0] * 30000

# DP Bottom - Up
for i in range(2, x + 1):
    # minus 1
    d[i] = d[i - 1] + 1
    # divide 2
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
    # divide 3
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)
    # divide 5
    if i % 5 == 0:
        d[i] = min(d[i], d[i // 5] + 1)

print(d[x])