import models.*;
import commands.*;
import obstacles.*;
import utils.*;
import exceptions.*;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = new Logger();
        boolean obstacleDetected = false;  // Flag to track obstacle detection
        boolean outOfBounds = false;       // Flag to track out-of-bounds detection

        try {
            // Input Grid Size
            System.out.println("Enter Grid Size (e.g., 10 10):");
            int gridWidth = scanner.nextInt();
            int gridHeight = scanner.nextInt();
            Grid grid = new Grid(gridWidth, gridHeight);

            // Input Starting Position
            System.out.println("Enter Starting Position (e.g., 0 0 N):");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String startDirection = scanner.next();
            Rover rover = new Rover(new Position(startX, startY), Direction.valueOf(startDirection));

            // Input Commands
            System.out.println("Enter Commands (e.g., MMRMLM):");
            String commandString = scanner.next();
            List<Command> commands = CommandParser.parseCommands(commandString);

            // Input Obstacles
            System.out.println("Enter number of obstacles:");
            int obstacleCount = scanner.nextInt();
            List<Obstacle> obstacles = new ArrayList<>();
            
            // Only ask for obstacle positions if there are obstacles
            if (obstacleCount > 0) {
                System.out.println("Enter obstacle positions (e.g., 2 2):");
                for (int i = 0; i < obstacleCount; i++) {
                    int obstacleX = scanner.nextInt();
                    int obstacleY = scanner.nextInt();
                    obstacles.add(new Obstacle(new Position(obstacleX, obstacleY)));
                }
            }

            grid.setObstacles(obstacles);

            // Execute commands
            ObstacleDetector detector = new ObstacleDetector(grid);
            for (Command command : commands) {
                try {
                    command.execute(rover, detector);
                } catch (ObstacleException e) {
                    logger.log("Obstacle detected. Stopping execution.");
                    obstacleDetected = true;  // Set flag to true if obstacle is detected
                    break;
                } catch (OutOfBoundsException e) {
                    logger.log("Rover out of bounds. Stopping execution.");
                    outOfBounds = true;  // Set flag to true if out of bounds is detected
                    break;
                }
            }

            // Output final position and status
            Position finalPosition = rover.getPosition();
            Direction finalDirection = rover.getDirection();
            System.out.println("Final Position: (" + finalPosition.getX() + ", " + finalPosition.getY() + ", " + finalDirection + ")");
            
            // Final status report based on obstacle or out-of-bounds detection
            if (obstacleDetected) {
                System.out.println("Status Report: Rover stopped at (" + finalPosition.getX() + ", " + finalPosition.getY() + 
                                   ") facing " + finalDirection + ". Obstacle detected.");
            } else if (outOfBounds) {
                System.out.println("Status Report: Rover stopped at (" + finalPosition.getX() + ", " + finalPosition.getY() + 
                                   ") facing " + finalDirection + ". Rover went out of bounds.");
            } else {
                System.out.println("Status Report: Rover is at (" + finalPosition.getX() + ", " + finalPosition.getY() + 
                                   ") facing " + finalDirection + ". No Obstacles detected.");
            }

        } catch (Exception e) {
            logger.log("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
