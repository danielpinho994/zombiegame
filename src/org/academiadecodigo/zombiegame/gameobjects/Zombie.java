package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class Zombie extends Movable{

    private Position playerPos;

    private String picturePath = "assets/Zombies/right-mid zombie.png";

    private Direction[] picToUse;


    private int hitPoints = 3;

    private int health = 1;

    public Zombie(Position pos, Position playerPos, Zones spawnZone) {
        super(30, 30, spawnZone);

        this.playerPos = playerPos;

        setPosition(pos, picturePath);
    }

    public void moveZombie() {

        int targetCol = playerPos.getCol();
        int targetRow = playerPos.getRow();

        if (targetCol > pos.getCol() && !forbiddenRight) {
            super.moveObject(Direction.RIGHT);
            if(picToUse==null){
                picToUse = new Direction[2];
                picToUse[0] = Direction.RIGHT;
            }
            else{
                picToUse[1] = Direction.RIGHT;
            }
        }

        if (targetCol < pos.getCol() && !forbiddenLeft) {
            super.moveObject(Direction.LEFT);
            if(picToUse==null){
                picToUse = new Direction[2];
                picToUse[0] = Direction.LEFT;
            }
            else{
                picToUse[1] = Direction.LEFT;
            }
        }

        if (targetRow < pos.getRow() && !forbiddenUp) {
            super.moveObject(Direction.UP);
            if(picToUse==null){
                picToUse = new Direction[2];
                picToUse[0] = Direction.UP;
            }
            else{
                picToUse[1] = Direction.UP;
            }
        }

        if (targetRow > pos.getRow() && !forbiddenDown) {
            super.moveObject(Direction.DOWN);
            if(picToUse==null){
                picToUse = new Direction[2];
                picToUse[0] = Direction.DOWN;
            }
            else{
                picToUse[1] = Direction.DOWN;
            }
        }

       if(picToUse[1]==null){

           if(picToUse[0] == Direction.DOWN){
               setPosition(pos,"assets/Zombies/top-down zombie.png");
               return;
           }
           if(picToUse[0] == Direction.UP){
               setPosition(pos,"assets/Zombies/down-top zombie.png");
           }
           if(picToUse[0] == Direction.LEFT){
               setPosition(pos,"assets/Zombies/left-mid zombie.png");
           }
           if(picToUse[0] == Direction.RIGHT){
               setPosition(pos,"assets/Zombies/right-mid zombie.png");
           }
       }
       if(picToUse[1]==Direction.DOWN){

       }

    }

    public int getHitPoints() {
        return hitPoints;
    }
    public void hit() {
        this.health -= 1;
        if(health==0){
            this.picture.delete();
            Position newPos = new Position(0,0);
            this.setPosition(newPos, null);
        }
    }

    public int getHealth() {
        return health;
    }
}
