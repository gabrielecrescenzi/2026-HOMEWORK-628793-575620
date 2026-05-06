package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

/**
 * Classe dedicata al comando "aiuto"
 * 
 * @author Davide De Prosperis, Matricola: 575620
 * @author Gabriele Crescenzi, Matricola: 628793
 * @version 2.0
 * @see Comando
 * @see Partita
 * @see IO
 */

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "guarda" };

	@Override
	public void esegui(Partita partita, IO io) {
		for (int i = 0; i < elencoComandi.length; i++) {
			io.mostraMessaggio(elencoComandi[i] + " ");
		}
		io.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return "aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
