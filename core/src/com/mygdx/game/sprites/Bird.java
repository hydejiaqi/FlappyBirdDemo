package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by jjiang on 7/20/2017.
 */

public class Bird {


    private Vector3 position; // x,y and z，but only 2 will be used
    private Vector3 velocity;
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private Texture bird;

    public Bird(int x, int y) {

        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bird = new Texture("bird.png");

    }

    public void update(float dt){
        if(position.y > 0)
            velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);  // times time
        position.add(MOVEMENT * dt, velocity.y, 0);

        if(position.y < 0){

            position.y = 0;
        }


        velocity.scl(1/dt);  // divide time to get original velocity
    }

    public Texture getTexture(){

        return bird;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }


    public void jump(){

        velocity.y = 250;

    }

}
