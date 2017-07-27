package bean;



import DAO.EntregaKitDAO;
import DAO.LoteDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Entregakit;
import modelo.Lote;



@ManagedBean
@SessionScoped
public class LoteBean extends CrudBean<Lote, LoteDAO> {

    private LoteDAO loteDAO;
    
    @Override
    public LoteDAO getDao() {
        if(loteDAO == null){
            loteDAO = new LoteDAO();
        }
        return loteDAO;
    }

    @Override
    public Lote criarNovaEntidade() {
        return new Lote();
    }

}

