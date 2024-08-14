package ru.practicum.dinner;

import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);


        while (true) {
            printMenu();
            String command = scanner.nextLine().trim();


            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Программа завершена. До новых встреч.");
                    return;
                default:
                    System.out.println("Некорректная команда. Введите 1, 2 или 3, а ваш ввод " + command);
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addCourse(dishType, dishName);

    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        StringBuilder allItems = new StringBuilder(); // добавление изменяемого СБ для хранения ввода пользователя
        String nextItem; // иниц внутри лупа чтобы обновлялся
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        //реализуйте ввод типов блюд
        while (!(nextItem= scanner.nextLine()).isEmpty()) {
            allItems.append(nextItem + "\n");

        }

        // Проверка перед вызовом метода
        if (!allItems.isEmpty() && numberOfCombos > 0) {
            dc.addAndPrintUsersChoice(allItems.toString(), numberOfCombos);
        } else {
            System.out.println("Ошибка: Пустой список типов блюд или неверное количество наборов.");
        }


    }

}
