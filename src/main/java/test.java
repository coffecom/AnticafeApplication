import DAL.Entity.AnticafeEntity;
import DAL.HibernateSessionFactory;
import Service.Implementations.EntityService;
import Service.Interfaces.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class test {
    public static void main(String[] args){
        Service<AnticafeEntity> service = new EntityService<>(HibernateSessionFactory.getSessionFactory(), AnticafeEntity.class);
        for(AnticafeEntity entity: service.getAll()){
            System.out.println(entity.getAddressOfCafe());
        }
        HibernateSessionFactory.closeSessionFactory();
    }
}
