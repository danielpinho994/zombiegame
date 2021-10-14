package org.academiadecodigo.zombiegame.field;


public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;

    public boolean isOpposite(Direction direction){

        return direction.equals(oppositeDirection());

    }

    public static Direction getRandomDirection(){
        int random = (int) Math.floor(Math.random()* Direction.values().length);
        return Direction.values() [random];
    }

    public Direction oppositeDirection(){

        Direction opposite = null;

        switch(this) {

            case UP:
                opposite = Direction.DOWN;
                break;
            case DOWN:
                opposite = Direction.UP;
                break;
            case LEFT:
                opposite = Direction.RIGHT;
                break;
            case RIGHT:
                opposite = Direction.LEFT;
                break;
        }

        return opposite;
    }

}
