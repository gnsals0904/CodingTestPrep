num = input()
num = "0b" + num
int_num = int(num, 2) * 17
bin_num = bin(int_num)
print(bin_num[2:len(bin_num)])