# binary search
def binary_search_test(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    result = 0
    for x in array:
        if x > mid:
            result = result + x - mid
    if result == target:
        return mid
    if result < target:
        return binary_search_test(array, target, start, mid - 1)
    else:
        return binary_search_test(array, target, mid + 1, end)


N, M = map(int, input().split())
array = list(map(int, input().split()))
min_value = 0
max_value = max(array)
ans = binary_search_test(array, M, min_value, max_value)
print(ans)

