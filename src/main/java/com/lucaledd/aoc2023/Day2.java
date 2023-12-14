package com.lucaledd.aoc2023;

public class Day2 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        // The Elf would first like to know which games would have been possible if
        // the bag contained only 12 red cubes, 13 green cubes, and 14 blue cubes?

        int sumIds = 0;
        for (String line : Utils.readFile("input.txt")) {
            final int gameId = Integer.parseInt(
                line.split(":")[0].trim().split(" ")[1]
            );
            final String bagInfo = line.split(":")[1].trim();
            final String[] cubeSets = bagInfo.split(";");

            boolean possible = true;

            for (String set : cubeSets) {
                set = set.trim();
                final String[] cubeInfo = set.split(",");

                for (String cubes : cubeInfo) {
                    cubes = cubes.trim();
                    final String cubeType = cubes.split(" ")[1];
                    final int cubeAmount = Integer.parseInt(cubes.split(" ")[0]);

                    possible = checkIfMax(cubeType, cubeAmount);
                    if(!possible) break;
                }

                if(!possible) break;
            }

            if(possible) sumIds += gameId;
        }

        System.out.println("Sum of possible games' ids = " + sumIds);
    }

    private static boolean checkIfMax(String cubeType, int cubeAmount) {
        final int MAX_RED = 12, MAX_GREEN = 13, MAX_BLUE = 14;
        switch (cubeType.toLowerCase()) {
            case "red" -> {
                if (cubeAmount > MAX_RED) {
                    return false;
                }
            }
            case "blue" -> {
                if (cubeAmount > MAX_BLUE) {
                    return false;
                }
            }
            case "green" -> {
                if (cubeAmount > MAX_GREEN) {
                    return false;
                }
            }
            default -> {
                return false;
            }
        }

        return true;
    }

    private static void part2() {
        // For each game, find the minimum set of cubes that must have been present.
        // What is the sum of the power of these sets?

        int sumPowers = 0;
        for (String line : Utils.readFile("input.txt")) {
            final int gameId = Integer.parseInt(
                    line.split(":")[0].trim().split(" ")[1]
            );
            final String bagInfo = line.split(":")[1].trim();
            final String[] cubeSets = bagInfo.split(";");

            int MIN_RED = 0, MIN_BLUE = 0, MIN_GREEN = 0;

            for (String set : cubeSets) {
                set = set.trim();
                final String[] cubeInfo = set.split(",");

                for (String cubes : cubeInfo) {
                    cubes = cubes.trim();
                    final String cubeType = cubes.split(" ")[1];
                    final int cubeAmount = Integer.parseInt(cubes.split(" ")[0]);

                    switch (cubeType) {
                        case "red" -> {
                            if(cubeAmount > MIN_RED) {
                                MIN_RED = cubeAmount;
                            }
                        }
                        case "blue" -> {
                            if(cubeAmount > MIN_BLUE) {
                                MIN_BLUE = cubeAmount;
                            }
                        }
                        case "green" -> {
                            if(cubeAmount > MIN_GREEN) {
                                MIN_GREEN = cubeAmount;
                            }
                        }
                    }
                }
            }
            sumPowers += MIN_RED * MIN_BLUE * MIN_GREEN;
        }

        System.out.println("Sum of powers = " + sumPowers);
    }
}
