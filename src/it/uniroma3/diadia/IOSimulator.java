package it.uniroma3.diadia;

/**
 * Classe IOSimulator - implementazione di IO per i test di accettazione. Simula
 * un utente iniettando comandi predefiniti tramite un array e memorizzando i
 * messaggi stampati dal gioco per poterli verificare.
 * 
 * @author Davide De Prosperis, Matricola: 575620
 * @author Gabriele Crescenzi, Matricola: 628793
 * @see IO
 * @version 2.0
 */
public class IOSimulator implements IO {

	private String[] righeLette;
	private int indiceLettura;

	private String[] messaggiProdotti;
	private int indiceMessaggi;

	/**
	 * Costruisce un simulatore con un array di comandi da eseguire.
	 * 
	 * @param righeDaLeggere l'array dei comandi preimpostati
	 */
	public IOSimulator(String[] righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.indiceLettura = 0;
		this.messaggiProdotti = new String[100];
		this.indiceMessaggi = 0;
	}

	/**
	 * Legge il prossimo comando dall'array fornito al costruttore.
	 */

	@Override
	public String leggiRiga() {
		if (this.indiceLettura < this.righeLette.length) {
			String riga = this.righeLette[this.indiceLettura];
			this.indiceLettura++;
			return riga;
		}
		return null;
	}

	/**
	 * Memorizza un messaggio in modo da poterlo controllare nei test.
	 */

	@Override
	public void mostraMessaggio(String messaggio) {
		if (this.indiceMessaggi < this.messaggiProdotti.length) {
			this.messaggiProdotti[this.indiceMessaggi] = messaggio;
			this.indiceMessaggi++;
		}
	}

	/**
	 * Verifica se tra i messaggi stampati dal gioco ce n'e' uno che contiene la
	 * stringa passata come parametro.
	 * 
	 * @param messaggioDaCercare la stringa da cercare nei messaggi
	 * @return true se trovata, false altrimenti
	 */

	public boolean hasMessaggio(String messaggioDaCercare) {
		for (int i = 0; i < this.indiceMessaggi; i++) {
			if (this.messaggiProdotti[i].contains(messaggioDaCercare)) {
				return true;
			}
		}
		return false;
	}
}