import DAL.EntityAnticafe;
import DAL.HibernateSessionFactory;
import org.hibernate.Session;

public class App {
    public static void main(String[] args){
        //Access access = new Access();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        EntityAnticafe anticafeEntity = new EntityAnticafe();
        anticafeEntity.setAddressOfCafe("Улица Пушкина дом Колотушкина 17");
        anticafeEntity.setNumberOfTables(25);
        anticafeEntity.setWorkingHours("10:00-21:00");
        session.save(anticafeEntity);
        session.getTransaction().commit();
        session.close();
        HibernateSessionFactory.shutdown();
    }
}
