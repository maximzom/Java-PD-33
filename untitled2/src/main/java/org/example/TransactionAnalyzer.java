//

package org.example;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer
{
    public static double calculateTotalBalance(List<Transaction> transactions)
    {
        double balance = 0;
        for (Transaction transaction : transactions)
        {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public static int countTransactionsByMonth(List<Transaction> transactions, String monthYear)
    {
        int count = 0;
        for (Transaction transaction : transactions)
        {
            LocalDate date = LocalDate.parse(transaction.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear))
            {
                count++;
            }
        }
        return count;
    }

    public static List<Transaction> findTopExpenses(List<Transaction> transactions)
    {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0) // Вибірка лише витрат (від'ємні значення)
                .sorted(Comparator.comparing(Transaction::getAmount)) // Сортування за сумою
                .limit(10) // Обмеження результату першими 10 записами
                .collect(Collectors.toList()); // Збір результату в список
    }



}
