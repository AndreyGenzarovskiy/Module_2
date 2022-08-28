package task3;

import task3.data.Rib;
import task3.data.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {

    private static final List<Node> graph = new ArrayList<>();
    private static final Map<String, String> distance = new HashMap<>();

    public static void readData(File fileName) {

        if (!fileName.exists()) {
            throw new IllegalArgumentException("No file with such name!");
        } else {

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

                String first = br.readLine();
                int numberOfNodes = Integer.parseInt(first);

                for (int i = 1; i < numberOfNodes + 1; i++) {
                    String name = br.readLine();
                    String next = br.readLine();
                    int numberOfAdjacentNodes = Integer.parseInt(next);
                    List<Rib> list = new ArrayList<>();

                    for (int j = 0; j < numberOfAdjacentNodes; j++) {
                        String current = br.readLine();
                        String[] values = current.split(" ");
                        int currentIndex = Integer.parseInt(values[0]);
                        int currentWeight = Integer.parseInt(values[1]);
                        list.add(new Rib(currentIndex, currentWeight));
                    }

                    Rib[] ribs = new Rib[list.size()];

                    for (int q = 0; q < ribs.length; q++) {
                        ribs[q] = list.get(q);
                    }

                    Node temporaryNode = new Node(name, i);
                    temporaryNode.setAdjacentNodes(ribs);

                    graph.add(temporaryNode);

                }

                String paths = br.readLine();
                int numberOfPaths = Integer.parseInt(paths);

                for (int x = 0; x < numberOfPaths; x++) {
                    String current = br.readLine();
                    String[] values = current.split(" ");
                    String from = values[0];
                    String to = values[1];
                    distance.put(from, to);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static List<Node> getGraph() {
        return graph;
    }

    public static Map<String, String> getDistance() {
        return distance;
    }

}
