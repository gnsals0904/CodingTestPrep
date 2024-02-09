N = int(input())
# 세로 확인
visited_1 = [False for _ in range(N)]
# / 대각선 확인
visited_2 = [False for _ in range(2 * N)]
# \ 대각선 확인
visited_3 = [False for _ in range(2 * N)]
result = 0


def func(k):
    global result
    if k == N:
        result += 1
        return
    for i in range(N):
        if visited_1[i] or visited_2[i + k] or visited_3[k - i + N - 1]:
            continue
        # 세로
        visited_1[i] = True
        # /
        visited_2[i + k] = True
        # \
        visited_3[k - i + N - 1] = True
        # depth up
        func(k + 1)
        visited_1[i] = False
        visited_2[i + k] = False
        visited_3[k - i + N - 1] = False


func(0)
print(result)
