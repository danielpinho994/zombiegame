package org.academiadecodigo.zombiegame.field;

import org.academiadecodigo.zombiegame.gameobjects.Zombie;

public class CollisionDetector {

    private Zombie[] zombies;

    public CollisionDetector(Zombie[] zombies) {

        this.zombies = zombies;

        /*

    */
    }

    public void checkCollisionZombie(Zombie zombie) {

        for (Zombie z : zombies){

            if (zombie.equals(z)) {
                continue;
            }

            if (zombie.getFirstCol() <= z.getLastCol() && ( zombie.getFirstRow() <= z.getLastRow() || zombie.getLastRow() >= z.getFirstRow() )) {

                System.out.println(zombie.getFirstCol() + " " + z.getLastCol() + " " + zombie.getFirstRow() + " " + z.getLastRow() + " " + zombie.getLastRow() +
                        " " + z.getFirstRow());

                zombie.forbidLeft();
            }

            if (zombie.getLastCol() >= z.getFirstCol() && ( zombie.getFirstRow() <= z.getLastRow() || zombie.getLastRow() >= z.getFirstRow() )) {
                System.out.println("right");

                zombie.forbidRight();
            }

            if (zombie.getFirstRow() <= z.getLastRow() && ( zombie.getFirstCol() <= z.getLastCol() || zombie.getLastCol() >= z.getFirstCol() )) {
                System.out.println("up");

                zombie.forbidUp();
            }

            if (zombie.getLastRow() >= z.getFirstRow() && ( zombie.getFirstCol() <= z.getLastCol() || zombie.getLastCol() >= z.getFirstCol() )) {
                System.out.println("down");

                zombie.forbidDown();
            }
        }

        /*
        for(int i = 0; i < bullet.length; i++){

            for(int x = 0 ; x < zombies.length ; x ++){

                if(bullet[i].getPos.getCol().equals(zombie[x].getPos.getCol())){

                    bullet[i].setColided();
                    zombies[x].setColided();

                }

            }
            \*/
    }
}
