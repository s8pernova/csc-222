import math


class NotARealTriangleError(Exception):
    pass


class Triangle:
    def __init__(self, side1: float = 0, side2: float = 0, side3: float = 0):
        self.side1 = side1
        self.side2 = side2
        self.side3 = side3

    def _is_real_triangle(self) -> bool:
        if (
            self.side1 + self.side2 > self.side3 and
            self.side1 + self.side3 > self.side2 and
            self.side2 + self.side3 > self.side1
        ):
            return True
        return False

    def _get_perimeter(self) -> float:
        """
        A method that calculates and returns the Perimeter of the Triangle: 
            The perimeter of a triangle is simply the sum of all three sides of the triangle.
        """
        perimeter = self.side1 + self.side2 + self.side3
        return round(perimeter, 2)

    def _is_equilateral(self) -> bool:
        """
        A boolean method that determines whether the triangle is Equilateral: 
            A triangle is equilateral iff all the THREE sides of the triangle are equal. 
        """
        if self.side1 == self.side2 == self.side3:
            return True
        return False

    def _get_area(self) -> float:
        """
        A method that calculates and returns the area of the triangle: 
            The area of a triangle is given by the following formula: 
                Given the three sides of the triangle (say a, b and c), S = (a + b + c)/2. 
                Then, Area = square root (S * (S - a) * (S - b) * (S - c)).
        """
        semi_perimeter = (self.side1 + self.side2 + self.side3) / 2
        area = math.sqrt(
            semi_perimeter *
            (semi_perimeter - self.side1) *
            (semi_perimeter - self.side2) *
            (semi_perimeter - self.side3)
        )
        return round(area, 2)

    def input(self) -> None:
        """
        Obtains the appropriate values for the three sides from the user. 
        If the input is invalid, then an error message should be sent to the user.
        """
        self.side1 = round(float(input("Please enter the value for side 1: ")), 2)
        self.side2 = round(float(input("Please enter the value for side 2: ")), 2)
        self.side3 = round(float(input("Please enter the value for side 3: ")), 2)
        print()

        if not self._is_real_triangle():
            raise NotARealTriangleError

    def output(self) -> None:
        """
        An output method that prints all three sides of the Triangle and 
        other information (as show in the sample I/O) on the user screen. 

        PRINT EXAMPLES:
        ```
        The three sides that you entered are: 12.1, 13.1 and 14.1
        The perimeter of the triangle is: 41.3
        The triangle IS NOT equilateral.
        The area of the triangle is: 80.11.
        ```
        """
        print(f"The three sides that you entered are: {self.side1}, {self.side2}, and {self.side3}")
        print(f"The perimeter of the triangle is: {self._get_perimeter()}")
        print("The triangle is equilateral.") if self._is_equilateral() else print("The triangle is NOT equilateral.")
        print(f"The area of the triangle is: {self._get_area()}")


def main():
    triangle = Triangle()
    triangle.input()
    triangle.output()


if __name__ == "__main__":
    main()
