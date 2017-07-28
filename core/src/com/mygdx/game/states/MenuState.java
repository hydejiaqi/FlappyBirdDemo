package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyBirdDemo;

/**
 * Created by jjiang on 7/20/2017.
 */

public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyBirdDemo.WIDTH / 2, FlappyBirdDemo.HEIGHT / 2);  // set cam the center of the screen
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {

        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
           // dispose();  reuse for restart
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0 ,0);
       // sb.draw(playBtn, (FlappyBirdDemo.WIDTH / 2) - (playBtn.getWidth() / 2), (FlappyBirdDemo.HEIGHT / 2));  for android only
        sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y);
        sb.end();

    }

    @Override
    public void dispose() {

        background.dispose();
        playBtn.dispose();
        System.out.println("Menu State dispose");
    }


}
