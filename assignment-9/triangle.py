"""
Write another class with the corresponding main method that tests the Triangle class and produce the following outputs:

Here is some sample output:

(from input() method)

Please enter the value for side 1: 12.1

Please enter the value for side 2: 14.1

Please enter the value for side 3: 15.1

(from the output() method, which invokes other methods)

The three sides that you entered are: 12.1, 13.1 and 14.1

The perimeter of the triangle is: 41.3

The triangle IS NOT equilateral.

The area of the triangle is: 80.11.
"""


class NotARealTriangleError:
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

    def input(self) -> None:
        """
        A method that calculates and returns the Perimeter of the Triangle: 
            The perimeter of a triangle is simply the sum of all three sides of the triangle.
        """
        self.side1 = float(input("Please enter the value for side 1: "))
        self.side2 = float(input("Please enter the value for side 2: "))
        self.side3 = float(input("Please enter the value for side 3: "))

        if not self._is_real_triangle():
            raise NotARealTriangleError

    def perimeter(self) -> float:
        """
        A method that calculates and returns the Perimeter of the Triangle: 
            The perimeter of a triangle is simply the sum of all three sides of the triangle.
        """
        perimeter = self.side1 + self.side2 + self.side3
        return round(perimeter, 2)

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
        print(f"The three sides that you entered are: {self.side1}, {self.side2} and {self.side3}")
        print(f"The perimeter of the triangle is: {self.perimeter()}")
        print("The triangle is equilateral.") if self.isEquilateral() else print("The triangle is NOT equilateral.")
        print(f"The area of the triangle is: {self.area()}")

    def isEquilateral(self) -> bool:
        """
        A boolean method that determines whether the triangle is Equilateral: 
            A triangle is equilateral if and only if all the THREE sides of the triangle are equal. 

        If the triangle is equilateral, a message conveying this should be sent to the screen. 
        If the triangle is not equilateral, then the corresponding message should be sent to the screen.

        EXAMPLE: 
        if a = 3.4, b = 5.6 and c = 23.7, then the output message should read "the triangle IS NOT equilateral."
        """
        pass

    def area(self) -> float:
        """
        A method that calculates and returns the area of the triangle: 
            The area of a triangle is given by the following formula: 
                Given the three sides of the triangle (say a, b and c), S = (a + b + c)/2. 
                Then, Area = square root (S * (S - a) * (S - b) * (S - c)).
        """
        area = ...
        return round(area, 2)


def main():
    triangle = Triangle()
    triangle.input()


if __name__ == "__main__":
    main()
