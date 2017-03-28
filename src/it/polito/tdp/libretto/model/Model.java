package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Esame> esami;
	
	public Model() {
		this.esami = new ArrayList<Esame>();
	}
	
	/**
	 * aggiunge un nuovo esame all'elenco esami presenti,
	 * verificando che non ci sia già
	 * @param e
	 */
	public void addEsame(Esame e){
		if(!esami.contains(e)){
		esami.add(e);
		} else {
			throw new IllegalStateException("Codice esame già presente");
		}
	}
	
	/**
	 * ricerca l'esame tramite il codice.
	 * Se non c'è restituisce null
	 * @param codice
	 * @return
	 */
	public Esame trovaEsame(String codice){
		int pos = esami.indexOf(new Esame(codice,null,null));
	    if(pos==-1){
	    	return null;
	    } else {
	    	return esami.get(pos);
	    }
	}
	
	
}
