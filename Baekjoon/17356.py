import math

A, B = map(int, input().split())
M = (B - A) / 400
print(1 / (1 + math.pow(10, M)))
