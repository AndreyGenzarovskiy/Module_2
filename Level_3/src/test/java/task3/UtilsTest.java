package task3;

import org.junit.jupiter.api.Test;
import task3.data.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void calculatePaths() {
        Reader.readData(new File("C:/srcAll/Java/Module_2/Level_3/src/test/resources/input.txt"));
        List<Node> graph = Reader.getGraph();
        String from = "gdansk";
        Node fromNode = Utils.getNodeByName(graph, from);
        Node node = new Node("gdansk", 1);
        Node node2 = new Node("bydgoszcz", 2);
        Node node3 = new Node("torun", 3);
        Node node4 = new Node("warszawa", 4);
        List<Node> expected = new ArrayList<>();
        expected.add(node);
        expected.add(node2);
        expected.add(node3);
        expected.add(node4);
        List<Node> actual = Utils.calculatePaths(graph, fromNode);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void getNodeByIndex() {
        Reader.readData(new File("C:/srcAll/Java/Module_2/Level_3/src/test/resources/input.txt"));
        List<Node> graph = Reader.getGraph();
        int city = 4;
        Node expected = new Node("warszawa", 4);
        Node actual = Utils.getNodeByIndex(graph, city);
        assertEquals(expected.name, actual.name);
    }

    @Test
    void getNodeByName() {
        Reader.readData(new File("C:/srcAll/Java/Module_2/Level_3/src/test/resources/input.txt"));
        List<Node> graph = Reader.getGraph();
        String city = "warszawa";
        Node expected = new Node("warszawa", 4);
        Node actual = Utils.getNodeByName(graph, city);
        assertEquals(expected.name, actual.name);
    }
}