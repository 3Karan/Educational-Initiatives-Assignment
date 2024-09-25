package commands;

import models.Rover;
import obstacles.ObstacleDetector;

public class TurnRightCommand implements Command {
    @Override
    public void execute(Rover rover, ObstacleDetector detector) {
        rover.turnRight();
    }
}