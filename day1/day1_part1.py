#!/home/bobby/anaconda3/bin/python3

def read_file(filename):
    with open(filename) as f:
        return [int(x) for x in f]

def calculate(list):
    n = len(list)
    for i in range(0, n):
        for j in range(i, n):
            if list[i] + list[j] == 2020:
                return list[i] * list[j]

if __name__ == "__main__":
    input = read_file("input")
    print(calculate(input))
