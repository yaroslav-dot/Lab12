import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "numbers.txt";
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US); // ввод дробных чисел через точку
        List<Double> numbers = new ArrayList<>();

        try {
            System.out.print("Сколько чисел вы хотите ввести: ");
            int count = input.nextInt();

            FileWriter writer = new FileWriter(fileName);
            System.out.println("Введите " + count + " чисел (можно отрицательные и дробные):");

            for (int i = 0; i < count; i++) {
                try {
                    double num = input.nextDouble(); // если не число → ошибка
                    writer.write(num + "\n");
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введено не число!");
                    return; // завершаем программу
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
            return;
        }

        try (Scanner reader = new Scanner(new File(fileName))) {
            reader.useLocale(Locale.US);
            while (reader.hasNextDouble()) {
                numbers.add(reader.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + fileName);
            return;
        }

        if (numbers.isEmpty()) {
            System.out.println("Файл пуст или данные некорректны. Деление на ноль невозможно.");
        } else {
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            double average = sum / numbers.size();
            System.out.println("Среднее значение: " + average);
        }
    }
}
