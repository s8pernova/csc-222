import sys


class Pet:
    def __init__(self, name="No name yet.", age=0, weight=0.0):
        self.name = name

        if age < 0 or weight < 0:
            print("Error: Negative age or weight.")
            sys.exit(0)
        else:
            self.age = age
            self.weight = weight

    def set_name(self, new_name):
        self.name = new_name

    def set_age(self, new_age):
        if new_age < 0:
            print("Error: Negative age.")
            sys.exit(0)
        else:
            self.age = new_age

    def set_weight(self, new_weight):
        if new_weight < 0:
            print("Error: Negative weight.")
            sys.exit(0)
        else:
            self.weight = new_weight

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

    def get_weight(self):
        return self.weight

    def write_output(self):
        print(f"Name: {self.name}")
        print(f"Age: {self.age} years")
        print(f"Weight: {self.weight} pounds")


class Dog(Pet):
    def __init__(self, name="No name yet.", age=0, weight=0.0, breed: str = None, booster_shot: bool = False):
        super().__init__(name, age, weight)
        self.breed = breed
        self.booster_shot = booster_shot

    def write_output(self):
        super().write_output()
        print(f"Breed: {self.breed}")
        print(f"Booster Shot: {self.booster_shot}")


def main():
    dog = Dog(name="Fido", age=3, weight=40, breed="Alaskin Malamute", booster_shot=True)
    dog.write_output()


if __name__ == "__main__":
    main()
