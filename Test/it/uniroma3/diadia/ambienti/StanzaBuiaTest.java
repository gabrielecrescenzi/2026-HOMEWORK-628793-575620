package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe di testing per StanzaBuia
 * 
 * @author Davide De Prosperis, Matricola: 575620
 * @author Gabriele Crescenzi, Matricola: 628793
 * @see StanzaBuia
 * @version 2.0
 */
public class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo lanterna;

	/**
	 * Imposta l'ambiente di test creando una StanzaBuia e l'attrezzo luminoso.
	 */
	@BeforeEach
	public void setUp() {
		this.stanza = new StanzaBuia("Cantina", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 1);
	}

	/**
	 * Verifica che la stanza restituisca il messaggio di buio 
	 * quando l'attrezzo luminoso non e' presente.
	 */
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		assertEquals("qui c'è un buio pesto", this.stanza.getDescrizione());
	}

	/**
	 * Verifica che la stanza restituisca la descrizione normale 
	 * quando l'attrezzo luminoso viene posato al suo interno.
	 */
	@Test
	public void testGetDescrizioneConAttrezzo() {
		this.stanza.addAttrezzo(this.lanterna);
		assertNotEquals("qui c'è un buio pesto", this.stanza.getDescrizione());
		assertTrue(this.stanza.getDescrizione().contains("Cantina"));
	}
}