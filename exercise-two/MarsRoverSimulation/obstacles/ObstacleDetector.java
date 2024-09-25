package obstacles;

import models.Grid;
import models.Position;

public class ObstacleDetector {
    private Grid grid;

    public ObstacleDetector(Grid grid) {
        this.grid = grid;
    }

    public boolean hasObstacle(Position position) {
        return grid.getObstacles().stream()
                .anyMatch(obstacle -> obstacle.getPosition().equals(position));
    }

    public boolean isWithinBounds(Position position) {
        return grid.isWithinBounds(position);
    }
}