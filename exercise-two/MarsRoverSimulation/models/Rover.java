package models;

public class Rover {
    private Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void move() {
        switch (direction) {
            case N:
                position.setY(position.getY() + 1);
                break;
            case E:
                position.setX(position.getX() + 1);
                break;
            case S:
                position.setY(position.getY() - 1);
                break;
            case W:
                position.setX(position.getX() - 1);
                break;
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }
}