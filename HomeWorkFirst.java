import java.util.ArrayList;
import java.util.Scanner;

public class HomeWorkFirst {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nChoose the problem:\n" +
                    "1. Palindrome\n" +
                    "2. Sum of two numbers\n" +
                    "3. Length of the last world\n" +
                    "4. SQRT\n" +
                    "5. Fizz-Buzz\n" +
                    "6. Fibonacci numbers\n" +
                    "7. Division\n" +
                    "0. Exit\n");
            choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    Solutions.isPalindrome();
                    break;
                case 2:
                    Solutions.twoSum();
                    break;
                case 3:
                    Solutions.lengthOfLastWord();
                    break;
                case 4:
                    Solutions.mySqrt();
                    break;
                case 5:
                    Solutions.fizzBuzz();
                    break;
                case 6:
                    Solutions.fibonacci();
                    break;
                case 7:
                    Solutions.Division();
                    break;

            }
        } while (choice != 0);

    }
}

class Solutions {

    static void isPalindrome() {

        System.out.println("Enter the number:");

        int x = (new Scanner(System.in)).nextInt();

        int y = x;
        int temp = 0;

        do {
            temp = temp * 10 + y % 10;
            y /= 10;
        } while (y > 0);

        System.out.println(x == temp);

        /* решение с преобразованием типов не рекомендовано в условиях задачи
        StringBuffer xStr = new StringBuffer(Integer.toString(x));
        return xStr.equals(xStr.reverse());
        */
    }

    static void twoSum() {
        //В задаче было предложено попробовать реализовать сложность меньше чем O(n^2). Это решение выглядит как O(n), но вопрос к тому, как обрабатываются инструкции ArrayList под капотом.

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the target:");
        int target = sc.nextInt();

        System.out.println("Enter numbers separated spaces:");
        do {
            arr.add(sc.nextInt());
        } while (sc.hasNextInt());

        for (int a : arr) {
            if (arr.contains(target - a)) {
                System.out.printf("[%d, %d]%n", arr.indexOf(a), arr.indexOf(target - a));
                break;
            }
        }
    }

    static void lengthOfLastWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String str = (new Scanner(System.in)).nextLine().trim();

        System.out.println(str.substring(str.lastIndexOf(' ') + 1).length());
    }

    static void mySqrt() {
        System.out.println("Enter the number:");
        double a = (new Scanner(System.in)).nextDouble();
        double firstVal;
        double secondVal = 1;

        do {
            firstVal = secondVal;
            secondVal = .5 * (firstVal + a / firstVal);
        } while (Math.abs(firstVal - secondVal) >= .5);

        System.out.println((int) secondVal);
    }

    static void fizzBuzz() {
        System.out.println("Enter the number:");
        int a = (new Scanner(System.in)).nextInt();

        StringBuffer str = new StringBuffer("");
        if (a % 3 == 0) str.append("fizz");
        if (a % 5 == 0) str.append("buzz");
        System.out.println(str);
    }

    static void fibonacci() {
        //Решение с рекурсией
        System.out.println("Enter the number:");
        int n = (new Scanner(System.in)).nextInt();
        System.out.println(recFibonacci(0, 1, n));

        /*Решение с циклом. Собственно и задержал ДЗ потому, что сначала сделал так, а потом уже прочитал, что нужна рекурсия.
        int first = 0;
        int second = 1;

        for (int i = 0; i < n; i++) {
            second = second + first;
            first = second - first;
        }
        System.out.println(first);
        */
    }

    static void Division() {
        /*
        Было бы здорово, если бы задание было более определенным. А именно, какой результат требуется:
            - Целочисленный без остатка
            - Целочисленный с остатком
            - Вещественны с заданной точностью
        Реализован второй вариант.
        Также не помешали бы дополнительные условия - верхняя и нижняя границы входных данных, возможно что-то еще.
        Я нагло пользовался умножением и модулем, но только потому, что их нет в ограничених. В принципе, можно обойтись без них добавив проверки и
        */

        Scanner sc = new Scanner(System.in);

        int dividend, divisor;

        System.out.println("Enter the divident:");
        dividend = sc.nextInt();

        System.out.println("Enter the divisor:");
        divisor = sc.nextInt();

        if (divisor == 0) {
            System.out.println("Error. The divisor must be greater or less than 0.");
        } else {
            int quotient = 0;

            int dd = Math.abs(dividend);
            int dr = Math.abs(divisor);

            //Считаем результат для модулей
            while (dd >= Math.abs(dr * (quotient + 1))) quotient++;
            int remainder = dd - quotient * dr;

            //Допиливаем в соответствии для отрицательного значения делимого и/или делителя
            if (dividend < 0) {
                if (remainder != 0) {
                    remainder = dr - remainder;
                    quotient++;
                }
                quotient *= -1;
            }
            if (divisor < 0) {
                quotient *= -1;
            }

            System.out.printf("The quotient of dividing %d by %d is %d. The remainder is %d.%n", dividend, divisor, quotient, remainder);
        }
    }

    static private int recFibonacci(int first, int second, int n) {
        if (n > 0) first = recFibonacci(second, first + second, n - 1);
        return first;
    }
}