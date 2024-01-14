import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
ans = abs(100 - n)

if m != 0: #고장난 버튼 존재
    b = list(input().split())
else:
    b = []

#큰 수에서 작은 수로 내려오는 경우도 있으므로 1000000까지 for문 탐색
#작은 수 -> 큰 수: 0 ~ 500000, 큰 수 -> 작은 수: 500001 ~ 1000000
for i in range(1000001):
    for j in str(i):
        if j in b: #해당 숫자 버튼이 고장난 경우
            break
    else:
        ans = min(ans, len(str(i)) + abs(i - n)) #min(기존답, 숫자 버튼 클릭 수 + '+/-' 버튼 클릭 수)

print(ans)