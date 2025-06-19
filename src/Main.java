import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Do you want to enter the values manually or generate them automatically?");

        int checkFirstAnswer = getNumberFirstAnswer(in);

        switch (checkFirstAnswer) {
            case 1:
                int numberForFirstTaskFromUser = getNumberForFirstTaskFromUser(in);
                String nameForSecondTaskFromUser = getStringForSecondTaskFromUser(in);
                int[] userArray = getArrayForThirdTaskFromUser(in);

                printResults(numberForFirstTaskFromUser, nameForSecondTaskFromUser, userArray);
                break;
            case 2:
                Random rand = new Random();

                //Random Number
                int numberForFirstTask = rand.nextInt(0, 10);

                //Random String
                byte[] arrayOfBytes = new byte[4];

                //26 symbols (Starts with A)
                arrayOfBytes[0] = (byte) (rand.nextInt(26) + 'A');

                for (int i = 1; i < arrayOfBytes.length; i++)
                    arrayOfBytes[i] = (byte) (rand.nextInt(26) + 'a');

                String nameForTheSecondTask = new String(arrayOfBytes, StandardCharsets.UTF_8);

                //Random Array
                int[] arrayAuto = new int[10];
                for (int i = 0; i < arrayAuto.length; i++) {
                    arrayAuto[i] = rand.nextInt(0, 100);
                }

                printResults(numberForFirstTask, nameForTheSecondTask, arrayAuto);
                break;
            case 3:
                System.out.println("You have exited the program.");
                break;
            default:
                System.out.println("The value is incorrect!");
        }
    }

    static void biggerThanSeven(int num) {
        if (num > 7) System.out.println("Hello");
        else System.out.println("Your number must be greater than 7!");
    }

    static void checkName(String name) {
        String checkResult = (name.equals("John")) ? "Hello, John" : "There is no such name";
        System.out.println(checkResult);
    }

    static int[] getArrayMultiplesThree(int[] numArray) {
        return Arrays.stream(numArray)
                .filter(num -> num % 3 == 0)
                .toArray();
    }

    static int getNumberFirstAnswer(Scanner in) {
        int checkFirstAnswer;

        while (true) {
            try {
                System.out.println("1 - Manual input | 2 - Automatic input | 3 - Exit");
                checkFirstAnswer = in.nextInt();

                if (checkFirstAnswer == 1 || checkFirstAnswer == 2 || checkFirstAnswer == 3) break;
                else System.out.println("Invalid input! Please try again.");
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                in.nextLine();
            }
        }

        return checkFirstAnswer;
    }

    static int getNumberForFirstTaskFromUser(Scanner in) {
        int numberForFirstTaskFromUser;

        while (true) {
            try {
                System.out.println("Enter your number for task 1: ");
                numberForFirstTaskFromUser = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                in.nextLine();
            }
        }

        return numberForFirstTaskFromUser;
    }

    static String getStringForSecondTaskFromUser(Scanner in) {
        System.out.println("Enter your string for task 2: ");
        return in.next();
    }

    static int[] getArrayForThirdTaskFromUser(Scanner in) {
        int[] userArray;

        while (true) {
            try {
                System.out.println("Enter array length for task 3: ");
                int arrayLengthFromUser = in.nextInt();

                userArray = new int[arrayLengthFromUser];

                for (int i = 0; i < arrayLengthFromUser; i++) {
                    System.out.println("Enter array element number " + (i + 1) + " :");
                    int valueFromUser = in.nextInt();

                    userArray[i] = valueFromUser;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                in.nextLine();
            }
        }

        return userArray;
    }

    static void printResults(int num, String name, int[] array) {
        System.out.println("Results:");
        System.out.print("Task 1: Your value: " + num + ". Result: ");
        biggerThanSeven(num);

        System.out.print("Task 2: Your value: " + name + ". Result: ");
        checkName(name);

        System.out.print("Task 3: Your array: " + Arrays.toString(array) + ". Result: ");
        int[] resultArrayFromUser = getArrayMultiplesThree(array);
        System.out.println(Arrays.toString(resultArrayFromUser));
    }
}