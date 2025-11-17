def read_words_from_file(file_name) -> list[str]:
    words = []
    with open(file_name) as file:
        for line in file:
            word = line.strip().lower()
            if word:
                words.append(word)
    return words


def main() -> None:
    file = "/home/achrunaway/git-projects/csc-222/in-class-10/dict10.txt"
    words = read_words_from_file(file)
    flag = True
    while flag:
        user_word = input("Search for: ").lower()
        if user_word == "stop":
            flag = False
        elif user_word in words:
            print(f"`{user_word}` was found at position {words.index(user_word) + 1}")
        else:
            print(f"Sorry. `{user_word} was not found.")
        print()
    print("Bye!")


if __name__ == "__main__":
    main()
