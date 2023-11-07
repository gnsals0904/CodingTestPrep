t = int(input())
for tc in range(t):
    target_s = list(map(int, input()))
    count = 0
    len_s = len(target_s)
    now_s = [0 for _ in range(len_s)]
    for i in range(len_s):
        if target_s[i] != now_s[i]:
            if target_s[i] == 1:
                for j in range(i, len_s):
                    now_s[j] = 1
                count += 1
            else:
                for j in range(i, len_s):
                    now_s[j] = 0
                count += 1

    print("#" + str(tc + 1), count)
