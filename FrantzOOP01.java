//Shane Frantz

import java.util.Scanner;

class FrantzOOP01 {
    //declaring variables
    static Student student = new Student();
    static Scanner scan = new Scanner(System.in);
    static String text = null;


    //flags to check if name, grade, and gpa have all been entered
    public static boolean flag1 = false;
    public static boolean flag2 = false;
    public static boolean flag3 = false;

    public static void main(String[] args) {
        clearScreen();
        menu();
    }

    public static void menu() {
        //prints menu
        System.out.print("1. Enter Students Name\n2. Enter Students Academic Year\n3. Enter Students GPA\n4. Display Students Info\n5. Exit\nPlease enter which number you want to answer: ");
        int value = getInt();
        //checking if value entered is inside the range of the menu
        if (value < 1 || value > 5) {
            clearScreen();
            System.out.print("That number is not on the menu. Try again.\n");
        }

        else if (value == 1) {
            System.out.print("Enter Students Name: ");
            scan.nextLine();
            //scanning for input and then using input to set the name
            text = scan.nextLine();
            student.setName(text);
            flag1 = true;
            clearScreen();
        }

        else if(value == 2) {
            System.out.print("Enter Students Academic Year: ");
            scan.nextLine();
            //while loop to get input until valid year is entered
            while (true) {
                text = scan.nextLine();
                student.setGrade(text);
                if (!(student.getGrade().equalsIgnoreCase("Freshman") || student.getGrade().equalsIgnoreCase("Sophomore") || student.getGrade().equalsIgnoreCase("Junior") || student.getGrade().equalsIgnoreCase("Senior"))) {
                    clearScreen();
                    System.out.print("That is not a valid grade. Choose Freshman, Sophomore, Junior, or Senior.\n1. Enter Students Name\n2. Enter Students Academic Year\n3. Enter Students GPA\n4. Display Students Info\n5. Exit\nPlease enter which number you want to answer: 2\nEnter Students Academic Year: ");
                    continue;
                }
                else {
                    flag2 = true;
                    clearScreen();
                    break;
                }
            }
        }

        else if (value == 3) {
            System.out.print("Enter Students GPA: ");
            scan.nextLine();
            //while loop to get input until valid gpa is entered
            while (true) {
                student.setGPA(getDouble());
                //checking for gpa between 0 and 4
                if (student.getGPA() < 0 || student.getGPA() > 4.0) {
                    clearScreen();
                    System.out.print("That is not a valid GPA. The GPA must be between 0 and 4.0.\n1. Enter Students Name\n2. Enter Students Academic Year\n3. Enter Students GPA\n4. Display Students Info\n5. Exit\nPlease enter which number you want to answer: 3\nEnter Students GPA: ");
                }
                else {
                    flag3 = true;
                    clearScreen();
                    break;
                }
            }
        }

        else if (value == 4) {
            //checking to see if all values have been entered via the flags
            if (flag1 && flag2 && flag3) {
                clearScreen();
                System.out.println("\nThe students name is: " + student.getName() + "\nThe students academic year is: " + student.getGrade() + "\nThe students GPA is: " + student.getGPA() + "\nType clear to clear the terminal screen to continue");

                while (true) {
                    if (scan.nextLine().equalsIgnoreCase("clear")) {
                        clearScreen();
                        break;
                    }
                }
            }

            else {
                //constructing a string and adding on based on which flags are missing, aka which values have not been inputted
                String missingCredentials = "You have not completed all requirements. The following credentials are missing: ";

                if (flag1 == false)
                    missingCredentials = missingCredentials + "\nName";
                if (flag2 == false)
                    missingCredentials = missingCredentials + "\nClass Year";
                if (flag3 == false)
                    missingCredentials = missingCredentials + "\nGPA";
                clearScreen();
                System.out.print(missingCredentials + "\n\n");
            }
        }

        else if (value == 5)
            //returns nothing and breaks out of the method, ending the program
            return;
        //using recursion to print the menu again
        menu();
    }

    public static int getInt() {
        //method for error handling when getting an integer
        try {
            int number = scan.nextInt();
            return number;
        }
        catch (Exception e) {
            clearScreen();
            System.out.print("That is not a valid number. Try again.\n1. Enter Students Name\n2. Enter Students Academic Year\n3. Enter Students GPA\n4. Display Students Info\n5. Exit\nPlease enter which number you want to answer: ");
            scan.next();
            return getInt();
        }
    }

    public static double getDouble() {
        //method for error handling when getting a double
        try {
            double number = scan.nextDouble();
            return number;
        }
        catch (Exception e) {
            clearScreen();
            System.out.print("That is not a valid number. Try again.\n1. Enter Students Name\n2. Enter Students Academic Year\n3. Enter Students GPA\n4. Display Students Info\n5. Exit\nPlease enter which number you want to answer: ");
            scan.next();
            return getDouble();
        }
    }

    public static void clearScreen() {
        //method to "clear the screen" by printing 300 new lines
        for (int i = 0; i < 300; i++)
            System.out.print("\n");
    }
}

class Student {
    //student class with methods that handle setting and getting variables to be used in menu.

    public String name = null;
    public String grade = null;
    public double gpa = -1;

    public void setName(String studentName) {
        name = studentName;
    }

    public void setGrade(String studentGrade) {
        grade = studentGrade;
    }

    public void setGPA(double studentGPA) {
        gpa = studentGPA;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public double getGPA() {
        return gpa;
    }

}
