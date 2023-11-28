def merge(start, end):
    mid = (start + end) // 2
    l_idx = start
    r_idx = mid
    for i in range(start, end):
        if r_idx == end:
            temp_list[i] = num_list[l_idx]
            l_idx += 1
        elif l_idx == mid:
            temp_list[i] = num_list[r_idx]
            r_idx += 1
        elif num_list[l_idx] <= num_list[r_idx]:
            temp_list[i] = num_list[l_idx]
            l_idx += 1
        else:
            temp_list[i] = num_list[r_idx]
            r_idx += 1
    for i in range(start, end):
        num_list[i] = temp_list[i]


def merge_sort(start, end):
    if start + 1 == end:
        return
    mid = (start + end) // 2
    merge_sort(start, mid)
    merge_sort(mid, end)
    merge(start, end)


num_list = list(map(int, input().split()))
len_num_list = len(num_list)
temp_list = [0 for _ in range(len_num_list)]
merge_sort(0, len_num_list)
print(num_list)
