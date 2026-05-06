package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;

/**
 * Classe di testing
 * 
 * @author Davide De Prosperis, Matricola: 575620
 * @author Gabriele Crescenzi, Matricola: 628793
 * @see ComandoPosa
 * @version 2.0
 */

public class ComandoPosaTest {

	private Partita partita;
	private ComandoPosa comando;
	private IO io;

	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		this.comando = new ComandoPosa();
		this.io = new IOSimulator(new String[0]);
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("martello", 1));
	}

	@Test
	public void testPosaAttrezzoPresente() {
		this.comando.setParametro("martello");
		this.comando.esegui(this.partita, this.io);

		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("martello"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("martello"));
	}

	@Test
	public void testPosaAttrezzoAssente() {
		this.comando.setParametro("spada");
		this.comando.esegui(this.partita, this.io);

		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
	}
}