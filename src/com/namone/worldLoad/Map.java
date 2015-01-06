package com.namone.worldLoad;

import java.io.Serializable;
import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import com.namone.fileManagement.SaveFile;

public class Map implements Serializable {

	protected TiledMap map;
	// KEEP TRACK OF WHICH BLOCKS COLLIDE
	private boolean blocked[][]; 
	// ID OF TILE
	private int tileID;
	// INDEX OF LAYER TO CHECK FOR COLLISION
	private int layerIndex; 
	// SIZE OF TILE (32)
	private int tileSize;
	// PROPERTIES OF BLOCKS
	private String blockProperty; // HOLDS PROPERTIES OF BLOCK TO CHECK
	// TO CHECK AGAINST
	private ArrayList<Rectangle> collisionBlocks;
	private SaveFile saveMap = new SaveFile();

	/*
	 * MAIN CLASS FOR ALL WORLD TYPES - LOADWORLD.JAVA DOES NOT EXTEND THIS
	 * DUE TO STACKOVERFLOW ERROR
	 */
	public Map() {		

		try {
			map = new TiledMap("resources/Map/JRPGMap 1.0.tmx");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ALL OVERRIDDEN
	public void draw() {
		
	}
	
	public void update() {
		
	}
	
	public void saveMap() {
		
	}
	
	public Object loadMap() {
		return null;
		
	}
	
	// GETTERS & SETTERS
	public ArrayList<Rectangle> getRectList() {
		return null;
	}



}
