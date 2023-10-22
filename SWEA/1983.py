t = int(input())
for i in range(t):
    entire_student_number, target_student_number = map(int, input().split())
    student_score_list = []
    for _ in range(entire_student_number):
        score_list = list(map(int, input().split()))
        entire_score = round(score_list[0] * 35 / 100 + score_list[1] * 45 / 100 + score_list[2] * 20 / 100)
        student_score_list.append(entire_score)
    sort_score_list = sorted(student_score_list, reverse=True)
    target_student_score = student_score_list[target_student_number - 1]
    target_student_rank = sort_score_list.index(target_student_score)
    rank_partition = entire_student_number // 10
    if 0 <= target_student_rank < rank_partition:
        print('#' + str(i + 1) + ' A+')
    elif rank_partition <= target_student_rank < 2 * rank_partition:
        print('#' + str(i + 1) + ' A0')
    elif 2 * rank_partition <= target_student_rank < 3 * rank_partition:
        print('#' + str(i + 1) + ' A-')
    elif 3 * rank_partition <= target_student_rank < 4 * rank_partition:
        print('#' + str(i + 1) + ' B+')
    elif 4 * rank_partition <= target_student_rank < 5 * rank_partition:
        print('#' + str(i + 1) + ' B0')
    elif 5 * rank_partition <= target_student_rank < 6 * rank_partition:
        print('#' + str(i + 1) + ' B-')
    elif 6 * rank_partition <= target_student_rank < 7 * rank_partition:
        print('#' + str(i + 1) + ' C+')
    elif 7 * rank_partition <= target_student_rank < 8 * rank_partition:
        print('#' + str(i + 1) + ' C0')
    elif 8 * rank_partition <= target_student_rank < 9 * rank_partition:
        print('#' + str(i + 1) + ' C-')
    else:
        print('#' + str(i + 1) + ' D0')
