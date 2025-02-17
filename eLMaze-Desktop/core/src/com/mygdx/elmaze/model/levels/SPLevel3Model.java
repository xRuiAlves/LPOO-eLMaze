package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

/**
 * Represents the third singleplayer Level Model
 */
public class SPLevel3Model extends SinglePlayerLevelModel {

	/**
	 *  Creates the third singleplayer Level
	 */
	public SPLevel3Model() {
		createBall();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	/**
	 *  Creates the Ball of the third singleplayer Level
	 */
	@Override
	protected void createBall() {
		ball = new BallModel(LEVEL_WIDTH -2, 2.05f, 0.5f, 0);
	}

	/**
	 *  Creates the Buttons and Doors of the third singleplayer Level
	 */
	@Override
	protected void createButtonsDoors() {
		DoorModel door1 = new DoorModel((LEVEL_WIDTH - 0.25f)*3/5 + 0.1f, (LEVEL_HEIGHT-2.5f)/2, 0.3f, 2.5f);
		doors.add(door1);	
		
		buttons.add(new ButtonModel(LEVEL_WIDTH * 7/10 + 0.125f, 2.05f, 0.7f, doors.get(0)));
		
		DoorModel door2 = new DoorModel((LEVEL_WIDTH - 0.25f)*1/5 + 0.08f, LEVEL_HEIGHT - 2.5f, 0.3f, 2f);
		doors.add(door2);	
		
		buttons.add(new ButtonModel(LEVEL_WIDTH/2 + 0.125f, LEVEL_HEIGHT - 2.05f, 0.7f, doors.get(1)));
	}

	/**
	 *  Creates the Walls of the third singleplayer Level
	 */
	@Override
	protected void createWalls() {
		walls.add(new WallModel(0, 0, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, LEVEL_HEIGHT - 0.5f, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, LEVEL_HEIGHT));	
		walls.add(new WallModel(LEVEL_WIDTH - 0.5f, 0, 0.5f, LEVEL_HEIGHT));			
		walls.add(new WallModel((LEVEL_WIDTH - 0.25f)*1/5, 0.5f, 0.5f, LEVEL_HEIGHT - 3.0f));			
		walls.add(new WallModel((LEVEL_WIDTH - 0.25f)*2/5, 3.0f, 0.5f, LEVEL_HEIGHT - 3.5f));			
		walls.add(new WallModel((LEVEL_WIDTH - 0.25f)*3/5, 0.5f, 0.5f, (LEVEL_HEIGHT-3.5f)/2));
		walls.add(new WallModel((LEVEL_WIDTH - 0.25f)*3/5, LEVEL_HEIGHT/2 + 1.75f, 0.5f, (LEVEL_HEIGHT-3.5f)/2));
		walls.add(new WallModel((LEVEL_WIDTH - 0.25f)*4/5, 0.5f, 0.5f, LEVEL_HEIGHT - 3.0f));
	}

	/**
	 *  Creates the Exit of the third singleplayer Level
	 */
	@Override
	protected void createExit() {
		exit = new ExitModel(2.05f, 2.05f, 0.6f);
	}

}
