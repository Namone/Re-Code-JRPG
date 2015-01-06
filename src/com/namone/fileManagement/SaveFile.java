package com.namone.fileManagement;

import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.newdawn.slick.tiled.TiledMap;

import com.namone.player.Player;
import com.namone.worldLoad.Map;

public class SaveFile implements Serializable {
		
	public void saveMap(Object map) {
		try {
			XMLEncoder mapOutput = new XMLEncoder(new FileOutputStream("maptest.bin"));
			mapOutput.writeObject(map);
			mapOutput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void savePlayer(String x, String y) {
		try {
			FileWriter playerOutput = new FileWriter("playerSave.text");
			BufferedWriter buffWrite = new BufferedWriter(playerOutput);
			buffWrite.write(x + "\n");
			buffWrite.write(y + "\n");
			buffWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("INFO: Player saved successfully");
	}

}
