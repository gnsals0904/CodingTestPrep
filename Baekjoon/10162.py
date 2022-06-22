second = int(input())
A = 60 * 5
B = 60 * 1
C = 10
temp_second = second % A
if temp_second == 0:
    print(second//A, 0, 0)
else:
    temp_A = second // A
    temp_second2 = temp_second % B
    if temp_second2 == 0:
        print(temp_A, temp_second//B, 0)
    else:
        temp_B = temp_second // B
        temp_second3 = temp_second2 % C
        if temp_second3 == 0:
            print(temp_A, temp_B, temp_second2//C)
        else:
            print("-1")