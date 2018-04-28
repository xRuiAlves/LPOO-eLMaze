package com.mygdx.elmaze.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.elmaze.ELMaze;
import com.mygdx.elmaze.networking.Utilities;
import com.mygdx.elmaze.networking.NetworkManager;

import java.util.ArrayList;
import java.util.LinkedList;

public class ServerConnectionView extends MenuView {

    // Title
    private Image title;

    // Background
    private Image inputArea;
    private Button startButton;
    private Button backspaceButton;

    // Symbol Buttons
    private ArrayList<Button> keypadButtons = new ArrayList<Button>();
    private ArrayList<String> symbolFileNames = new ArrayList<String>();

    // Game Code input
    private static final int keyCodeImgSize = (int)(SCREEN_WIDTH*0.07);
    private LinkedList<Integer> keyCode = new LinkedList<Integer>();
    private ArrayList<Image> keyCodeImages = new ArrayList<Image>();

    public ServerConnectionView(ELMaze game) {
        super(game, TYPE.CONNECTION);
        //setUpTextTable();   // To show the code the user is writing
        setupTitle();
        setupButtons();
        setupImages();
        setupSymbols();
        setupStage();
        createButtonListeners();
    }

    @Override
    public void render(float delta) {
        stage.act(delta); //Perform ui logic
        stage.draw(); //Draw the UI
        handleInputs();
    }

    private void setupImages() {
        inputArea = ImageFactory.makeImage(
                "genericButtonUp.png",
                SCREEN_WIDTH*1/10,
                SCREEN_HEIGHT*35/48,
                (int)(SCREEN_WIDTH*0.8),
                (int)(SCREEN_WIDTH*0.1)
        );
    }

    private void setupButtons() {
        int buttonSize = (int)(SCREEN_WIDTH*0.15);
        startButton = ButtonFactory.makeButton( "startButtonUp.png","startButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*1/8, (int)(0.55*SCREEN_WIDTH), buttonSize);
        backspaceButton = ButtonFactory.makeButton( "backspaceButtonUp.png","backspaceButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*1/8, buttonSize, buttonSize);
        keypadButtons.add(ButtonFactory.makeButton( "alphaButtonUp.png","alphaButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "betaButtonUp.png","betaButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "chiButtonUp.png","chiButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "deltaButtonUp.png","deltaButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*5/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "epsilonButtonUp.png","epsilonButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "etaButtonUp.png","etaButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "gamaButtonUp.png","gamaButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "lambdaButtonUp.png","lambdaButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*4/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "muButtonUp.png","muButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "omegaButtonUp.png","omegaButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "phiButtonUp.png","phiButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "piButtonUp.png","piButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*3/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "psiButtonUp.png","psiButtonDown.png",SCREEN_WIDTH*1/5,SCREEN_HEIGHT*2/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "rhoButtonUp.png","rhoButtonDown.png",SCREEN_WIDTH*2/5,SCREEN_HEIGHT*2/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "sigmaButtonUp.png","sigmaButtonDown.png",SCREEN_WIDTH*3/5,SCREEN_HEIGHT*2/8, buttonSize, buttonSize));
        keypadButtons.add(ButtonFactory.makeButton( "tauButtonUp.png","tauButtonDown.png",SCREEN_WIDTH*4/5,SCREEN_HEIGHT*2/8, buttonSize, buttonSize));
    }

    private void setupSymbols() {
        symbolFileNames.add("alphaSymbol.png");
        symbolFileNames.add("betaSymbol.png");
        symbolFileNames.add("chiSymbol.png");
        symbolFileNames.add("deltaSymbol.png");
        symbolFileNames.add("epsilonSymbol.png");
        symbolFileNames.add("etaSymbol.png");
        symbolFileNames.add("gamaSymbol.png");
        symbolFileNames.add("lambdaSymbol.png");
        symbolFileNames.add("muSymbol.png");
        symbolFileNames.add("omegaSymbol.png");
        symbolFileNames.add("phiSymbol.png");
        symbolFileNames.add("piSymbol.png");
        symbolFileNames.add("psiSymbol.png");
        symbolFileNames.add("rhoSymbol.png");
        symbolFileNames.add("sigmaSymbol.png");
        symbolFileNames.add("tauSymbol.png");

        for (int i=0 ; i<8 ; i++) {
            keyCodeImages.add(ImageFactory.makeImage("empty.png", SCREEN_WIDTH*(11.5f/100+(float)0.1*i),
                    SCREEN_HEIGHT*887/1200, keyCodeImgSize, keyCodeImgSize));
        }
    }

    private void setupTitle(){
        Texture texture = ImageFactory.makeSizedTexture("passcode.png", SCREEN_WIDTH*82/100);
        title = new Image(texture);
        title.setPosition(SCREEN_WIDTH/2, SCREEN_HEIGHT*8f/9, 1);
        title.setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
    }

    private void setupStage() {
        stage.addActor(title);
        stage.addActor(startButton);
        stage.addActor(backspaceButton);
        stage.addActor(inputArea);

        // Add Keypad Buttons
        for (Button button : keypadButtons) {
            stage.addActor(button);
        }

        // Add Keypad 'Input'
        for (Image img : keyCodeImages) {
            stage.addActor(img);
        }
    }

    private void createButtonListeners() {
        for (int i=0 ; i<keypadButtons.size() ; i++) {
            final int myIndex = i;
            keypadButtons.get(i).addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (keyCode.size() < 8) {
                        keyCodeImages.get(keyCode.size()).setDrawable(new TextureRegionDrawable(new TextureRegion(
                                ImageFactory.makeSizedTexture(symbolFileNames.get(myIndex), keyCodeImgSize, keyCodeImgSize)
                                )));
                        keyCode.add(myIndex);
                    }
                }
            });
        }

        backspaceButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!keyCode.isEmpty()) {
                    keyCode.pop();
                    keyCodeImages.get(keyCode.size()).setDrawable(null);
                }
            }
        });

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                connectToServer();
            }
        });
    }

    private void connectToServer() {
        if (keyCode.size() == 8 &&
            NetworkManager.getInstance().establishConnection(Utilities.parse(keyCode), 3000)) {
            game.activateMenu(MenuFactory.makeMenu(game, TYPE.PLAY));
            System.out.println("Connected.");
        }
        else {
            System.out.println("Failed Connection.");
            clearKeyCode();
        }
    }

    private void clearKeyCode() {
        while (!keyCode.isEmpty()) {
            keyCode.pop();
            keyCodeImages.get(keyCode.size()).setDrawable(null);
        }
    }

    protected void handleInputs() {}

}
