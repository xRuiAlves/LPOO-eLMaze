package com.mygdx.elmaze.model.levels;

import com.mygdx.elmaze.model.entities.BallModel;
import com.mygdx.elmaze.model.entities.ButtonModel;
import com.mygdx.elmaze.model.entities.DoorModel;
import com.mygdx.elmaze.model.entities.ExitModel;
import com.mygdx.elmaze.model.entities.WallModel;

/**
 * Represents the second singleplayer Level Model
 */
public class SPLevel2Model extends SinglePlayerLevelModel {

	/**
	 *  Creates the second singleplayer Level
	 */
	public SPLevel2Model() {
		createBall();
		createExit();
		createWalls();
		createButtonsDoors();
	}

	/**
	 *  Creates the Ball of the second singleplayer Level
	 */
	@Override
	protected void createBall() {
		ball = new BallModel(2.05f, 2.05f, 0.5f, 0);
	}

	/**
	 *  Creates the Buttons and Doors of the second singleplayer Level
	 */
	@Override
	protected void createButtonsDoors() {
		DoorModel door1 = new DoorModel(LEVEL_WIDTH-3.0f, LEVEL_HEIGHT*2/4+0.45f, 2.5f, 0.3f);
		doors.add(door1);	
		
		buttons.add(new ButtonModel(2.05f, 5.65f, 0.7f, doors.get(0)));
	}

	/**
	 *  Creates the Walls of the second singleplayer Level
	 */
	@Override
	protected void createWalls() {
		walls.add(new WallModel(0, 0, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, LEVEL_HEIGHT - 0.5f, LEVEL_WIDTH, 0.5f));	
		walls.add(new WallModel(0, 0, 0.5f, LEVEL_HEIGHT));	
		walls.add(new WallModel(LEVEL_WIDTH - 0.5f, 0, 0.5f, LEVEL_HEIGHT));			
		walls.add(new WallModel(0.5f, (LEVEL_HEIGHT-0.25f)*1/4, LEVEL_WIDTH - 3.5f, 0.5f));			
		walls.add(new WallModel(0.5f, (LEVEL_HEIGHT-0.25f)*2/4, LEVEL_WIDTH - 3.5f, 0.5f));			
		walls.add(new WallModel(3.0f, (LEVEL_HEIGHT-0.25f)*3/4, LEVEL_WIDTH - 3.5f, 0.5f));
	}

	/**
	 *  Creates he Exit of the second singleplayer Level
	 */
	@Override
	protected void createExit() {
		exit = new ExitModel(LEVEL_WIDTH - 2.05f, LEVEL_HEIGHT - 2.05f, 0.6f);
	}

}
