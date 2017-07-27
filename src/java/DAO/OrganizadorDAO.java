package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Organizador;

public class OrganizadorDAO implements CrudDAO<Organizador>{

    private static final OrganizadorDAO instancia = new OrganizadorDAO();

    public static OrganizadorDAO obterInstancia() {
        return instancia;
    }

    public OrganizadorDAO() {
    }

    @Override
    public List<Organizador> buscar() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Organizador> organizadores = null;
        try {
            tx.begin();
            TypedQuery<Organizador> query = em.createQuery("select o from Organizador o", Organizador.class);
            organizadores = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return organizadores;

    }

    public Organizador getOrganizador(int idOrganizador) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Organizador organizador = new Organizador();
        try {
            tx.begin();
            organizador = em.find(Organizador.class, idOrganizador);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return organizador;
    }

    @Override
    public void salvar(Organizador organizador) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(organizador);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }


    @Override
    public void excluir(Organizador organizador) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Organizador.class, organizador.getIdOrganizador()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

}
