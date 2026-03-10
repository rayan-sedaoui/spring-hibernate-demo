import dao.IDao;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = (IDao<Product>) context.getBean("productDaoImpl");

        Product product = new Product();
        product.setName("Ordinateur Portable");
        product.setPrice(1200.0);

        productDao.create(product);

        System.out.println("Produit sauvegardé : " + product.getName());

        ((AnnotationConfigApplicationContext) context).close();
    }
}