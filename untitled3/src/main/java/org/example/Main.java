package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            try {
                System.out.print("Введіть перше число: ");
                double num1 = scanner.nextDouble();

                System.out.print("Введіть друге число: ");
                double num2 = scanner.nextDouble();

                System.out.print("Введіть операцію (+, -, *, /): ");
                String operation = scanner.next();

                double result = 0;
                switch (operation) {
                    case "+":
                        result = calculator.add(num1, num2);
                        break;
                    case "-":
                        result = calculator.subtract(num1, num2);
                        break;
                    case "*":
                        result = calculator.multiply(num1, num2);
                        break;
                    case "/":
                        result = calculator.divide(num1, num2);
                        break;
                    default:
                        throw new InvalidInputException("Неправильна операція.");
                }

                System.out.println("Відповідь: " + result);

            }

            catch (ArithmeticException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

            catch (InvalidInputException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

            catch (Exception e) {
                System.out.println("Неправильний ввід. Будь ласка, введіть правильні цифри.");
            }

            finally {
                System.out.println("Розрахунок завершено.\n");
            }

            System.out.print("Ви хочете виконати ще один розрахунок? (Так/Ні): ");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("Так")) {
                continueCalculation = false;
            }
        }

        scanner.close();
        System.out.println("Програму завершено.");
    }
}
