package it.polito.tdp.spellchecker.model;

import java.io.IOException;
import java.util.*;

public class SpellCheckerModel {
	private SpellCheckerModel model;
	private Dictionary dizionario;
	private List<String> sbagliate;
	
	public SpellCheckerModel () throws IOException {
		dizionario = new Dictionary ();
		
	}

	
	
	
	public List<String> nuovaTrad (String testo, String lingua) {
		sbagliate = new LinkedList<String>();
		testo = testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "").toLowerCase();
		testo = testo.replaceAll("[0-9]", "");
		String parola [] = testo.split(" ");
		
			if (lingua.equals("Italian")) {
				for (int i = 0; i<parola.length; i++) {
					if (!parola[i].equals("")) {
						if (!dizionario.getItaliano().contains(parola[i])) {
							sbagliate.add(parola[i]);
					}
				}
				}
			}
			
			if (lingua.equals("English")) {
				for (int j = 0; j<parola.length; j++) {
					if (parola[j].equals("")) {
						if (!dizionario.getInglese().contains(parola[j])) {
						sbagliate.add(parola[j]);
					}
				}
			}
		}
	return sbagliate;
	
	}
	
	}
