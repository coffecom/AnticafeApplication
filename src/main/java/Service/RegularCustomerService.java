package Service;

import DAL.Entity.AnticafeEntity;
import DAL.Entity.RegularCustomersEntity;

public interface RegularCustomerService extends Service<RegularCustomersEntity> {
     int getValueOfChildren();
}
