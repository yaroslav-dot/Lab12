import java.io.*;
import java.util.*;

public class Temperature {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            input.useLocale(Locale.US);
            File file = new File("temperature.txt");
            FileWriter writer = new FileWriter(file);

            for (int i = 0; i < 5; i++) {
                double temp = input.nextDouble();
                writer.write(temp + "\n");
            }
            writer.close();
            input.close();

            Scanner reader = new Scanner(file);
            reader.useLocale(Locale.US);
            double sum = 0;
            int count = 0;
            while (reader.hasNextDouble()) {
                sum += reader.nextDouble();
                count++;
            }
            reader.close();

            if (count > 0) {
                double average = sum / count;
                System.out.println("Средняя температура: " + average);
            } else {
                System.out.println("Файл пуст или содержит некорректные данные.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
