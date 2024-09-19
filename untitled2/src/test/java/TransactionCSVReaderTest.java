import org.example.Transaction;
import org.example.TransactionCSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TransactionCSVReaderTest {
    @Test
    public void testReadTransactions() {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        Assertions.assertNotNull(transactions, "Список транзакцій не повинен бути null");
        Assertions.assertFalse(transactions.isEmpty(), "Список транзакцій не повинен бути порожнім");

        Transaction firstTransaction = transactions.get(0);
        System.out.println("Перша транзакція: " + firstTransaction);

        Transaction secondTransaction = transactions.get(1);
        System.out.println("Перша транзакція: " + secondTransaction);

        Assertions.assertNotNull(firstTransaction.getDate(), "Дата першої транзакції не повинна бути null");
        Assertions.assertNotNull(firstTransaction.getAmount(), "Сума першої транзакції не повинна бути null");
        Assertions.assertNotNull(firstTransaction.getDescription(), "Опис першої транзакції не повинен бути null");

        Assertions.assertNotNull(secondTransaction.getDate(), "Дата першої транзакції не повинна бути null");
        Assertions.assertNotNull(secondTransaction.getAmount(), "Сума першої транзакції не повинна бути null");
        Assertions.assertNotNull(secondTransaction.getDescription(), "Опис першої транзакції не повинен бути null");
    }
}
