package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdvancedBehaviorTest {
    @Test
    void shouldMoveBackwardWhenFacingSouth() {
        ProbeSimulator.Grid grid = new ProbeSimulator.Grid(5,5, Set.of());
        ProbeSimulator.Position start = new ProbeSimulator.Position(2,2, ProbeSimulator.Direction.SOUTH);
        List<String> r = ProbeSimulator.simulate(grid, start, List.of('B'));
        assertTrue(r.contains("Final:2,3,SOUTH"));
    }


    @Test
    void shouldNotExitGrid() {
        ProbeSimulator.Grid grid = new ProbeSimulator.Grid(3,3, Set.of());
        ProbeSimulator.Position start = new ProbeSimulator.Position(0,0, ProbeSimulator.Direction.SOUTH);
        List<String> r = ProbeSimulator.simulate(grid, start, List.of('F'));
// moving south from y=0 is out of grid, so should stay
        assertTrue(r.contains("Final:0,0,SOUTH"));
    }


    @Test
    void shouldAvoidObstacle() {
        ProbeSimulator.Grid grid = new ProbeSimulator.Grid(5,5, Set.of("1,3"));
        ProbeSimulator.Position start = new ProbeSimulator.Position(1,2, ProbeSimulator.Direction.NORTH);
        List<String> r = ProbeSimulator.simulate(grid, start, List.of('F'));
// (1,3) is obstacle, so should remain at (1,2)
        assertTrue(r.contains("Final:1,2,NORTH"));
    }

}
