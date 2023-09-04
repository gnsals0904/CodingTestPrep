from bisect import bisect_left, bisect_right

N, x = map(int, input().split())
array = list(map(int, input().split()))

result1 = bisect_left(array, x)
result2 = bisect_right(array, x)

if result1 < result2:
    print(result2 - result1)
else:
    print("None")
