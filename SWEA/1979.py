t = int(input())
for i in range(t):
    n, k = map(int, input().split())
    puzzle = []
    for i_1 in range(n):
        # string input list
        one_line = list(map(str, input().split()))
        puzzle.append(one_line)
    result = 0
    reverse_puzzle = [[] for _ in range(n)]
    find_str = '1' * k
    for j in range(n):
        for k in range(n):
            reverse_puzzle[j].append(puzzle[k][j])
    for num1 in range(n):
        str_puzzle = ''.join(puzzle[num1])
        str_puzzle_list = str_puzzle.split('0')
        str_reverse_puzzle = ''.join(reverse_puzzle[num1])
        str_reverse_puzzle_list = str_reverse_puzzle.split('0')
        for x in str_puzzle_list:
            if x == find_str:
                result += 1
        for z in str_reverse_puzzle_list:
            if z == find_str:
                result += 1
    print("#" + str(i + 1), result)
