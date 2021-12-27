package com.company;

public class Main {

    public static void main(String[] args) {
        String[] articles  = new String[] {"Иванов Иван Иваныч,Пе-тров Пётр Петрович,  Хмелевкий Егор, Иван И.Г. " +
                "\"Как выучить Java\" Журнал-Программирование №003 2021г. 30стр.",
                "Иванов Иван Иваныч,Пе-тров Пётр Петрович,  Хмелевкий Егор, Иван И.Г. " +
                        "'Как стать успешным' Журнал-О_бизнесе №2 1992г. 10стр.",
        "Иванов Иван Иваныч,Пе-тров Пётр Петрович,  Хмелевкий Егор, Иван И.Г. \"Java\" Журнал-Java №1 2005г. 90стр."};
        for (String item:articles) {
            System.out.println("Проверяем строку: " + item);
            System.out.println("Результат проверки: " + IsCorrect.isCorrect(item));
        }
    }
}