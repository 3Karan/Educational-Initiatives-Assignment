package obstacles;

import models.Position;

public class Obstacle {
    private Position position;

    public Obstacle(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}