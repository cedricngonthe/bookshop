package main;

import java.util.ArrayList;

public class Shop {
	private double umsatz;
	private ArrayList<Book> s_buecher = new ArrayList<>();
	private String name;

	// Klassenkonstruktor (für die intialisierung)
	public Shop(double umsatz, String name) {
		this.umsatz = umsatz;
		this.name = name;

	}

	public double getUmsatz() {
		return umsatz;
	}

	public void setUmsatz(double umsatz) {
		this.umsatz = umsatz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getS_buecher() {
		return s_buecher;
	}

	public void setS_buecher(ArrayList<Book> s_buecher) {
		this.s_buecher = s_buecher;
	}

	/*
	 * Die funktion gibt er den Platz (index) wo das Book gespeichert ist damit kann
	 * mann die benutzen um ein book zu löschen
	 */
	public int getIndexBook(String titel, String genre) {
		int indexBook = 0;
		try {
			for (int i = 0; i < s_buecher.size(); i++) {

				if (s_buecher.get(i).getTitel() == titel && s_buecher.get(i).getGenre() == genre) {
					indexBook = i;

				}
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return indexBook;

	}

	/*
	 * Die Funktion fügt ein neues Buch in shop hinzu ohne diplikate hier hat die
	 * klasse book eine neue Attribut "Menge" und wenn ein neues book hinzufügen
	 * wird prüft er erstmal ,ob das book schon da ist wenn ja erhöht er dann nur
	 * die Menge wenn nicht fügt er das Buch in shop hinzu
	 */
	public void addBook_shop(Book book) {
		boolean hinzugefuegt = false;
		for (int i = 0; i < s_buecher.size(); i++) {
			if (s_buecher.get(i).getTitel().equals(book.getTitel()) == true
					&& s_buecher.get(i).getGenre().equals(book.getGenre()) == true) {
				s_buecher.get(i).setMenge(s_buecher.get(i).getMenge() + 1);
				hinzugefuegt = true;
				break;
			}
		}
		if (!hinzugefuegt) {
			if (isbn13Pruefen(book.getIsbn13())) {
				s_buecher.add(book);
			} else {
				System.out.println("ISBN-13 von Buch " + book.getTitel() + " nicht gültig");
			}
		}
	}

	// Die Funktion überprüfen, ob die ISBN_13 gütig ist
	public boolean isbn13Pruefen(String s) {
		if (s.length() != 14 || !(s.charAt(3) == '-')) {
			return false;
		}
		try {
			String tmp = s.replace("-", "");
			int total = 0;
			int vielfach10 = 0;
			for (int i = 0; i < 12; i++) {
				int num = Integer.parseInt(String.valueOf(tmp.charAt(i)));
				total = i % 2 == 0 ? total + (num * 1) : total + (num * 3); // 83
			}

			vielfach10 = total;
			while (vielfach10 % 10 != 0) {
				vielfach10++;
			}

			if (Integer.parseInt(String.valueOf(tmp.charAt(12))) == (vielfach10 - total)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	// Die Funktion löscht ein neues Buch in Shop
	public void removeBook_shop(int indexbook) {
		if (s_buecher.get(indexbook).getMenge() > 1) {
			s_buecher.get(indexbook).setMenge(s_buecher.get(indexbook).getMenge() - 1);
		} else {
			s_buecher.remove(indexbook);
		}
	}

	// Die funktion sucht ein Buch in ein bestimmter Shop
	public boolean buechersuchen(String titel, String genre) {
		boolean res = false;

		try {
			for (int i = 0; i < s_buecher.size(); i++) {

				if (s_buecher.get(i).getTitel() == titel && s_buecher.get(i).getGenre() == genre) {

					res = true;
				}
			}

		} catch (Exception e) {
			System.out.println("Kein Artikel");
		}
		return res;
	}

	// Die Funktion gibt alle Bücher der Shop zurück
	public void getAllS_buecher() {
		for (Book element : s_buecher) {
			System.out.println(element.getTitel() + "                " + element.getGenre() + "                   "
					+ element.getMenge());
		}
	}

	// Die Funktion gibt ein Book der Shop zurück
	public void getEinS_buecher(Book booktitel) {

		System.out.println(this.name + "                " + booktitel.getTitel() + "                "
				+ booktitel.getGenre() + "                   " + booktitel.getPreis() + "€");

	}

	// Die Funktion sortiert die Bücher eines bestimmten Genres
	public void filternBuechern(String genre) {
		System.out.println("TITEL" + "         ----------           " + "PREIS");
		System.out.println();
		for (int i = 0; i < s_buecher.size(); i++) {
			if (s_buecher.get(i).getGenre() == genre) {
				System.out.println(s_buecher.get(i).getTitel() + "          ----------        "
						+ s_buecher.get(i).getPreis() + "€");
			}
		}
	}

}
