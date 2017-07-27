/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Alimento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
/**
 *
 * @author Juliana
 */
public class AlimentoDAO implements CrudDAO<Alimento>{

    private static AlimentoDAO instancia = new AlimentoDAO();

    public static AlimentoDAO obterInstancia() {
        return instancia;
    }

    public AlimentoDAO() {
    }

    @Override
    public List<Alimento> buscar() {//busca em todas as classes DAO

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Alimento> alimentos = null;
        try {
            tx.begin();
            TypedQuery<Alimento> query = em.createQuery("select a from Alimento a", Alimento.class);
            alimentos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return alimentos;

    }

    public Alimento getAlimento(int idAlimento) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Alimento alimento = new Alimento();
        try {
            tx.begin();
            alimento = em.find(Alimento.class, idAlimento);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return alimento;
    }

    @Override
    public void salvar(Alimento alimento) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(alimento);
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
    public void excluir(Alimento alimento) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Alimento.class, alimento.getIdAlimento()));
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
