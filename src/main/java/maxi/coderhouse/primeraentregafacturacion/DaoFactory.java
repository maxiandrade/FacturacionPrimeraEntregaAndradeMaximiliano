package maxi.coderhouse.primeraentregafacturacion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManagerFactory;

@Service
public class DaoFactory {
    private final SessionFactory sessionFactory;

// NO PUDE RESOLVER EL PORQUE ME DICE QUE NO TENGO EN USO EL AUTOWIRED 
// Y EL METODO SAVE Y SAVE OR UPDATE ME TIRA ERROR, QUE FUE DEPRECADA DESDE LA VERSION 6.

    @Autowired
    public DaoFactory(EntityManagerFactory factory){
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public void create(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
    }

    public void update(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
    }

    public Cliente getCliente (Cliente cliente) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Cliente clienteGuardado = session.get(Cliente.class,cliente.getId());
        session.getTransaction().commit();
        return clienteGuardado;
    }
}