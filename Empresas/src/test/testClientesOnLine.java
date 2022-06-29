package test;

import modelos.ImpleIDAOClientesOnLine;

public class testClientesOnLine {
	public static void main(String[] args) {
		
		boolean bol = new ImpleIDAOClientesOnLine().verificaSiExistePorID("VEN2");
		System.out.println(bol);
		
	}
}
