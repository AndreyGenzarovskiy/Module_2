package task3.data;

public class Node implements Comparable<Node> {

    public final String name;
    public final int index;
    public Rib[] adjacentNodes;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Node previous;

    public Node(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String toString() {
        return name;
    }

    public void setAdjacentNodes(Rib[] adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public int compareTo(Node other) {
        return Double.compare(minDistance, other.minDistance);
    }

}
