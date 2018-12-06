import DAL.Entity.AnticafeEntity;
import DAL.HibernateSessionFactory;
import org.hibernate.Session;

public class App {
    public static void main(String[] args){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        AnticafeEntity anticafeEntity = new AnticafeEntity();
        anticafeEntity.setAddressOfCafe("Улица Пушкина дом Колотушкина 17");
        anticafeEntity.setNumberOfTables(25);
        anticafeEntity.setWorkingHours("10:00-21:00");
        session.save(anticafeEntity);
        session.getTransaction().commit();
        session.close();
        HibernateSessionFactory.closeSessionFactory();
    }
}
