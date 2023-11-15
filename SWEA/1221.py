alien_num_dic = {"ZRO": 0, "ONE": 1, "TWO": 2, "THR": 3, "FOR": 4, "FIV": 5, "SIX": 6, "SVN": 7, "EGT": 8, "NIN": 9}
alien_num_dic2 = {0: "ZRO", 1: "ONE", 2: "TWO", 3: "THR", 4: "FOR", 5: "FIV", 6: "SIX", 7: "SVN", 8: "EGT", 9: "NIN"}
trash = input()
for test_case in range(1, 11):
    one_line = list(map(str, input().split()))
    next_line = list(map(str, input().split()))
    # 계수 정렬
    sort_list = [0 for _ in range(10)]
    for x in next_line:
        sort_list[alien_num_dic[x]] += 1
    # 정렬된 수 출력
    result = []
    for i in range(10):
        num = sort_list[i]
        s = alien_num_dic2[i]
        for j in range(num):
            result.append(s)
    print(f"#{test_case}")
    print(*result)
