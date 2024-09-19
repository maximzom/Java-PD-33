package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";

        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);
        TransactionReportGenerator.printTopExpensesReport(topExpenses);

        double totalBalance = TransactionAnalyzer.calculateTotalBalance(transactions);
        TransactionReportGenerator.printBalanceReport(totalBalance);

        System.out.println("Загальний баланс: " + totalBalance);

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

        String monthYear = "01-2024";
        int transactionsCount = TransactionAnalyzer.countTransactionsByMonth(transactions, monthYear);
        System.out.println("Кількість транзакцій за " + monthYear + ": " + transactionsCount);
        TransactionReportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        TransactionReportGenerator.printCategoryExpenseReport(transactions);
        TransactionReportGenerator.printMonthlyExpenseReport(transactions);
    }
}
