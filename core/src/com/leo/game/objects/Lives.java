package com.leo.game.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.leo.game.Security;

/**
 * Created by leonidtiskevic on 28.02.17.
 */

public class Lives {

    private Array<Rectangle> lives;
    private Rectangle live1;
    private Rectangle live2;
    private Rectangle live3;
    private Rectangle live4;

    public Lives(){

        lives = new Array<Rectangle>();

        live1 = new Rectangle();
        live1.x = Security.WIDTH - 30 - 16/2;
        live1.y = Security.HEIGHT - 25;
        live1.width = 16;
        live1.height = 16;
        lives.add(live1);

        live2 = new Rectangle();
        live2.x = Security.WIDTH - 50 - 16/2;
        live2.y = Security.HEIGHT - 25;
        live2.width = 16;
        live2.height = 16;
        lives.add(live2);

        live3 = new Rectangle();
        live3.x = Security.WIDTH - 70 - 16/2;
        live3.y = Security.HEIGHT - 25;
        live3.width = 16;
        live3.height = 16;
        lives.add(live3);

        live4 = new Rectangle();
        live4.x = Security.WIDTH - 90 - 16/2;
        live4.y = Security.HEIGHT - 25;
        live4.width = 16;
        live4.height = 16;
        lives.add(live4);

    }

    public Array<Rectangle> getLives() {
        return lives;
    }
}
