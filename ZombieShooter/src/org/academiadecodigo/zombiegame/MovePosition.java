package org.academiadecodigo.zombiegame;


public enum MovePosition {

    UP,
    DOWN,
    LEFT,
    RIGHT;


    public boolean isOpposite(MovePosition direction){

        return direction.equals(oppositeDirection());

    }
    public static MovePosition getRandomDirection(){
        int random = (int) Math.floor(Math.random()*MovePosition.values().length);
        return MovePosition.values()[random];
    }

    public MovePosition oppositeDirection(){

        MovePosition opposite = null;

        switch(this) {

            case UP:
                opposite = MovePosition.DOWN;
                break;
            case DOWN:
                opposite = MovePosition.UP;
                break;
            case LEFT:
                opposite = MovePosition.RIGHT;
                break;
            case RIGHT:
                opposite = MovePosition.LEFT;
                break;
        }

        return opposite;
    }

}
