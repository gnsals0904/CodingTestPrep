import sys

num_list = []
N = int(sys.stdin.readline().rstrip())
for _ in range(N):
    num_list.append(int(sys.stdin.readline().rstrip()))
num_list.sort()
for i in range(N):
    print(num_list[i])
