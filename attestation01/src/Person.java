import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {private String name;
    private int money;
    private List<Product> bag;

    public Person(String name, int money) {
        setName(name);
        setMoney(money);
        this.bag = new ArrayList<>();
    }

    // Геттеры и сеттеры с валидацией
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.money = money;
    }

    public List<Product> getBag() {
        return bag;
    }

    // Логика покупки
    public boolean canAfford(Product product) {
        return money >= product.getPrice();
    }

    public void buyProduct(Product product) {
        if (canAfford(product)) {
            bag.add(product);
            money -= product.getPrice();
            System.out.println(name + " купил(а) " + product.getName());
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());
        }
    }

    // Переопределенные методы
    @Override
    public String toString() {
        if (bag.isEmpty()) {
            return name + " - Ничего не куплено";
        }
        return name + " - " + String.join(", ", bag.stream().map(Product::toString).toArray(String[]::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return money == person.money &&
                Objects.equals(name, person.name) &&
                Objects.equals(bag, person.bag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, bag);
    }
}