from math import sqrt


def is_prime(n: int) -> bool:
    for i in range(2, int(sqrt(n)) + 1):
        if n % i == 0:
            return False


[print(f"Is {i} prime? {is_prime(i)}") for i in range(1, 10)]
