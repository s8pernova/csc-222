words = [
    "apple",
    "bear",
    "cat",
    "dog",
    "egg",
    "file",
    "google",
    "hello",
    "iphone",
    "jeep",
]


def main():
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
