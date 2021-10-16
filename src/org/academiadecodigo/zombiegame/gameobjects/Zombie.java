package org.academiadecodigo.zombiegame.gameobjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.zombiegame.field.Background;
import org.academiadecodigo.zombiegame.field.Direction;
import org.academiadecodigo.zombiegame.field.Position;
import org.academiadecodigo.zombiegame.field.Zones;

public class Zombie extends Movable {

    private Position playerPos;

    private String picturePath = "assets/Zombies/right-mid zombie.png";

    private Direction picToUseUpDown;
    private Direction picToUseLeftRight;
    private PictureDirections picdic;


    private int hitPoints = 3;

    private int health = 1;

    public Zombie(Position pos, Position playerPos, Zones spawnZone) {
        super(30, 30, spawnZone);

        this.playerPos = playerPos;

        setPosition(pos, picturePath);
    }

    public void moveZombie() {

        picToUseLeftRight = null;
        picToUseUpDown = null;

        int targetCol = playerPos.getCol();
        int targetRow = playerPos.getRow();

        if (targetCol > pos.getCol() && !forbiddenRight) {
            super.moveObject(Direction.RIGHT);
            picToUseLeftRight = Direction.RIGHT;
        }

        if (targetCol < pos.getCol() && !forbiddenLeft) {
            super.moveObject(Direction.LEFT);
            picToUseLeftRight = Direction.LEFT;
        }

        if (targetRow < pos.getRow() && !forbiddenUp) {
            super.moveObject(Direction.UP);
            picToUseUpDown = Direction.UP;

        }

        if (targetRow > pos.getRow() && !forbiddenDown) {
            super.moveObject(Direction.DOWN);
            picToUseUpDown = Direction.DOWN;

        }

        if (picToUseUpDown == Direction.UP) {

            if (picToUseLeftRight == Direction.LEFT) {
                if (picdic != PictureDirections.UPLEFT) {
                    picdic = PictureDirections.UPLEFT;
                    changePic("assets/Zombies/zombie2.png");
                }
                return;
            }
            if (picToUseLeftRight == Direction.RIGHT) {
                if (picdic != PictureDirections.UPRIGHT) {
                    picdic = PictureDirections.UPRIGHT;
                    changePic("assets/Zombies/zombie3.png");
                }
                return;
            }

            if (picdic != PictureDirections.UP) {
                picdic = PictureDirections.UP;
                changePic("assets/Zombies/down-top zombie.png");
            }
            return;
        }
        if (picToUseUpDown == Direction.DOWN) {

            if (picToUseLeftRight == Direction.LEFT) {
                if (picdic != PictureDirections.DOWNLEFT) {
                    picdic = PictureDirections.DOWNLEFT;
                    changePic("assets/Zombies/zombie1.png");
                }
                return;
            }
            if (picToUseLeftRight == Direction.RIGHT) {
                if (picdic != PictureDirections.DOWNRIGHT) {
                    picdic = PictureDirections.DOWNRIGHT;
                    changePic("assets/Zombies/zombie4.png");
                }
                return;
            }
            if(picdic != PictureDirections.DOWN) {
                changePic("assets/Zombies/top-down zombie.png");
            }
            return;
        }
        if (picToUseLeftRight == Direction.LEFT) {
            if (picdic != PictureDirections.LEFT) {
                picdic = PictureDirections.LEFT;
                changePic("assets/Zombies/left-mid zombie.png");
            }
            return;
        }
        if (picToUseLeftRight == Direction.RIGHT) {
            if (picdic != PictureDirections.RIGHT) {
                picdic = PictureDirections.RIGHT;
                changePic("assets/Zombies/right-mid zombie.png");
            }
            return;
        }

    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void hit() {
        this.health -= 1;
        if (health == 0) {
            this.picture.delete();
            Position newPos = new Position(-1, -1);
            this.setPosition(newPos, null);
        }
    }
}
