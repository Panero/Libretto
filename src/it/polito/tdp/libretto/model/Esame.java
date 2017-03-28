package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Oggetto semplice che contiene i dati relativi al 
 * singolo esame
 * 
 * POJO - plain old java object
 * 
 * dati privati
 * costruttore
 * get/set
 * metodi di servizio(toString, equals, hasCode)
 * 
 * @author Marcello Panero
 *
 */
public class Esame {

	private String codice;
	private String titolo;
	private String docente;
	
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento;
	
	/**
	 * Nuovo esame
	 * 
	 * @param codice dell'esame
	 * @param titolo del corso
	 * @param docente cognome e nome
	 */
	public Esame(String codice, String titolo, String docente) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		
		this.superato = false;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/**
	 * Restituisce il voto solo se l'esame � superato
	 * @return the voto
	 */
	public int getVoto() {
		if(this.superato){
		return voto;
		} else {
			throw new IllegalStateException("Esame" +this.codice+ "non ancora superato");
		}
	}

	/**
	 * @param voto the voto to set
	 */
	private void setVoto(int voto) {
		this.voto = voto;
	}

	/**Restituisce la data solo se l'esame � superato
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if(this.superato){
			return dataSuperamento;
			} else {
				throw new IllegalStateException("Esame" +this.codice+ "non ancora superato");
			}
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/**
	 * se l'esame non � ancora superato, lo considera
	 * superato inserendo il voto e data;
	 * se invece � gi� superato genera un errore
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data){
		
		if(!this.superato){
			//non ancore superato
			this.superato = true;
			this.voto = voto;
			this.dataSuperamento = data;
		} else {
			//gi� superato
			throw new IllegalStateException("Esame" +this.codice+ "gi� superato");
		}
		
	}
	
	
	
}
