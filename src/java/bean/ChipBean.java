package bean;


import DAO.ChipDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Chip;

@ManagedBean
@SessionScoped
public class ChipBean extends CrudBean<Chip, ChipDAO> {

    private ChipDAO chipDAO;
    
    @Override
    public ChipDAO getDao() {
        if(chipDAO == null){
            chipDAO = new ChipDAO();
        }
        return chipDAO;
    }

    @Override
    public Chip criarNovaEntidade() {
        return new Chip();
    }

}

