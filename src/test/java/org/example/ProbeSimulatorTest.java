package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProbeSimulatorTest {
    @Test
    void shouldMoveForwardWhenFacingNorth() {
// grid 5x5, no obstacles
        ProbeSimulator.Grid grid = new ProbeSimulator.Grid(5, 5, Set.of());
        ProbeSimulator.Position start = new ProbeSimulator.Position(1, 1, ProbeSimulator.Direction.NORTH);
        List<Character> cmds = List.of('F');


        List<String> result = ProbeSimulator.simulate(grid, start, cmds);


        assertTrue(result.contains("Final:1,2,NORTH"), "Expected final position to be (1,2) facing NORTH");
    }
}
