package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.FlappyBirdDemo;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Tube;

/**
 * Created by jjiang on 7/20/2017.
 */

public class PlayState extends State {

    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    private Bird bird;
    private Texture bg;

    private Array<Tube> tubes;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 300);
        cam.setToOrtho(false, FlappyBirdDemo.WIDTH / 2, FlappyBirdDemo.HEIGHT / 2);  // set cam the center of the screen
        bg = new Texture("bg.png");
        tubes = new Array<Tube>();

        for(int i = 1; i <= TUBE_COUNT; i++){

            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUEB_WIDTH)));
        }

    }

    @Override
    protected void handleInput() {  // Important

        if(Gdx.input.justTouched()){

            bird.jump();
        }

    }

    @Override
    public void update(float dt) { // update sprites

        handleInput();
        bird.update(dt);
        cam.position.x = bird.getPosition().x + 80;

        for (Tube tube : tubes){

            if(cam.position.x - (cam.viewportWidth/2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){

                tube.reposition(tube.getPosTopTube().x + (Tube.TUEB_WIDTH + TUBE_SPACING) * TUBE_COUNT);
            }
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);  // where the game world are, only draws the things camera can see.
        sb.begin();
        sb.draw(bg, cam.position.x - cam.viewportWidth / 2, 0); // since cam is always center of the screen
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y );

        for(Tube tube : tubes){

            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
