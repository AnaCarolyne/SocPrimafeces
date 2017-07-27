/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Suprimento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juliana
 */
public class SuprimentoDAO implements CrudDAO<Suprimento>{

    private static final SuprimentoDAO instancia = new SuprimentoDAO();

    public static SuprimentoDAO obterInstancia() {
        return instancia;
    }

    public SuprimentoDAO() {
    }

    @Override
    public  List<Suprimento> buscar() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Suprimento> suprimentos = null;
        try {
            tx.begin();
            TypedQuery<Suprimento> query = em.createQuery("select s from Suprimento s", Suprimento.class);
            suprimentos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return suprimentos;

    }

    public static Suprimento getSuprimento(int idSuprimento) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Suprimento suprimento = new Suprimento();
        try {
            tx.begin();
            suprimento = em.find(Suprimento.class, idSuprimento);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return suprimento;
    }

    public  void salvar(Suprimento suprimento) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(suprimento);
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
    public  void excluir(Suprimento suprimento) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Suprimento.class, suprimento.getIdSuprimento()));
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
