import java.util.Scanner;

public class Arrow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите последовательность: ");
        String input = scanner.nextLine();  // Ждёт ввода пользователя

        String arrow1 = ">>-->";
        String arrow2 = "<--<<";
        int count = 0;

        for (int i = 0; i <= input.length() - 5; i++) {
            String sub = input.substring(i, i + 5);
            if (sub.equals(arrow1) || sub.equals(arrow2)) {
                count++;
            }
        }

        System.out.println("Найдено стрелок: " + count);
    }
}