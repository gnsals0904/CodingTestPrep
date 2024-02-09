import sys

t = int(sys.stdin.readline().rstrip())
P = [1, 1, 1, 2]
for i in range(4, 101):
    P.append(P[i - 2] + P[i - 3])
for _ in range(t):
    N = int(sys.stdin.readline().rstrip())
    print(P[N - 1])
