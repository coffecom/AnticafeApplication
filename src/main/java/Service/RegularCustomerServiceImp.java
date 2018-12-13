package Service;

import DAL.DAO.DAO;
import DAL.Entity.RegularCustomersEntity;
import org.hibernate.SessionFactory;

public class RegularCustomerServiceImp extends EntityService<RegularCustomersEntity> implements RegularCustomerService {
    public RegularCustomerServiceImp(DAO<RegularCustomersEntity> dao) {
        super(dao);
    }

    public RegularCustomerServiceImp(SessionFactory sessionFactory, Class<RegularCustomersEntity> _class) {
        super(sessionFactory, _class);
    }

    public int getValueOfChildren(){
        int children = 0;
        for(RegularCustomersEntity entity: this.getAll()){
            if(entity.getAge() < 18)
                children++;
        }
        return children;
    }
}
