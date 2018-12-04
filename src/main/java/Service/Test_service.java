package Service;

import DAL.DAO.DAO;
import DAL.DAO.DAO_Anticafe;
import DAL.Entity.EntityAnticafe;

import java.util.List;

public class Test_service {
    DAO dao;

    public Test_service(DAO dao) {
        this.dao = dao;
    }

    public List<EntityAnticafe> getAll(){
        dao.openSession();
        List list = dao.getAll();
        dao.closeSession();
        return list;
    }


    public static void main(String[] args){
        Test_service test_service = new Test_service(new DAO_Anticafe());
        for(EntityAnticafe anticafe : test_service.getAll()){
            System.out.println(anticafe.getAddressOfCafe());
        }
    }
}
