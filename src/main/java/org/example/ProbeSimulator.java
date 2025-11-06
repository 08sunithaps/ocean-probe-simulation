package org.example;

import java.util.ArrayList;
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
        List<String> visited = new ArrayList<>();
        int x = start.x;
        int y = start.y;
        Direction dir = start.direction;
        visited.add(x + "," + y);

        for (char c : commands) {
            if (c == 'L') {
                dir = turnLeft(dir);
            } else if (c == 'R') {
                dir = turnRight(dir);
            } else if (c == 'F' || c == 'B') {
                int step = (c == 'F') ? 1 : -1;
                int nx = x, ny = y;
                switch (dir) {
                    case NORTH -> ny += step;
                    case SOUTH -> ny -= step;
                    case EAST -> nx += step;
                    case WEST -> nx -= step;
                }
                String coord = nx + "," + ny;
                boolean inside = nx >= 0 && ny >= 0 && nx < grid.width && ny < grid.height;
                boolean blocked = grid.obstacles.contains(coord);
                if (inside && !blocked) {
                    x = nx; y = ny;
                }
            } else {
                throw new IllegalArgumentException("Invalid command: " + c);
            }
            visited.add(x + "," + y);
        }
        visited.add("Final:" + x + "," + y + "," + dir);
        return visited;
    }

    public static Direction turnLeft(Direction d) {
        return switch (d) {
            case NORTH -> Direction.WEST;
            case WEST -> Direction.SOUTH;
            case SOUTH -> Direction.EAST;
            case EAST -> Direction.NORTH;
        };
    }


    public static Direction turnRight(Direction d) {
        return switch (d) {
            case NORTH -> Direction.EAST;
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
        };
    }
}