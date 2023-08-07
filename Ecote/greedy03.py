N = int(input())
l1 = list(map(int, input().split()))
l1.sort()
result = 0
point = len(l1) - 1
tmp1 = l1[point]
while True:
    if tmp1 > len(l1):
        point -= 1
        if point < 0:
            break
        tmp1 = l1[point]
    else:
        if point < 0:
            break
        point -= tmp1
        tmp1 = l1[point]
        result += 1
print(result)