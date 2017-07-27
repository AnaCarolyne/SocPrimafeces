package bean;



import DAO.EntregaKitDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Entregakit;



@ManagedBean
@SessionScoped
public class EntregaKitBean extends CrudBean<Entregakit, EntregaKitDAO> {

    private EntregaKitDAO entregaKitDAO;
    
    @Override
    public EntregaKitDAO getDao() {
        if(entregaKitDAO == null){
            entregaKitDAO = new EntregaKitDAO();
        }
        return entregaKitDAO;
    }

    @Override
    public Entregakit criarNovaEntidade() {
        return new Entregakit();
    }

}

