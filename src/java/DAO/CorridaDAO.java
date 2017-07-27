/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Corrida;


/**
 *
 * @author Juliana
 */
public class CorridaDAO implements CrudDAO<Corrida> {
private static CorridaDAO instancia = new CorridaDAO();

    public static CorridaDAO obterInstancia() {
        return instancia;
    }

    public CorridaDAO() {
    }
@Override
   public List<Corrida> buscar() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Corrida> corridas = null;
        try {
            tx.begin();
            TypedQuery<Corrida> query = em.createQuery("select c from Corrida c", Corrida.class);
            corridas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return corridas;

    }
   public Corrida getCorrida(int idCorrida) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Corrida corrida = new Corrida();
        try {
            tx.begin();
            corrida = em.find(Corrida.class, idCorrida);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return corrida;
    }
@Override
   public void salvar(Corrida corrida) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(corrida);
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
    public void excluir(Corrida corrida) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Corrida.class, corrida.getIdCorrida()));
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