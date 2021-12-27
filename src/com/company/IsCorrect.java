package com.company;

/*(-)выходные данные статьи
* автор1,автор2,...|название|журнал|номер|год|страницы
* */

// авторы: [А-ЯЁ][а-яё\-]+\s+(([А-ЯЁ][а-яё]+(?:\s+[А-ЯЁ][а-яё]+)?)|[А-ЯЁ]\.[А-ЯЁ]\.)
// название: ([\"][^\"]{3,}\"|['][^']{3,}\')
// журнал: (?<=Журнал-).[^\s№]{3,}
// номер: [№]\d{0,}[^\s]
// год: \d{4}[г]\.
// страницы: \d{2,3}стр\.

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class IsCorrect {
    private static String string;

    // главная фу-ия проверки
    public static boolean isCorrect(String str) {
        string = str;

        // Проверяем количество авторов. Если >=1, то true
        ArrayList authors = getBlock("[А-ЯЁ][а-яё\\-]+\\s+(([А-ЯЁ][а-яё]+(?:\\s+[А-ЯЁ][а-яё]+)?)|[А-ЯЁ]\\.[А-ЯЁ]\\.)");
        System.out.println("Authors:\n" + authors);
        // Проверяем наличие названия. Если ==1, то true
        ArrayList title = getBlock("([\"][^\"]{3,}\"|['][^']{3,}')");
        System.out.println("\nTitle:\n" + title);
        // Проверяем наличие журнала. Если ==1, то true
        ArrayList journal = getBlock("(?<=Журнал-).[^\\s№]{3,}");
        System.out.println("\nJournal:\n" + journal);
        // Проверяем наличие номера. Если ==1, то true
        ArrayList number = getBlock("[№]\\d{0,}[^\\s]");
        System.out.println("\nNumber:\n" + number);
        // Проверяем соответствие диапазону годов и что год есть и до этих четырёх цифр пробел
        ArrayList year = getBlock("\\d{4}[г]\\.");
        System.out.println("\nYear:\n" + year);
        // Проверяем количество страниц, не должно быть одних нулей
        ArrayList pages = getBlock("\\d{2,3}стр\\.");
        System.out.println("\nPages:\n" + pages);

        Integer intYear;
        if (year.size() > 0)
        {
            intYear = new Integer(year.get(0).toString().substring(0, year.get(0).toString().length() - 2));
        } else return false;

        Integer intPages;
        if (pages.size() > 0) {
            intPages = new Integer(pages.get(0).toString().substring(0, pages.get(0).toString().length() - 4));
        } else return false;
        /*System.out.println(intPages);*/

        return authors.size() >= 1 && title.size() == 1 && journal.size() == 1 &&
                number.size() == 1 && (year.size() == 1 && intYear >= 1980 &&
                intYear <= 2021) && intPages > 0;
    }

    private static ArrayList getBlock(String pat) {
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(string);

        ArrayList result = new ArrayList();
        while (matcher.find()) {
            result.add(string.substring(matcher.start(), matcher.end()));
            /*System.out.println(string.substring(matcher.start(), matcher.end()));*/
//            System.out.println(matcher.start()+ ": " + matcher.group());
        }
        return result;
    }

}
