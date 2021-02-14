package week15d01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    public void testMaxValueEntry() {
        Graph graph = new Graph();
        Map<Double, Double> testGraph = new HashMap<>();
        testGraph.put(-2.0, 7.0);
        testGraph.put(-1.0, 2.0);
        testGraph.put(0.0, -4.0);
        testGraph.put(1.0, 9.0);
        testGraph.put(2.0, 3.0);


        Map.Entry<Double, Double> result = graph.maxValueEntry(testGraph);
        assertEquals(1.0, result.getKey());
        assertEquals(9.0, result.getValue());
    }

}