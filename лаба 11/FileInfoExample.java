import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileInfoExample {
    public static void main(String[] args) {
        try {
            File file = new File("info.txt");
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            writer.write("Имя: Ярослав\n");
            writer.write("Роль: Активный студент и разработчик учебных проектов\n");
            writer.write("Навыки: Java, HTML/CSS, jQuery, Git, PowerShell\n");
            writer.close();

            System.out.println("Имя файла: " + file.getName());
            System.out.println("Абсолютный путь: " + file.getAbsolutePath());
            System.out.println("Размер: " + file.length() + " байт");
            System.out.println("Можно читать: " + file.canRead());
            System.out.println("Можно записывать: " + file.canWrite());

            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
