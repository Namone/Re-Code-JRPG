package com.namone.gameStateManager;

import java.util.ArrayList;

import com.namone.gameStates.GameState;
import com.namone.gameStates.Menu;
import com.namone.gameStates.RunGame;
import com.namone.player.Player;

public class GameStateManager {

	private int MENU = 0;
	private int RUN_GAME = 1;
	private int currentState; // LETS US MOVE THROUGH ARRAY-LIST INDICES
	private ArrayList<GameState> gameStates = new ArrayList<GameState>();

	public void GameState(GameStateManager gsm) {
		currentState = RUN_GAME; // DEFAULT STATE IS MENU - CURRENTLY SET TO
									// GAME

		gameStates.add(new Menu(gsm)); // ADD MENU OBJECT AT POSITION 0 OF ARRAY
		gameStates.add(new RunGame(gsm)); // ADD NEW RUNGAME OBJECT AT POSITION 1
										// OF ARRAY
	}
	public void setGameState(int gameState){
		currentState = gameState;
	}

	public void update(Player player) {
		// UPDATE CURRENT GAME-STATE
		gameStates.get(currentState).update(player);

	}

	public void draw(Player player) {
		// DRAW CURRENT GAME-STATE
		gameStates.get(currentState).draw(player);

		if (currentState == RUN_GAME) {
			gameStates.get(1).draw(player);
		}

	}

}
