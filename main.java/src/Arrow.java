import java.util.Scanner;

public class Arrow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int count = 0;

        for (int i = 0; i <= chars.length - 5; i++) {
            if ((chars[i] == '>' && chars[i+1] == '>' && chars[i+2] == '-' &&
                    chars[i+3] == '-' && chars[i+4] == '>') ||
                    (chars[i] == '<' && chars[i+1] == '-' && chars[i+2] == '-' &&
                            chars[i+3] == '<' && chars[i+4] == '<')) {
                count++;
            }
        }

        System.out.println(count);
    }
}