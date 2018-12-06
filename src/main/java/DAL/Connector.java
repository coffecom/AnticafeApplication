package DAL;

import org.hibernate.Session;

public abstract class Connector {

    protected Session currentSession;

    public Session openSession() {
        currentSession = HibernateSessionFactory.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openSessionWithTransaction() {
        currentSession = HibernateSessionFactory.getSessionFactory().openSession();
        currentSession.getTransaction();
        return currentSession;
    }

    public void closeSession() {
        currentSession.close();
        HibernateSessionFactory.closeSessionFactory();
    }

    public void closeSessionWithTransaction() {
        currentSession.getTransaction().commit();
        currentSession.close();
        HibernateSessionFactory.closeSessionFactory();
    }

    public Session getCurrentSession() {
        return currentSession;
    }
}
