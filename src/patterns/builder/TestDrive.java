//        Write the full code of RobotBuilder class and to build your robot in TestDrive class,
//        and get the correct output.
//
//        Sample Input 1:
//
//        4
//        2
//        1
//        Sample Output 1:
//
//        CPU : Intel Core i5
//        Legs : 4
//        Hands : 2
//        Eyes : 1

package patterns.builder;

import java.util.Scanner;

class Robot {

    private String CPU;
    private int legs;
    private int hands;
    private int eyes;

    Robot(String CPU, int legs, int hands, int eyes) {
        this.CPU = CPU;
        this.legs = legs;
        this.hands = hands;
        this.eyes = eyes;
    }

    public static class RobotBuilder {

        private String CPU;
        private int legs;
        private int hands;
        private int eyes;

        RobotBuilder() {}

        RobotBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        RobotBuilder setLegs(int legs) {
            this.legs = legs;
            return this;
        }

        RobotBuilder setHands(int hands) {
            this.hands = hands;
            return this;
        }

        RobotBuilder setEyes(int eyes) {
            this.eyes = eyes;
            return this;
        }

        Robot build() {
            return new Robot(CPU, legs, hands, eyes);
        }
    }

    @Override
    public String toString() {
        return "CPU : " + CPU + "\n" +
                "Legs : " + legs + "\n" +
                "Hands : " + hands + "\n" +
                "Eyes : " + eyes + "\n";
    }
}

class TestDrive {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Robot.RobotBuilder robotBuilder = new Robot.RobotBuilder();
        /* Set CPU */
        robotBuilder.setCPU("Intel Core i5");

        /* Would like to set legs? */
        int legs = scanner.nextInt();
        /* Would like to set hands? */
        int hands = scanner.nextInt();
        /* Would like to set eyes? */
        int eyes = scanner.nextInt();

        robotBuilder.setLegs(legs);
        robotBuilder.setHands(hands);
        robotBuilder.setEyes(eyes);

        Robot robot = robotBuilder.build();

        System.out.println(robot);
        scanner.close();
    }
}

