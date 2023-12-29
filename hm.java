/*
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
Работу сдать как обычно ссылкой на гит репозиторий
Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
 */

import java.util.HashSet;
import java.util.Scanner;

public class hm {
    public static void main(String[] args) {
        HashSet<Notebook> asortment = new HashSet<>();

        Notebook notebook1 = new Notebook();
        notebook1.RAM = 4;
        notebook1.HDD = 32;
        notebook1.OS = "Linux";
        notebook1.color = "Чёрный";
        notebook1.producer = "Asus";
        notebook1.price = 40000;
        asortment.add(notebook1);

        Notebook notebook2 = new Notebook();
        notebook2.RAM = 4;
        notebook2.HDD = 16;
        notebook2.OS = "Linux";
        notebook2.color = "Белый";
        notebook2.producer = "Apple";
        notebook2.price = 60000;
        asortment.add(notebook2);

        Notebook notebook3 = new Notebook();
        notebook3.RAM = 12;
        notebook3.HDD = 16;
        notebook3.OS = "Windows";
        notebook3.color = "Чёрный";
        notebook3.producer = "Asus";
        notebook3.price = 30000;
        asortment.add(notebook3);

        Notebook notebook4 = new Notebook();
        notebook4.RAM = 12;
        notebook4.HDD = 18;
        notebook4.OS = "IOS";
        notebook4.color = "Желтый";
        notebook4.producer = "MSI";
        notebook4.price = 40000;
        asortment.add(notebook4);

        Notebook notebook5 = new Notebook();
        notebook5.RAM = 7;
        notebook5.HDD = 28;
        notebook5.OS = "Windows";
        notebook5.color = "Чёрный";
        notebook5.producer = "Samsung";
        notebook5.price = 80000;
        asortment.add(notebook5);

        search(asortment);

    }

    public static void search(HashSet<Notebook> asortment) {
        HashSet<Notebook> result = new HashSet<>();
        Notebook SearchNote = new Notebook();
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "По какой харастеристике хотите искать ноутбук? \n 1.ОЗУ \n 2.Объем ЖД \n 3.Операционная система \n 4.Цвет \n 5.Производитель \n 6.Цена");
        System.out.println("Введите номер критерия");
        int answer = sc.nextInt();
        SearchNote = WriteResult(answer, SearchNote);
        for (Notebook notebook : asortment) {
            if (notebook.RAM >= SearchNote.RAM && SearchNote.RAM != 0) {
                result.add(notebook);
            } 
            if (notebook.HDD >= SearchNote.HDD && SearchNote.HDD != 0) {
                result.add(notebook);                
            } 
            if (notebook.OS.equals(SearchNote.OS) && SearchNote.OS.equals(null)) {
                result.add(notebook);                
            } 
            if (notebook.color.equals(SearchNote.color) && SearchNote.color.equals(null)) {
                result.add(notebook);                
            } 
            if (notebook.producer.equals(SearchNote.producer) && SearchNote.producer.equals(null)) {
                result.add(notebook);                
            } 
            if (notebook.price <= SearchNote.price && SearchNote.price != 0) {
                result.add(notebook);                
            } 
        }
        for (Notebook notebook : result) {
            System.out.println(result);
        }
    }

    public static Notebook WriteResult(int answer, Notebook ask) {
        Scanner sc = new Scanner(System.in);
        if (answer == 1) {
            System.out.println("Введите минимальные требуемые значения");
            ask.RAM = sc.nextInt();
        } else if (answer == 2) {
            System.out.println("Введите минимальные требуемые значения");
            ask.HDD = sc.nextInt();
        } else if (answer == 3) {
            System.out.println("Введите требуемую операционную систему");
            ask.OS = sc.nextLine();
        } else if (answer == 4) {
            System.out.println("Введите цвет");
            ask.color = sc.nextLine();
        } else if (answer == 5) {
            System.out.println("Введите производителя");
            ask.producer = sc.nextLine();
        } else if (answer == 6) {
            System.out.println("Введите сколько вы готовы потратить");
            ask.price = sc.nextInt();
        }  else {
            System.out.println("Такого критерия нет");
            return ask;
        }
        System.out.println("Хотите выбрать ещё критерий? Введите 1 - если да и что угодно - если нет");
        int ans = sc.nextInt();
        if (ans == 1) {
            System.out.println("Введите номер нового критерия");
            answer = sc.nextInt();
            return WriteResult(answer, ask);
        }
        return ask;
    }

}
