package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProbeSimulator {
    public enum Direction {NORTH, EAST, SOUTH, WEST}


    public static class Position {
        public int x, y;
        public Direction direction;


        public Position(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static class Grid {
        public int width, height; public Set<String> obstacles;
        public Grid(int width, int height, Set<String> obstacles) {
            this.width = width; this.height = height;
            this.obstacles = obstacles != null ? obstacles : new HashSet<>();
        }
    }

    // implementation: only handle single 'F' when facing NORTH
    public static List<String> simulate(Grid grid, Position start, List<Character> commands) {
        int x = start.x;
        int y = start.y;
        Direction dir = start.direction;


        for (char c : commands) {
            if (c == 'F' && dir == Direction.NORTH) {
                y = y + 1; // move north
            }
        }


        return List.of("Final:" + x + "," + y + "," + dir);
    }
}