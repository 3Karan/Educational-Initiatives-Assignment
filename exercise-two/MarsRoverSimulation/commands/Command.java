package commands;

import models.Rover;
import obstacles.ObstacleDetector;
import exceptions.ObstacleException;
import exceptions.OutOfBoundsException;

public interface Command {
    void execute(Rover rover, ObstacleDetector detector) throws ObstacleException, OutOfBoundsException;
}