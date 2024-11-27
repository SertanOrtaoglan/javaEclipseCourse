package oopWithNLayeredApp;

import oopWithNLayeredApp.business.ProductManager;
import oopWithNLayeredApp.core.logging.DatabaseLogger;
import oopWithNLayeredApp.core.logging.FileLogger;
import oopWithNLayeredApp.core.logging.Logger;
//import oopWithNLayeredApp.core.logging.MailLogger;
import oopWithNLayeredApp.dataAccess.HibernateProductDao;
//import oopWithNLayeredApp.dataAccess.JdbcProductDao;
import oopWithNLayeredApp.entities.Product;

public class Main {

	public static void main(String[] args) throws Exception {
		Product product1 = new Product(1, "IPhone Xr", 9000);
		
		/*(Veritabanına ekleme)
		ProductManager productManager = new ProductManager(new JdbcProductDao());
		productManager.add(product1);
		*/
		
		/*(Sistemi hibernate geçirmek istersek;)
		ProductManager productManager = new ProductManager(new HibernateProductDao());
		productManager.add(product1);
		*/
		
		//Son kısım(Veritabanına ekleme ve loglama işleminin beraber yapılması)
		Logger[] loggers = {new DatabaseLogger(), new FileLogger()};
		
		
		ProductManager productManager = new ProductManager(new HibernateProductDao(), loggers);
		productManager.add(product1);
		
		

	}

}
