package commands;

import models.Rover;
import models.Position;
import obstacles.ObstacleDetector;
import exceptions.ObstacleException;
import exceptions.OutOfBoundsException;

public class MoveCommand implements Command {
    @Override
    public void execute(Rover rover, ObstacleDetector detector) throws ObstacleException, OutOfBoundsException {
        Position newPosition = new Position(rover.getPosition().getX(), rover.getPosition().getY());
        
        switch (rover.getDirection()) {
            case N:
                newPosition.setY(newPosition.getY() + 1);
                break;
            case E:
                newPosition.setX(newPosition.getX() + 1);
                break;
            case S:
                newPosition.setY(newPosition.getY() - 1);
                break;
            case W:
                newPosition.setX(newPosition.getX() - 1);
                break;
        }
        
        if (!detector.isWithinBounds(newPosition)) {
            throw new OutOfBoundsException("Move would place rover out of bounds");
        }
        
        if (detector.hasObstacle(newPosition)) {
            throw new ObstacleException("Obstacle detected at " + newPosition.getX() + ", " + newPosition.getY());
        }
        
        rover.move();
    }
}