package main;

import main.common.Subjects;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        Subjects[] subjects = Subjects.values();
        FileWriter writer = new FileWriter("target.txt");

        String[] people = {
                "Иванов | Петя",
                "Смирнов | Андрей",
                "Сидоров | Петя",
                "Коротаева | Катя",
                "Королева | Наташа",
                "Киркоров | Филип ",
                "Галиев | Максим",
                "Ташина  | Наташа",
                "Изотов | Дмитрий",
                "Валетов | Семён",
                "Спартанцев | Леонид",
                "Румянцев | Владислав",
                "Дакотова | Ирина",
        };
        writer.write("Фамилия | Имя | Предмет | Оценка" + "\n");
        for(String name : people) {
            for(Subjects subject : subjects) {
                String trans = subject.getTranslation();
                writer.write(name + " | " + trans + " | " + generateRandomIntIntRange(1,5) + "\n")  ;
            }
        }
        writer.flush();

    }


    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
