package bean;


import DAO.AlimentoDAO;
import modelo.Alimento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AlimentoBean extends CrudBean<Alimento, AlimentoDAO> {

    private AlimentoDAO alimentoDAO;
    
    @Override
    public AlimentoDAO getDao() {
        if(alimentoDAO == null){
            alimentoDAO = new AlimentoDAO();
        }
        return alimentoDAO;
    }

    @Override
    public Alimento criarNovaEntidade() {
        return new Alimento();
    }

}
