package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> lunchMenu;
    Random random;

    public DinnerConstructor() {
        lunchMenu = new HashMap<>();
        random = new Random();
    }

    public void addCourse(String course, String courseDish) {// метод который принимает список
        // с типом и блюдом
        // вопрос - лучше в каждом поле видимости объявить список lunchMenu.get(course)?
        if (lunchMenu.get(course) != null && lunchMenu.get(course).contains(courseDish)) { // если есть
            System.out.println("В категории '" + course + "' уже есть блюдо '" + courseDish + "'.");
        } else if (lunchMenu.get(course) != null && !(lunchMenu.get(course).contains(courseDish))) { // course+ dish-
            ArrayList<String> courseDishes = lunchMenu.get(course);
            courseDishes.add(courseDish);
        } else { // добавление типа
            ArrayList<String> courseDishes = new ArrayList<>();
            courseDishes.add(courseDish);
            lunchMenu.put(course, courseDishes);
        }
    }


    public void addAndPrintUsersChoice(String choice, int numberOfCombos) {
        String[] usersCourseInput = choice.split("\n");

        for (int j = 0; j < numberOfCombos; j++) { // повтор для кол-ва комбо
            ArrayList<String> randomOfferToArray = new ArrayList<>();
            for (String course : usersCourseInput) {
                if (lunchMenu.get(course) != null) {
                    int randomIndex = random.nextInt(lunchMenu.get(course).size());
                    String randomOffer = lunchMenu.get(course).get(randomIndex);
                    randomOfferToArray.add(randomOffer);
                } else {
                    System.out.println("Такого типа блюда нет. Вы можете добавить его, выбрав в меню 1, либо ввести другой тип.");
                    return;
                }
            }
            System.out.println("Комбо " + (j + 1) + ": " + randomOfferToArray);
        }
    }
}