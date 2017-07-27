package bean;



import DAO.AtletaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Atleta;

@ManagedBean
@SessionScoped
public class AtletaBean extends CrudBean<Atleta, AtletaDAO> {

    private AtletaDAO atletaDAO;
    
    @Override
    public AtletaDAO getDao() {
        if(atletaDAO == null){
            atletaDAO = new AtletaDAO();
        }
        return atletaDAO;
    }

    @Override
    public Atleta criarNovaEntidade() {
        return new Atleta();
    }

}
