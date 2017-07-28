package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

/**
 * Created by jjiang on 7/27/2017.
 */

public class Animation {

    private Array<TextureRegion> frames; // store all frames
    private float maxFrameTime;  // how long a frame will stay in the view before switch to next one
    private float currentFrameTime;  // the time animation in the current frame
    private int frameCount; // count how many frame in the animation
    private int frame; // current frame actually in

    public Animation(TextureRegion region, int frameCount, float cycleTime){  // cycleTime : how long to cycle  through the entire animation

        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++){

            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }

        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt){

        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }

        if(frame >= frameCount)
            frame = 0;
    }

    public TextureRegion getFrame(){
        return  frames.get(frame);
    }
}
