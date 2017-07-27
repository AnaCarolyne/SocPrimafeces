package bean;




import DAO.ObjetoKitDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Objetokit;




@ManagedBean
@SessionScoped
public class ObjetoKitBean extends CrudBean<Objetokit, ObjetoKitDAO> {

    private ObjetoKitDAO objetoKitDAO;
    
    @Override
    public ObjetoKitDAO getDao() {
        if(objetoKitDAO == null){
            objetoKitDAO = new ObjetoKitDAO();
        }
        return objetoKitDAO;
    }

    @Override
    public Objetokit criarNovaEntidade() {
        return new Objetokit();
    }

}

