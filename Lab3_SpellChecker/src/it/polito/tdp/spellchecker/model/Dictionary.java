package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	private List<String> italiano;
	private List<String> inglese;
	
	
	public Dictionary () throws IOException {
		italiano = new LinkedList<String>();
		inglese = new LinkedList<String>();
		
		try {
			BufferedReader brIta = new BufferedReader(new FileReader ("rsc/Italian.txt"));
			BufferedReader brEng = new BufferedReader(new FileReader ("rsc/English.txt"));
			String line;
			
			while ((line = brIta.readLine()) != null) {
				this.italiano.add(line);
			}
			brIta.close();
			
			while ((line = brEng.readLine()) != null) {
				this.inglese.add(line);
			}
			brEng.close();
			
		} catch (IOException e) {
			
		}
	}


	public List<String> getItaliano() {
		return italiano;
	}


	public List<String> getInglese() {
		return inglese;
	}
	
	
	
	
}
