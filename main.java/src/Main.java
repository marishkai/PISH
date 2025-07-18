import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);           // создаём Scanner
        System.out.print("Введите ваше имя: ");             // просим ввести имя
        String name = scanner.nextLine();                   // читаем строку
        System.out.println("Привет, " + name);              // выводим приветствие
        scanner.close();
    }
}