import sys


K, N = map(int, input().split())
lan_list = []
for _ in range(K):
    lan_list.append(int(sys.stdin.readline().rstrip()))
result = 0
start = 0
dap = 0
end = max(lan_list)
check = False
while start <= end:
    temp_result = 0
    middle = (start + end) // 2
    if middle != 0:
        for i in range(K):
            temp_result = temp_result + (lan_list[i] // middle)
        if temp_result < N:
            end = middle - 1
        else:
            result = middle
            start = middle + 1
    else:
        check = True
        break
if not check:
    print(result)
else:
    print(1)
