package main;

public class Book {
	private String titel;
	private double preis;
	private String genre;
	private int seitenzahlen;
	private int menge;
	private String isbn13;

	// Klassenkonstruktor (für die intialisierung)
	public Book(String titel, double preis, String genre, int seitenzahlen, String isbn13) {
		this.titel = titel;
		this.preis = preis;
		this.genre = genre;
		this.seitenzahlen = seitenzahlen;
		this.isbn13 = isbn13;
		this.menge = 1;

	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getSeitenzahlen() {
		return seitenzahlen;
	}

	public void setSeitenzahlen(int seitenzahlen) {
		this.seitenzahlen = seitenzahlen;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	
}
