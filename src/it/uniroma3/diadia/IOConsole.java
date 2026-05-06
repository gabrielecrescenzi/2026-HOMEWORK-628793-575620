package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * Gestisce l'I/O tramite console.
 * 
 * @author Davide De Prosperis, Matricola: 575620
 * @author Gabriele Crescenzi, Matricola: 628793
 * @version 2.0
 */

public class IOConsole implements IO {
	private Scanner scannerDiLinee;

	public IOConsole() {
		this.scannerDiLinee = new Scanner(System.in);
	}

	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}

	@Override
	public String leggiRiga() {
		return scannerDiLinee.nextLine();
	}

}