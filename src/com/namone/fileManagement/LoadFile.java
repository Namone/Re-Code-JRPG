package com.namone.fileManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadFile {
	
	String playerX;
	String playerY;
	int x;
	int y;
	
	public void loadPlayer() {
		try {
			FileReader loadPlayer = new FileReader("playerSave.text");
			BufferedReader buffRead = new BufferedReader(loadPlayer);
			playerX = buffRead.readLine(); // READ FIRST LINE
			playerY = buffRead.readLine(); // READ SECOND LINE
			System.out.println(playerX + " " + playerY);
			buffRead.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Player loaded at: " + playerX + ", " + playerY);
	}
	
	// GET VALUES OF READ PLAYER DATA
	public int getPlayerX() {
		x = Integer.parseInt(playerX);		
		return x;
	}
	
	// GET VALUES OF READ PLAYER DATA
	public int getPlayerY() {
		y = Integer.parseInt(playerY);
		return y;
	}

}
