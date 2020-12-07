#!/home/bobby/anaconda3/bin/python3

def read_file(filename):
    with open(filename) as file:
        return file.readlines()
    
def total_sum(line_list):
    line_list.extend("\n") # force last entry to be a new line
    count_1 = 0
    count_2 = 0
    group = []
    for line in line_list:
        line = line.rstrip("\n")
        if line == "":
            print(*group)
            count_1 += len(set.union(*group))
            count_2 += len(set.intersection(*group))
            print(count_1)
            group = []
        else:
            group.append(set(line))
            
    return count_1, count_2
    
if __name__ == "__main__":
    input = read_file("test_input.txt")
    answer = total_sum(input)
    print(f"Part 1: {answer[0]}")
    print(f"Part 2: {answer[1]}")
