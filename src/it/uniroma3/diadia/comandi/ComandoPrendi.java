package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.IO;

/**
 * Classe dedicata al comando "prendi". Permette al giocatore di raccogliere un
 * attrezzo dalla stanza e riporlo nella propria borsa.
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

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;

	/**
	 * Cerca di prendere un determinato attrezzo, eventualmente rimuovendolo dalla
	 * stanza e aggiungendolo alla borsa.
	 * 
	 * @param partita La partita in corso da cui estrarre stanza e giocatore
	 * @param io      interfaccia dedicata alla console
	 */
	@Override
	public void esegui(Partita partita, IO io) {
		if (this.nomeAttrezzo == null) {
			io.mostraMessaggio("Cosa vuoi prendere?");
			return;
		}

		Stanza stanzaAttuale = partita.getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();

		if (stanzaAttuale.hasAttrezzo(this.nomeAttrezzo)) {
			Attrezzo attrezzoDaPrendere = stanzaAttuale.getAttrezzo(this.nomeAttrezzo);

			if (borsa.addAttrezzo(attrezzoDaPrendere)) {
				stanzaAttuale.removeAttrezzo(attrezzoDaPrendere);
				io.mostraMessaggio("L'attrezzo '" + this.nomeAttrezzo + "' e' stato spostato nella borsa :)");
			} else {
				io.mostraMessaggio("L'attrezzo è troppo pesante e non è stato possibile aggiungerlo alla borsa :(");
			}
		} else {
			io.mostraMessaggio("Attrezzo non presente nella stanza :(");
		}

		io.mostraMessaggio(stanzaAttuale.toString());
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}