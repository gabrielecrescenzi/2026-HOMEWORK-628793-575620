package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

/**
 * Classe che modella un comando non riconosciuto dal gioco.
 * 
 * @author Davide De Prosperis, Matricola: 575620
 * @author Gabriele Crescenzi, Matricola: 628793
 * @version 2.0
 * @see Comando
 * @see Partita
 * @see IO
 */
public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Comando sconosciuto o non valido!");
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return "non valido";
	}

	@Override
	public String getParametro() {
		return null;
	}
}