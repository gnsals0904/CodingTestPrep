import sys


N, M = map(int, input().split())
pwd_list = {}
for i in range(N):
    s, pwd = map(str, sys.stdin.readline().split())
    pwd_list[s] = pwd
find_pwd_list = []
for _ in range(M):
    s = sys.stdin.readline().rstrip()
    find_pwd_list.append(s)
for j in range(M):
    now_find_pwd = find_pwd_list[j]
    print(pwd_list[now_find_pwd])
