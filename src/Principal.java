import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.SaveOrUpdateEvent;

import com.divingWeb.elememts.Producto;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Producto nuevoProducto = new Producto();

		long id = (Long) session.save(nuevoProducto);

		transaction.commit();
		session.close();
	}

}
