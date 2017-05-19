package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe che gestisce 
 * @author francescaveltri
 *
 */

public class LibrettoModel {
	
	private List<Esame> esami; // è nulla
	
	/**
	 * Lasciare gli oggetti in modo coerente e inizializzati
	 */
	public LibrettoModel(){
		this.esami = new ArrayList<Esame>(); // inizializzo 
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami precedenti
	 * verificando che non ci sia già, eccezione da gestire
	 * @param e esame 
	 * @return true se l'ha inserito, false se esisteva già e quindi non possibile aggiungerlo
	 */
	public boolean addEsame(Esame e){
		if(!esami.contains(e)){
			esami.add(e);
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Ricerca se esiste un esame con un codice specificato
	 * Se esiste lo restituisce, altrimenti restituisce null
	 * @param codice codice dell'esame da ricercare
	 * @return l'esame trovato, oppure null se non trovato
	 */
	public Esame trovaEsame(String codice){
		int pos = esami.indexOf(new Esame(codice, "null","null"));
		if(pos==-1){
			return null;
		}else{
			return esami.get(pos);
		}
		
	}
	
	
}
