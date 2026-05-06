package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe di testing
 * 
 * @author Davide De Prosperis, Matricola: 575620
 * @author Gabriele Crescenzi, Matricola: 628793
 * @see FabbricaDiComandiFisarmonica
 * @version 2.0
 */

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandi fabbrica;

	@BeforeEach
	public void setUp() {
		this.fabbrica = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testCostruisciComando_SenzaParametro() {
		Comando c = this.fabbrica.costruisciComando("aiuto");
		assertEquals("aiuto", c.getNome());
		assertNull(c.getParametro());
	}

	@Test
	public void testCostruisciComando_ConParametro() {
		Comando c = this.fabbrica.costruisciComando("vai nord");
		assertEquals("vai", c.getNome());
		assertEquals("nord", c.getParametro());
	}

	@Test
	public void testCostruisciComando_NonValido() {
		Comando c = this.fabbrica.costruisciComando("corri");
		assertEquals("non valido", c.getNome());
	}
}