package task3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import task3.data.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    void testReadData() {
        Reader.readData(new File("C:/srcAll/Java/Module_2/Level_3/src/test/resources/input.txt"));
        List<Node> node = Reader.getGraph();
        assertNotNull(node);
    }

    @Test
    void getGraph() {
    }

    @Test
    void getDistance() {
    }
}