package com.mygdx.elmaze.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;

/**
 * Represents a menu view
 */
public abstract class MenuView extends ScreenAdapter{
    
	/**
	 * The types of menus
	 */
	public enum TYPE { MAIN, 
					   CREDITS, 
					   INSTRUCTIONS, 
					   NUMPLAYERCHOICE, 
					   PLATFORMCHOICE, 
					   SPMOBILE, 
					   MPMOBILE, 
					   SPKEYBOARD, 
					   MPKEYBOARD,
					   WIN,
					   CLIENTDC
					 };
	
    protected final ELMaze game;
    public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
    
    protected Stage stage;
    protected Image backgroundImage;
    protected Sound buttonClickSound;
    private TYPE type;
    
    /**
     * Creates the menu
     * 
     * @param game Reference to the Game object
     */
    public MenuView(ELMaze game,  TYPE type) {
    	this.game = game;
    	this.type = type;
    	loadAssets();
    	
    	setupButtonSound();
    	setupBackground();
    	
    	stage = new Stage();
        stage.addActor(backgroundImage);
    }
    
    /**
	 * Loads all assets needed for the menu
	 */
    protected abstract void loadAssets();
    
    /**
     * Sets up the background of the menus with the background image
     */
    private void setupBackground(){
        Texture backgroundTexture = game.getAssetManager().get("menuBackground.jpg", Texture.class);
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setDrawable(new TextureRegionDrawable(new TextureRegion(backgroundTexture)));
    }
    
    /**
     * Sets up the sounds of the menu Buttons
     */
    private void setupButtonSound() {
        this.game.getAssetManager().load( "buttonClick.mp3" , Sound.class);
        this.game.getAssetManager().finishLoading();
        
        buttonClickSound = game.getAssetManager().get("buttonClick.mp3");
    }

    /**
     * Activates the menu
     */
    public void activate() {
        Gdx.input.setInputProcessor(stage);
    }
    
    /**
     * Adds the sound of the Play Button
     */
    protected void playButtonSound() {
    	buttonClickSound.play(0.75f);
    }

}
