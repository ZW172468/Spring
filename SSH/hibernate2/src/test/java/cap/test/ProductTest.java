package cap.test;


import cap.bean.Product;
import org.junit.Before;
import org.junit.Test;

import javax.security.auth.login.Configuration;
import javax.transaction.Transaction;

public class ProductTest {
    private SessionFactory sessionFactory;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();

    }

    @Test
    public void testSave() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Product product = new Product();
        product.setStock(12);
        product.setPrice(33.0);
        product.setName("jsp ");
        product.setSerialNumber("hhhhh");
        session.save(product);
        tx.commit();
        session.close();

    }

    @Test
    public void testFind() {
        testSave();
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, 1);
        System.out.println(product.getName() + ":" + product.getSerialNumber());
        session.close();
    }
}
