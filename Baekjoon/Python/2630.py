N = int(input())
paper = []
# 0은 체크하지 않은 것
check = [[0 for _ in range(N)] for _ in range(N)]
white_paper = 0
blue_paper = 0
for _ in range(N):
    one_line = list(map(int, input().split()))
    paper.append(one_line)
now_N = N

while now_N >= 1:
    for kx in range(0, N, now_N):
        for ky in range(0, N, now_N):
            complete_same_color = True
            color = 2
            # 탐색 안한 부분이면 탐색진행
            if check[kx][ky] != 1:
                color = paper[kx][ky]
                for i in range(now_N):
                    for j in range(now_N):
                        if color != paper[kx + i][ky + j]:
                            complete_same_color = False
                    if not complete_same_color:
                        break
            # 이미 탐색 완료한 부분이면 다음으로
            elif check[kx][ky] == 1:
                continue
            if complete_same_color:
                # 탐색을 완료했으므로 방문 처리
                for i in range(now_N):
                    for j in range(now_N):
                        check[kx + i][ky + j] = 1
                if color == 0:
                    white_paper += 1
                elif color == 1:
                    blue_paper += 1
    now_N = now_N // 2

print(white_paper)
print(blue_paper)
