import org.example.Transaction;
import org.example.TransactionAnalyzer;
import org.example.TransactionCSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class TransactionTopExpensesTest {
    @Test
    public void testFindTopExpenses() {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        Assertions.assertNotNull(transactions, "Список транзакцій не повинен бути null");
        Assertions.assertFalse(transactions.isEmpty(), "Список транзакцій не повинен бути порожнім");

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);

        Assertions.assertNotNull(topExpenses, "Список найбільших витрат не повинен бути null");
        Assertions.assertFalse(topExpenses.isEmpty(), "Список найбільших витрат не повинен бути порожнім");
        Assertions.assertTrue(topExpenses.size() <= 10, "Список найбільших витрат повинен містити не більше 10 елементів");

        Transaction firstExpense = topExpenses.get(0);
        Assertions.assertNotNull(firstExpense.getDate(), "Дата транзакції не повинна бути null");
        Assertions.assertNotNull(firstExpense.getDescription(), "Опис транзакції не повинен бути null");

        System.out.println("Топ 10 найбільших витрат:");
        for (Transaction expense : topExpenses)
        {
            System.out.println(expense);
        }
    }
}
