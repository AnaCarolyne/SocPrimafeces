package bean;


import DAO.CorridaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Corrida;


@ManagedBean
@SessionScoped
public class CorridaBean extends CrudBean<Corrida, CorridaDAO> {

    private CorridaDAO corridaDAO;
    
    @Override
    public CorridaDAO getDao() {
        if(corridaDAO == null){
            corridaDAO = new CorridaDAO();
        }
        return corridaDAO;
    }

    @Override
    public Corrida criarNovaEntidade() {
        return new Corrida();
    }

}

