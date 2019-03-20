package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.SpellCheckerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	private SpellCheckerModel model;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextArea txtiInserisci;

    @FXML
    private Button checkButton;

    @FXML
    private TextArea txtWrong;

    @FXML
    private Label errNumb;

    @FXML
    private Button clearButton;

    @FXML
    private Label timeLabel;
    
    
    public SpellCheckerModel getModel() {
		return model;
	}

	public void setModel(SpellCheckerModel model) {
		this.model = model;
	}


    @FXML
    void doClear(ActionEvent event) {
    	this.txtiInserisci.clear();
    	this.txtWrong.clear();

    }

    @FXML
    void doSpell(ActionEvent event) {
    	long time1 = System.nanoTime();
    	try {
    	String language = this.comboBox.getValue();
    	List <String> sbagliate = model.nuovaTrad(this.txtiInserisci.getText(), language);
    	for (String s : sbagliate) {
    		txtWrong.appendText(s+"\n");
    	}
    	long time2 = System.nanoTime();
    	double time = (double)(time2 -time1)/1000000000;
    	this.errNumb.setText("The text contains "+sbagliate.size()+" errors");
    	this.timeLabel.setText("Spell checked completed in "+time+" seconds");

    } catch (NullPointerException e) {
		this.txtWrong.appendText("Devi selezionare una lingua!\n");
    }
    }

    @FXML
    void initialize() {
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtiInserisci != null : "fx:id=\"txtiInserisci\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert checkButton != null : "fx:id=\"checkButton\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert errNumb != null : "fx:id=\"errNumb\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert timeLabel != null : "fx:id=\"timeLabel\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        
        comboBox.getItems().addAll("Italian", "English");
    }
}
