package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TransactionReportGenerator {

    public static void printBalanceReport(double totalBalance)
    {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public static void printTransactionsCountByMonth(String monthYear, int count)
    {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public static void printTopExpensesReport(List<Transaction> topExpenses)
    {
        System.out.println("10 найбільших витрат:");
        for (Transaction expense : topExpenses)
        {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public static void printCategoryExpenseReport(List<Transaction> transactions)
    {
        System.out.println("Сумарні витрати по категоріях:");
        transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(Transaction::getDescription, Collectors.summingDouble(Transaction::getAmount)))
                .forEach((category, total) -> {
                    int stars = (int) Math.abs(total / 1000);
                    System.out.print(category + ": " + total + " грн ");
                    for (int i = 0; i < stars; i++) {
                        System.out.print("*");
                    }
                    System.out.println();
                });
    }

    public static void printMonthlyExpenseReport(List<Transaction> transactions)
    {
        System.out.println("Сумарні витрати по місяцях:");
        transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    return date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
                }, Collectors.summingDouble(Transaction::getAmount)))
                .forEach((month, total) -> {
                    int stars = (int) Math.abs(total / 1000);
                    System.out.print(month + ": " + total + " грн ");
                    for (int i = 0; i < stars; i++) {
                        System.out.print("*");
                    }
                    System.out.println();
                });
    }
}
