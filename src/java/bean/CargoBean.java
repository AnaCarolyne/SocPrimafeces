package bean;

import DAO.CargoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Cargo;

@ManagedBean
@SessionScoped
public class CargoBean extends CrudBean<Cargo, CargoDAO> {

    private CargoDAO cargoDAO;
    
    @Override
    public CargoDAO getDao() {
        if(cargoDAO == null){
            cargoDAO = new CargoDAO();
        }
        return cargoDAO;
    }

    @Override
    public Cargo criarNovaEntidade() {
        return new Cargo();
    }

}

