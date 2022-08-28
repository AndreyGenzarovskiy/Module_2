package main;
import task1.DateFormatChange;
import task2.SecondTask;
import task3.Reader;
import task3.Utils;
import task3.data.Node;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

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

        File output = new File("output.txt");
        if (!output.exists()) {
            output.createNewFile();
        }
        File input = new File("input.txt");
        Reader.readData(input);
        List<Node> graph = Reader.getGraph();
        Map<String, String> distance = Reader.getDistance();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {

            for (String from : distance.keySet()) {
                Node fromNode = Utils.getNodeByName(graph, from);
                String to = distance.get(from);
                Node destNode = Utils.getNodeByName(graph, to);
                List<Node> nodeList = Utils.calculatePaths(graph, fromNode);
                bw.write(+ (int) destNode.minDistance + " " + nodeList.toString()+ "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

