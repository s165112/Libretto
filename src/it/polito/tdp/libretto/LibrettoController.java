package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.LibrettoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
//	LibrettoModel model = new LibrettoModel(); // sbagliato

	LibrettoModel model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtTitolo;

    @FXML
    private TextField txtDocente;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResutl;

    @FXML
    void doCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	if(codice.length()<5){
    		txtResutl.appendText("Codice non valido\n");
    		return;
    	}
    	Esame e = model.trovaEsame(codice);
    	if(e==null){
    		txtResutl.appendText("Codice esame "+codice+" non trovato\n");
    	}else{
    		txtResutl.appendText("Codice esame "+codice+" trovato\n");
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}
    	
    	
    }

    @FXML
    void doInserisci(ActionEvent event) {
    	
    	// recupera i dati dalla vista
    	String codice = txtCodice.getText().toUpperCase();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	// verifica la validità dei dati
    	if(codice.length()<5 || titolo.length()==0 || docente.length() ==0){
    		txtResutl.appendText("Dati esami insufficienti\n");
    		return;
    	}
    	
    	// chiedi al model di effettuare l'operazione 
    	Esame e = new Esame(codice, titolo, docente);
    	boolean result = model.addEsame(e);
    	
    	// aggiorna la vista con risultato operazione
    	if(result){
    		txtResutl.appendText("Esame aggiunto correttamente\n");
    	}else{
    		txtResutl.appendText("Esame NON AGGIUNTO (codice duplicato)\n");
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtResutl != null : "fx:id=\"txtResutl\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	/**
	 * @return the model
	 */
	public LibrettoModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(LibrettoModel model) {
		this.model = model;
	}
}
