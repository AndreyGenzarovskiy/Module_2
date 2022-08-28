package task3;

import task3.data.Rib;
import task3.data.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Utils {

    public static List<Node> calculatePaths(List<Node> graph, Node source) {
        source.minDistance = 0.;
        PriorityQueue<Node> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(source);

        while (!vertexQueue.isEmpty()) {
            Node node = vertexQueue.poll();

            for (Rib e : node.adjacentNodes) {
                int index = e.dest;
                Node currNode = getNodeByIndex(graph, index);
                double weight = e.weight;
                double distanceThroughU = node.minDistance + weight;
                if (distanceThroughU < currNode.minDistance) {
                    vertexQueue.remove(currNode);
                    nodeList.remove(currNode);

                    currNode.minDistance = distanceThroughU;
                    currNode.previous = node;
                    vertexQueue.add(currNode);
                    nodeList.add(currNode);
                }
            }
        }
        return nodeList;
    }


    public static Node getNodeByIndex(List<Node> graph, int index) {
        Node result = null;
        for (Node node : graph) {
            if (node.index == index) {
                result = node;
            }
        }

        if (result == null) {
            throw new IllegalArgumentException("There is no node with such index.");
        }

        return result;
    }

    public static Node getNodeByName(List<Node> graph, String name) {
        Node result = null;
        for (Node node : graph) {
            if (node.name.equals(name)) {
                result = node;
            }
        }

        if (result == null) {
            throw new IllegalArgumentException("There is no node with such index.");
        }

        return result;
    }

}