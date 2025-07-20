package ru.java.rtk;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TV TV1 = new TV ("LG", 19, 235);
        TV TV2 = new TV ("Samsung", 17, 220);
        TV TV3 = new TV ("ViewSonic", 19, 280);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текущий канал на телевизоре: ");
        int userChannel = scanner.nextInt();

        System.out.println("Введите громкость телевизора: ");
        int userVolume = scanner.nextInt();

        // Устанавливаем значения для одного из телевизоров
        TV1.changeChannel(userChannel);
        TV1.changeVolume(userVolume);

        System.out.println ("Первый телевизор " + TV1.getModel() + " с диагональю " + TV1.getDiagonal() + " дюймов и стоимостью " + TV1.getCost() + " руб.");
        System.out.println ("Второй телевизор " + TV2.getModel() + " с диагональю " + TV2.getDiagonal() + " дюймов и стоимостью " + TV2.getCost() + " руб.");
        System.out.println ("Третий телевизор " + TV3.getModel() + " с диагональю " + TV3.getDiagonal() + " дюймов и стоимостью " + TV3.getCost() + " руб.");

        System.out.println("На первом телевизоре сейчас включен канал: " + TV1.getChannel() + ", текущая громкость телевизора: " + TV1.getVolume());
    }
}