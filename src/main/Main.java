package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------------------");
		Shop amazon = new Shop(100, "Amazon");
		Shop alibaba = new Shop(150,"Alibaba");
		Customer cedric = new Customer("cedric", 20);
		System.out.println("Umsatz");
		System.out.println(amazon.getUmsatz());
		System.out.println("-----------------------------------------------------------");
		Book Buch1 = new Book("Buch1", 14.99, "Adventure", 130, "978-3608963762");
		Book Buch2 = new Book("Buch2", 15.75, "Biography", 100, " 978-3442267747");
		Book Buch3 = new Book("Buch3", 12.00, "Comic", 180, " 978-758245159");
		Book Buch4 = new Book("Buch4", 19.99, "Adventure", 130, "978-3841335180");
		Book Buch5 = new Book("Buch5", 15.09, "Fantasy", 100, "978-3442267819");
		amazon.addBook_shop(Buch1);
		amazon.addBook_shop(Buch2);
		amazon.addBook_shop(Buch3);
		amazon.addBook_shop(Buch1);
		amazon.addBook_shop(Buch5);
		amazon.addBook_shop(Buch4);
		amazon.getAllS_buecher();
		System.out.println("-----------------------------------------------------------");
		alibaba.addBook_shop(Buch4);
		alibaba.addBook_shop(Buch5);
		alibaba.getAllS_buecher();
		System.out.println("-----------------------------------------------------------");
		
		cedric.buecherVergleichen(amazon, alibaba);
		System.out.println("-----------------------------------------------------------");
		amazon.filternBuechern("Adventure");
		System.out.println("-----------------------------------------------------------");
		cedric.buecherKaufen(amazon, Buch4, "Adventure");
		cedric.getKonto();
		cedric.getC_buecher();
		System.out.println("-----------------------------------------------------------");
		amazon.getAllS_buecher();
		System.out.println("-----------------------------------------------------------");
		System.out.println("Neue Umsatz");
		System.out.println(amazon.getUmsatz());
	}

}
