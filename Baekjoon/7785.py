import sys

n = int(input())
people = set()
for _ in range(n):
    s1, s2 = sys.stdin.readline().split()
    if s2 == 'enter':
        if s1 not in people:
            people.add(s1)
    else:
        if s1 in people:
            people.remove(s1)
result = list(people)
result.sort(reverse=True)
for x in result:
    print(x)
