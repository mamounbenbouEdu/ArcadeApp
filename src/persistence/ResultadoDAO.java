package persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ResultadoDAO {

    public static void guardar(Resultado resultado) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(resultado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
