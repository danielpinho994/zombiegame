package org.academiadecodigo.zombiegame.gameobjects.walls;

        import org.academiadecodigo.simplegraphics.graphics.Rectangle;
        import org.academiadecodigo.zombiegame.field.Background;
        import org.academiadecodigo.zombiegame.field.Position;
        import org.academiadecodigo.zombiegame.field.Zones;
        import org.academiadecodigo.zombiegame.gameobjects.GameObject;

public abstract class Wall extends GameObject {

    public Wall(Position pos, Zones zone) {
        super(zone);

        super.pos = pos;

    }

    public void remove() {
    }
}

