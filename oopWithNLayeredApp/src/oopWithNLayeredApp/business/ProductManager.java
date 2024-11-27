package oopWithNLayeredApp.business;


import oopWithNLayeredApp.core.logging.Logger;
//import oopWithNLayeredApp.dataAccess.HibernateProductDao;
//import oopWithNLayeredApp.dataAccess.JdbcProductDao;
import oopWithNLayeredApp.dataAccess.ProductDao;
import oopWithNLayeredApp.entities.Product;

public class ProductManager {
	
	private ProductDao productDao;
	private Logger[] loggers;
	
	
	public ProductManager(ProductDao productDao, Logger[] loggers) {
		this.productDao = productDao;
		this.loggers = loggers;
	}


	public void add(Product product) throws Exception {
		//iş kuralları buraya yazılır!
		if(product.getUnitPrice()<10) {
			throw new Exception("Ürün fiyatı 10 dan küçük olamaz");
		}
		/*(düz class ile yaparsak)
		JdbcProductDao productDao = new JdbcProductDao();
		productDao.add(product);
		*/
		/*
		HibernateProductDao productDao = new HibernateProductDao();
		productDao.add(product);
		*/
		
		
		/*(interface ile yaparsak)
		ProductDao productDao = new HibernateProductDao();
		productDao.add(product);
		*/
		/*
		ProductDao productDao = new JdbcProductDao();
		productDao.add(product);
		*/
		
		productDao.add(product);
		
		//Gönderilen Logger array'ini for-each'le dolaşıyoruz. Mesela ilk olarak 2 tane Logger türünde class gönderdiğimizi düşünelim. [DatabaseLogger, FileLogger]
		for (Logger logger : loggers) {
			logger.log(product.getName());
		}
		
	}

}
