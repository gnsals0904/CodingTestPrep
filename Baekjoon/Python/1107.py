import sys


N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
now_channel = 100
if M != 0:
    cant_used = list(map(str, sys.stdin.readline().split()))
else:
    cant_used = []
if N == 100:
    print(0)
else:
    count = len(cant_used)
    hand_result = N - now_channel
    if hand_result < 0:
        hand_result *= -1
    if count == 10:
        print(hand_result)
    else:
        min_v = 1000001
        for i in range(1000001):
            flag = False
            for j in str(i):
                if j in cant_used:
                    flag = True
                    break
            if not flag:
                len_str_i = len(str(i))
                temp = abs(i - N)
                if (len_str_i + temp) < min_v:
                    min_v = len_str_i + temp
        print(min(hand_result, min_v))
