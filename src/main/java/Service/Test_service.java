package Service;

import DAL.DAO.interfaces.DAO;
import DAL.DAO.implementations.BoxWithGameDAOImplementation;
import DAL.Entity.BoxWithGameEntity;

import java.util.List;

public class Test_service {
    DAO dao;

    public Test_service(DAO dao) {
        this.dao = dao;
    }

    public List<BoxWithGameEntity> getAll(){
        dao.openSession();
        List list = dao.getAll();
        dao.closeSession();
        return list;
    }


    public static void main(String[] args){
        Test_service test_service = new Test_service(new BoxWithGameDAOImplementation());
        for(BoxWithGameEntity anticafe : test_service.getAll()){
            System.out.println(anticafe.getTitle());
            System.out.println(anticafe.getCondition());
            //System.out.println(anticafe.getId());
        }
    }
}
