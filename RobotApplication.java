package com.company;

public class RobotApplication {

    public static void main(String[] args) {
        RobotConnectionManager robotConnection = null;
        moveRobot(robotConnection, 4, 5);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean check = false;
        RobotConnection robotConnection = null;
        for (int i = 1; !check && i <= 3; i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                check = true;
            } catch (RobotConnectionException ex) {
                throw new RobotConnectionException(ex.getMessage(), ex);
            } catch (RuntimeException ex) {
                System.out.println("Error.");
            } finally {
                try {
                    if (robotConnection != null) {
                        robotConnection.close();
                    }
                } catch (RobotConnectionException ex) {
                    System.out.println("Error with resources.");
                }
            }
            if (!check && i == 3) {
                throw new RobotConnectionException("Close connection.");
            }
        }
    }
}
