package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.IO;

/**
 * Classe dedicata al comando "posa". Permette al giocatore di togliere un
 * attrezzo dalla borsa e posarlo nella stanza corrente.
 * 
 * @author Davide De Prosperis, Matricola: 575620
 * @author Gabriele Crescenzi, Matricola: 628793
 * @version 2.0
 * @see Partita
 * @see Comando
 * @see Stanza
 * @see Attrezzo
 * @see Borsa
 * @see IO
 */
public class ComandoPosa implements Comando {
	private String nomeAttrezzo;

	/**
	 * Cerca di posare un oggetto nella stanza, eventualente rimuovendolo dalla
	 * borsa e aggiungendolo alla stanza.
	 * 
	 * @param partita La partita in corso da cui estrarre stanza e giocatore
	 * @param io     interfaccia dedicata alla console
	 */

	@Override
	public void esegui(Partita partita, IO io) {
		if (this.nomeAttrezzo == null) {
			io.mostraMessaggio("Cosa vuoi posare?");
			return;
		}

		Stanza stanzaAttuale = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();

		if (borsa.hasAttrezzo(this.nomeAttrezzo)) {
			Attrezzo attrezzoDaPosare = borsa.getAttrezzo(this.nomeAttrezzo);
			if (stanzaAttuale.addAttrezzo(attrezzoDaPosare)) {
				borsa.removeAttrezzo(this.nomeAttrezzo);
				io.mostraMessaggio("L'attrezzo '" + this.nomeAttrezzo + "' e' stato posato nella stanza :)");
			} else {
				io.mostraMessaggio("La stanza corrente ha troppi attrezzi, non è stato possibile posarlo :(");
			}
		} else {
			io.mostraMessaggio("Attrezzo non presente nella borsa :(");
		}

		io.mostraMessaggio(stanzaAttuale.toString());
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}