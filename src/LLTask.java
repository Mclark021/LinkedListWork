import java.util.InputMismatchException;
import java.util.Scanner;

public class LLTask {
    private static LinkedListNode<Integer> intList = null;
    private static LinkedListNode<Fraction> fracList = null;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.print("""
                1) Author info
                2) Enter Integer
                3) Enter Fraction
                4) Print Integers
                5) Print Fractions
                0) Exit
                """);
        int userChoice = 0;
        do {
            try {
                System.out.print("Enter choice: ");
                Scanner scanner = new Scanner(System.in);
                userChoice = scanner.nextInt();
                if (userChoice == 1) {
                    printAuthorInfo();
                } else if (userChoice == 2) {
                    addInteger();
                } else if (userChoice == 3) {
                    addFraction();
                } else if (userChoice == 4) {
                    printIntegers();
                } else if (userChoice == 5) {
                    printFraction();
                } else if (userChoice == 0) {
                    System.exit(0);
                } else if (5 < userChoice || userChoice < 0){
                    System.out.println("Not valid option, enter new option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not an int, enter new choice: ");
            }
        } while (userChoice != 0);

    }

    public static void printAuthorInfo(){
        System.out.println("""
                Michael Clark
                2734077
                """);
        menu();
        return;
    }

    public static void addInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Integer: ");
        Integer userInteger = scanner.nextInt();
        LinkedListNode<Integer> newNode = new LinkedListNode<>(userInteger);

        if (intList == null || userInteger <= intList.data) {
            newNode.next = intList;
            intList = newNode;
        } else {
            LinkedListNode<Integer> temp = intList;

            while (temp.next != null && temp.next.data < userInteger) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }
        menu();
        return ;

    }



    public static void printIntegers(){
        if (intList == null) {
            System.out.println("Nothing entered.");
            return;
        }

        System.out.println("Entered integers:");

        LinkedListNode<Integer> current = intList;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
        menu();
        return;
    }

    public static void addFraction(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int numerator = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int denominator = scanner.nextInt();
        Fraction fraction = new Fraction(numerator, denominator);
        LinkedListNode<Fraction> newNode = new LinkedListNode<>(fraction);

        if (fracList == null || fraction.compareDecimals(fracList.data) <= 0) {
            newNode.next = fracList;
            fracList = newNode;
        } else {
            LinkedListNode<Fraction> temp = fracList;

            while (temp.next != null && fraction.compareDecimals(temp.next.data) > 0) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }
        menu();
        return;

    }

    public static void printFraction(){
        if (fracList == null) {
            System.out.println("Nothing entered.");
            return;
        }

        System.out.println("Entered fractions:");
        LinkedListNode<Fraction> current = fracList;

        while (current != null) {
            System.out.print(current.data.toMixedNumber() + " ");
            current = current.next;
        }
        System.out.println();
        menu();
        return;

    }
}
