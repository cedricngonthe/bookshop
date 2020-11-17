package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import main.Book;
import main.Customer;
import main.Shop;

public class ShopTest {
	Shop amazon = new Shop(100, "Amazon");
	Shop alibaba = new Shop(150,"Alibaba");
	Customer cedric = new Customer("cedric", 15);
	Book Tom = new Book("Tom", 14, "Adventure", 130, "978-3608963762");
	Book Tomo = new Book("Tomo", 15, "Adventure", 100, " 978-3442267747");
	Book Tomy = new Book("Tomy", 12, "Toto", 180, " 978-758245159");
	Book Tomi = new Book("Tom2", 19, "Adventure", 130, "978-3841335180");
	Book Toma = new Book("Toma", 15, "toto", 100, "978-3442267819");

	@Test
	public void addBuecherTest() {
		
		amazon.addBook_shop(Tom);
		amazon.addBook_shop(Tomo);
		amazon.addBook_shop(Tomy);
		amazon.addBook_shop(Tom);
		amazon.addBook_shop(Toma);
		amazon.addBook_shop(Tomi);
		assertEquals(2, amazon.getS_buecher().size(), "Shop buecher anzahl stimmt nicht");
		assertEquals("Tom", amazon.getS_buecher().get(0).getTitel(), "Titel passt nicht");
	}
	
	@Test
	public void isbn13PruefenTest() {
		boolean res1 = amazon.isbn13Pruefen(Tomo.getIsbn13());
		boolean res2 = amazon.isbn13Pruefen(Tomi.getIsbn13());
		
		assertEquals(false, res1);
		assertEquals(true, res2);
	}
	
	@Test
	public void buechersuchenTest() {
		amazon.addBook_shop(Tom);
		boolean res = amazon.buechersuchen("Tom", "Adventure");
		boolean res2 = amazon.buechersuchen("Tom2", "Adventure");
		assertEquals(true, res, "Buch müsste vorhanden sein");
		assertEquals(false, res2, "Buch müsste nicht vorhanden sein");
	}
	
	
	
	
}
