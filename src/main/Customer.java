package main;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private double konto;
	private ArrayList<Book> c_buecher = new ArrayList<>();

	// Klassenkonstruktor (für die intialisierung)
	public Customer(String name, double konto) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.konto = konto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getKonto() {
		return konto;
	}

	public void setKonto(double konto) {
		this.konto = konto;
	}

	// Die Funktion prüft, ob genug Geld auf dem Konto befindet
	public boolean geldAbbuchen(Shop shopname, Book booktitel) {
		double restgeld;
		double neuUmsatz = shopname.getUmsatz();
		if (this.konto >= booktitel.getPreis()) {

			restgeld = this.konto - booktitel.getPreis();
			neuUmsatz = neuUmsatz + booktitel.getPreis();
			setKonto(restgeld);
			shopname.setUmsatz(neuUmsatz);
			return true;
		} else {

			return false;
		}

	}

	/*
	 * Die Funktion ermöglicht den Kauf eines Buches. Sie überprüft, ob das Buch
	 * vorhanden ist und ob das Geld ausreicht
	 */
	public void buecherKaufen(Shop shopname, Book booktitel, String genre) {
		boolean isVorhanden = shopname.buechersuchen(booktitel.getTitel(), genre);
		try {
			if (isVorhanden && geldAbbuchen(shopname, booktitel)) {
				addBook_customer(booktitel);
				shopname.removeBook_shop(shopname.getIndexBook(booktitel.getTitel(), genre));
				System.out.println("Vielen Dank für den Einkauf");
			} else if (isVorhanden == false) {

				System.out.println("Fehler beim einkaufen keine Artikel zu verfügung");

			} else if (isVorhanden && geldAbbuchen(shopname, booktitel) == false) {

				System.out.println("keine Buchung möglich wenig Geld");

			}

		} catch (Exception e) {

			System.out.println("System Fehler ");
		}

	}

	// Die Funktion gibt zurück die bücher , die der kunde gekauft hat
	public void getC_buecher() {
		for (Book element : c_buecher) {
			System.out.println(element.getTitel() + " " + element.getGenre());
		}
	}

	// Die Funktion fügt ein neues Buch zu kunde hinzu
	public void addBook_customer(Book booktitel) {
		c_buecher.add(booktitel);
	}

	/*
	 * Die Funktion ermöglicht es, die Bücher in zwei verschiedenen Shop zu
	 * vergleichen und die Ähnlichkeiten und Unterschiede zurückzugeben
	 */
	public void buecherVergleichen(Shop shopname_1, Shop shopname_2) {
		ArrayList<Book> gemeinsameBuecher = new ArrayList<>();
		ArrayList<Book> shop1NichtImShop2 = new ArrayList<>();
		ArrayList<Book> shop2NichtImShop1 = new ArrayList<>();

		for (Book book : shopname_1.getS_buecher()) {
			if (shopname_2.buechersuchen(book.getTitel(), book.getGenre())) {
				gemeinsameBuecher.add(book);
			} else {
				shop1NichtImShop2.add(book);
			}
		}

		for (Book book : shopname_2.getS_buecher()) {
			if (!(shopname_1.buechersuchen(book.getTitel(), book.getGenre()))) {
				shop2NichtImShop1.add(book);
			}
		}

		if (shop1NichtImShop2.isEmpty() && shop2NichtImShop1.isEmpty()) {
			if (!gemeinsameBuecher.isEmpty()) {
				System.out.println("Shop " + shopname_1.getName() + " und Shop " + shopname_2.getName()
						+ " haben exact die gleiche Bücher");
			}
		} else {
			System.out.println("Shop " + shopname_1.getName() + " und Shop " + shopname_2.getName()
					+ " haben nicht exact die gleiche Bücher");
			if (!shop1NichtImShop2.isEmpty()) {
				System.out.println("Bücher vom Shop " + shopname_1.getName() + " die nicht im Shop "
						+ shopname_2.getName() + " vorhanden sind:");
				for (Book element : shop1NichtImShop2) {
					System.out.println(element.getTitel() + "                " + element.getGenre());

				}
			}
			if (!shop2NichtImShop1.isEmpty()) {
				System.out.println("Bücher vom Shop " + shopname_2.getName() + " die nicht im Shop "
						+ shopname_1.getName() + " vorhanden sind:");
				for (Book element : shop2NichtImShop1) {
					System.out.println(element.getTitel() + "                " + element.getGenre());
				}
			}
			if (!gemeinsameBuecher.isEmpty()) {
				System.out.println("Shop " + shopname_1.getName() + " und Shop " + shopname_2.getName()
						+ " haben folgende gemeinsame Bücher");
				for (Book element : gemeinsameBuecher) {
					System.out.println(element.getTitel() + "                " + element.getGenre());
				}
			}
		}
	}

}
