import sys
from enum import IntEnum
from functools import wraps


def if_invalid(error_message: str = "Invalid input. Try again."):
    """Decorator to handle ValueError exceptions with custom error messages."""
    def wrapper(func):
        @wraps(func)
        def inner(*args, **kwargs):
            while True:
                try:
                    return func(*args, **kwargs)
                except ValueError:
                    print(error_message)
        return inner
    return wrapper


class ShapeType(IntEnum):
    """Available shape types."""
    TRIANGLE = 1
    DIAMOND = 2
    EXIT = 3


class Draw:
    """Handles drawing of ASCII shapes."""

    def __init__(self, input_dict: dict[str, int | str]) -> None:
        self.shape: int = input_dict["shape"]
        self.char: str = input_dict["char"]
        self.size: int = input_dict["size"]

    def draw(self) -> None:
        """Draw the selected shape."""
        if self.shape == ShapeType.TRIANGLE:
            self._draw_triangle()
        elif self.shape == ShapeType.DIAMOND:
            self._draw_diamond()

    def _draw_triangle(self) -> None:
        """Draw a triangle shape."""
        for i in range(1, self.size + 1):
            print(" " * (self.size - i) + self.char * (2 * i - 1))

    def _draw_diamond(self) -> None:
        """Draw a diamond shape."""
        # Top half
        for i in range(1, self.size + 1):
            print(" " * (self.size - i) + self.char * (2 * i - 1))
        # Bottom half
        for i in range(self.size - 1, 0, -1):
            print(" " * (self.size - i) + self.char * (2 * i - 1))


class AsciiShapes:
    """Main application for drawing ASCII shapes."""

    def run(self) -> None:
        user_input = self._get_user_inputs()
        draw = Draw(user_input)
        draw.draw()

    @staticmethod
    @if_invalid("Invalid input. Please enter a number between 1 and 3.\n")
    def _get_shape_selection() -> int:
        """Prompt user to select a shape."""
        valid_shapes = [ShapeType.TRIANGLE, ShapeType.DIAMOND, ShapeType.EXIT]

        print("Select a shape:")
        print(f"{ShapeType.TRIANGLE}) Triangle")
        print(f"{ShapeType.DIAMOND}) Diamond")
        print(f"{ShapeType.EXIT}) Exit\n")

        shape = int(input())

        if shape == ShapeType.EXIT:
            sys.exit()

        if shape not in valid_shapes:
            raise ValueError("Invalid shape selection")

        return shape

    @staticmethod
    @if_invalid("Invalid input. Please enter exactly one character.")
    def _get_character() -> str:
        """Prompt user to select a character."""
        character = input("\nSelect a character: ")

        if len(character) != 1:
            raise ValueError("Character must be exactly one character")

        return character

    @staticmethod
    @if_invalid("Invalid input. Please enter a positive number.")
    def _get_size() -> int:
        """Prompt user to select a size."""
        size = int(input("\nSelect a size: "))

        if size <= 0:
            raise ValueError("Size must be positive")

        return size

    def _get_user_inputs(self) -> dict[str, int | str]:
        """Collect all user inputs."""
        return {
            "shape": self._get_shape_selection(),
            "char": self._get_character(),
            "size": self._get_size(),
        }


if __name__ == "__main__":
    AsciiShapes().run()
