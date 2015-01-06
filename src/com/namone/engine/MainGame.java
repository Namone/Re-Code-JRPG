package com.namone.engine;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Graphics;

import com.namone.fileManagement.SaveFile;
import com.namone.gameStateManager.GameStateManager;
import com.namone.player.Clev;
import com.namone.player.Player;
import com.namone.textureLoad.LoadTextures;

public class MainGame {

	private LoadTextures loadTexture;
	private GameStateManager gameStates;
	private Player player;
	private Graphics graphics; // GRAPHICS OBJECT TO DRAW, ETC
	private Graphics g; // GRAPHICS CONTEXT

	// START THE GAME
	public MainGame() {
		initialize();
	}

	// INITIALIZE THE GAME
	public void initialize() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setResizable(false);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		System.out.println(Display.getWidth());
		System.out.println(Display.getHeight());

		// TODO ADD GRAPHICS CONTEXT & GRAPHICS OBJECT (FOR TEXT DRAWING, ETC)

		// CLEV IS THE DEFAULT PLAYER
		// CREATE THE PLAYER (DON'T DRAW YET)
		player = new Clev();
		// INITIALIZE OPENGL
		setOpenGL();

		// SET EVERYTHING UP
		gameStates = new GameStateManager();
		loadTexture = new LoadTextures(); // SO I CAN LOAD MY TEXTURES

		// START GAME-STATES
		gameStates.GameState(gameStates);

		// TELL US WHAT'S GOING ON
		System.out.println("Application Initialized...");

		// LOOP THROUGH THE GAME
		gameLoop();

		// WHEN WE'RE DONE (SHOULD NOT RUN TILL AFTER GAME CLOSES)
		System.out.println("- APPLICATION CLOSED -");
	}

	// KEEP THE GAME ALIVE
	public void gameLoop() {
		while (!Display.isCloseRequested()) {
			Display.update();
			Display.sync(60);

			update();
			draw();
		}

	}

	// UPDATE GAME - PLAYER POSITION, ETC.
	public void update() {
		gameStates.update(player); // UPDATE THE SELECTED GAME STATE

		glLoadIdentity();
		// FOLLOW THE PLAYER
		glOrtho(player.PlayerX - Display.getWidth() / 2, player.PlayerX + 450,
				player.PlayerY + 350, player.PlayerY - Display.getHeight() / 2, 1, -1);

	}

	// DRAW THE GAME SPRITES/GRAPHICS
	public void draw() {
		glClear(GL_COLOR_BUFFER_BIT); // CLEAR COLOR
		glClearColor(1, 1, 1, 1); // PAINT COLOR (WILL DELETE IN FUTURE)
		gameStates.draw(player); // DRAW THE SELECTED GAME STATE
	}

	public void setOpenGL() {
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glEnable(GL_TEXTURE_2D);
		glMatrixMode(GL_PROJECTION);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST);

		System.out.println("OpenGL Initialized...");
	}

}
