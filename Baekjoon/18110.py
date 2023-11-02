import sys

n = int(input())
if n == 0:
    print(0)
else:
    front = int(n * 15 / 100 + 0.5)
    back = n - front
    num = back - front
    difficult = []
    for i in range(n):
        v = int(sys.stdin.readline().rstrip())
        difficult.append(v)
    difficult.sort()
    difficult = difficult[front:back]
    print(int(sum(difficult)/num + 0.5))
