import sys

N = int(input())
num_list = []
sort_list = [0 for _ in range(8001)]
for i in range(N):
    now = int(sys.stdin.readline().rstrip())
    sort_list[now + 4000] += 1
    num_list.append(now)
# 산술평균
v_sum = sum(num_list)
if v_sum > 0:
    print(int(v_sum/N + 0.5))
elif v_sum == 0:
    print(0)
else:
    print(int(v_sum/N - 0.5))

num_list.sort()
# 중앙값
print(num_list[N//2])
# 최빈값 구하기
count = 0
save_i = 0
max_f = 0
min_v = 8001
max_v = 0
for i in range(8001):
    if sort_list[i] != 0:
        if min_v > i:
            min_v = i
        if max_v < i:
            max_v = i
    if sort_list[i] > max_f:
        max_f = sort_list[i]
        save_i = i
        count = 0
    elif sort_list[i] == max_f:
        count += 1
# 최빈값이 여러개인 경우
second_v = 0
if count > 0:
    for j in range(8001):
        if sort_list[j] == max_f:
            if second_v == 1:
                print(j - 4000)
                break
            second_v += 1
# 최빈값이 하나인 경우
else:
    print(save_i - 4000)

# 범위 출력
print(max_v - min_v)
