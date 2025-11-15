def main():
    slen = int(input("How many scores? "))
    s = [float(input("Enter a score: ")) for _ in range(slen)]

    avg = sum(s) / slen
    print(f"The average score is {avg}")
    print(f"The highest score is {max(s)}")

    for i in s:
        i = round(i, 2)
        by = round(abs(i-avg), 2)
        if i > avg:
            print(f"{i} is above the average by {by}")
        elif i < avg:
            print(f"{i} is below the average by {by}")
        else:
            print(f"{i} is equivalent to the average")


if __name__ == "__main__":
    main()
