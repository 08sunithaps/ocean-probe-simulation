package org.example;

import java.util.List;
import java.util.Set;

public class ProbeApplication {
    public static void main(String[] args) {
        // Define grid (5x5) with one obstacle
        ProbeSimulator.Grid grid = new ProbeSimulator.Grid(5, 5, Set.of("2,2"));

        // Starting position: (1,1) facing NORTH
        ProbeSimulator.Position start = new ProbeSimulator.Position(1, 1, ProbeSimulator.Direction.NORTH);

        // Define command sequence
        List<Character> commands = List.of('F', 'R', 'F', 'L', 'B', 'F');

        // Run simulation
        List<String> path = ProbeSimulator.simulate(grid, start, commands);

        // Print summary
        System.out.println("=== Probe Path Summary ===");
        for (String step : path) {
            System.out.println(step);
        }
    }
}