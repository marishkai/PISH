ел import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        // Ввод покупателей (разделение через точку с запятой)
        System.out.println("Введите покупателей в формате: Имя = Сумма (разделяйте покупателей точкой с запятой)");
        String[] peopleInput = scanner.nextLine().split("\\s*;\\s*");
        for (String personData : peopleInput) {
            try {
                String[] parts = personData.split("\\s*=\\s*");
                if (parts.length != 2) {
                    System.out.println("Используйте формат: Имя = Сумма");
                    return;
                }
                String name = parts[0].trim();
                int money = Integer.parseInt(parts[1].trim());
                people.add(new Person(name, money));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            } catch (Exception e) {
                System.out.println("Ошибка при обработке покупателей");
                return;
            }
        }

        // Ввод продуктов (разделение через точку с запятой)
        System.out.println("Введите продукты в формате: Название = Цена (разделяйте продукты точкой с запятой)");
        String[] productsInput = scanner.nextLine().split("\\s*;\\s*");
        for (String productData : productsInput) {
            try {
                String[] parts = productData.split("\\s*=\\s*");
                if (parts.length != 2) {
                    System.out.println("Ошибка формата: используйте Название = Цена");
                    return;
                }
                String name = parts[0].trim();
                int price = Integer.parseInt(parts[1].trim());
                products.add(new Product(name, price));
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
                return;
            } catch (Exception e) {
                System.out.println("Ошибка при обработке продуктов");
                return;
            }
        }

        // Обработка покупок
        System.out.println("Введите покупки в формате: Имя - Продукт (можно с пробелами вокруг дефиса)");
        System.out.println("Когда закончите, введите END");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) {
                break;
            }


            String[] parts = input.split("\\s*-\\s*", 2);
            if (parts.length != 2) {
                System.out.println("Неверный формат ввода. Используйте: Имя - Продукт");
                continue;
            }

            String personName = parts[0].trim();
            String productName = parts[1].trim();

            Person person = findPerson(people, personName);
            Product product = findProduct(products, productName);

            if (person == null || product == null) {
                System.out.println("Покупатель '" + personName + "' или продукт '" + productName + "' не найдены");
                continue;
            }

            person.buyProduct(product);
        }

        // Вывод результатов
        System.out.println("\nРезультаты:");
        for (Person person : people) {
            System.out.println(person);
        }

        scanner.close();
    }

    private static Person findPerson(List<Person> people, String name) {
        return people.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private static Product findProduct(List<Product> products, String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}