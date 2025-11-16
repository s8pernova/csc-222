"""
In this program, you need to implement a class called Time. Time class will have six integer data fields, which are as follows:

year
month
day
hour
minute
second
a) Your program needs to have an input method that receives input from keyboard and assigns corresponding values to each Time object that is declared (for example for object t1, year = 2018, month=10, day = 4, hour = 18, minute = 14 and second = 18). Assume that the values are input in the military time format.

b) In addition, implement the following two methods

PrintStandardTime: this method will print to the screen, the time in the standard format, (month-day-year, hour:minute:second AM/PM) 10-4-2018, 6:14:18 PM.
PrintMilitaryTime: this method will print to the screen, the time in the military format, (day-month-year, hour:minute:second) 4-10-2018, 18:14:18.
The following is a sample output expected from your program:

Assume that for an object t1 of class Time, you have set the year value à 2018, month value à 10, day value à 4, hour value à 19, the minute value à 25 and the second value à 46. Then, the output screen should read:

Based on your entry, the Standard time is 10-4-2018, 7:25:46 PM[1]

Based on your entry, the Military time is 4-10-2018, 19:25:46[2]

c) Please provide additional functionality to your program so that it can detect invalid time entries just for hours, minutes and seconds. For example, 27:12:42 is an invalid time entry because the hour member variable can never be greater than 23. In case the user types in an invalid entry, your program should give back an error message to the user stating that the entry is not valid.

[1] For the call to Printstandardtime.

[2] For the call to Printmilitarytime.
"""


class InvalidTimeError(Exception):
    """Custom exception for invalid time entries."""
    pass


class Time:
    def __init__(self, year: int, month: int, day: int, hour: int, minute: int, second: int):
        self.year = year
        self.month = month
        self.day = day
        self.hour = hour
        self.minute = str(minute).zfill(2)
        self.second = str(second).zfill(2)

    def print_standard_time(self) -> None:
        """
        This method will print the time in the standard format.
        e.g. (month-day-year, hour:minute:second AM/PM) 10-4-2018, 6:14:18 PM
        """
        am_or_pm = "PM" if self.hour > 12 else "AM"
        print(f"Based on your entry, the Standard time is {self.month}-{self.day}-{self.year}, {self.hour % 12}:{self.minute}:{self.second} {am_or_pm}")

    def print_military_time(self) -> None:
        """
        This method will print the time in the military format.
        e.g. (day-month-year, hour:minute:second) 4-10-2018, 18:14:18
        """
        print(f"Based on your entry, the Military time is {self.day}-{self.month}-{self.year}, {self.hour}:{self.minute}:{self.second}")


def main():
    try:
        year = int(input("Enter year: "))
        assert 0 < year
        month = int(input("Enter month: "))
        assert 0 < month < 12
        day = int(input("Enter day: "))
        assert 0 < day < 31
        hour = int(input("Enter hour: "))
        assert 0 < hour < 24
        minute = int(input("Enter minute: "))
        assert 0 < minute < 60
        second = int(input("Enter second: "))
        assert 0 < second < 60
    except InvalidTimeError as e:
        print(f"Invalid input: {e}")

    time = Time(year, month, day, hour, minute, second)
    time.print_standard_time()
    time.print_military_time()


if __name__ == "__main__":
    main()
