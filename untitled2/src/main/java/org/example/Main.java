// 'countTransactionsByMonth(java.util.List<org.example.Transaction>, java.lang.String)' in 'org.example.TransactionAnalyzer' cannot be applied to '(java.lang.String)'
// Static и Abstract не убирать.

package org.example;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Main
{
    public static void main(String[] args)
    {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);

        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);

        System.out.println("Загальний баланс: " + totalBalance);

        for (Transaction transaction : transactions)
        {
            System.out.println(transaction);
        }

        String monthYear = "01-2024";
        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(transactions, monthYear);
        System.out.println("Кількість транзакцій за " + monthYear + ": " + transactionsCount);
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

    }
}
