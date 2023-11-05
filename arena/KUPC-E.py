N = int(input())
S = input()
if N % 2 == 0:
    s1 = S[: N // 2]
    s2 = S[N // 2:]
else:
    s1 = S[: N // 2]
    s2 = S[N // 2 + 1:]
abc_num = [0 for _ in range(26)]
basic = ord('a')
for i in range(N // 2):
    abc_num[ord(s1[i]) - basic] += 1
    abc_num[ord(s2[i]) - basic] += 1

check = True
for j in range(26):
    if abc_num[j] % 2 != 0:
        check = False
        break
if not check:
    print('No')
else:
    print('Yes')
