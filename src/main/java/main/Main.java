package main;

import task1.DateFormatChange;
import task2.SecondTask;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        String strDate = new Scanner(System.in).nextLine();
        List<String> patterns = Arrays.asList("[0-9]{2}/[0-9]{2}/[0-9]{4}",
                "[0-9]{4}/[0-9]{2}/[0-9]{2}",
                "[0-9]{2}-[0-9]{2}-[0-9]{4}");
        LocalDate date = DateFormatChange.invertDate(patterns, strDate);
        if (date == null) {
            return;
        } else {
            System.out.println(DateFormatChange.formatLocalDate(date));
        }

        List<String> cities = Arrays.asList("Kiev", "Kharkov", "Odessa", "Kharkov", "Kiev");
        System.out.println(SecondTask.getFirstUniqueStringInList(cities));


    }

}

