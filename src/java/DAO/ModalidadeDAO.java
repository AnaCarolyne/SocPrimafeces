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
import modelo.Modalidade;



/**
 *
 * @author Juliana
 */
public class ModalidadeDAO implements CrudDAO<Modalidade>{
    private static ModalidadeDAO instancia = new ModalidadeDAO();

    public static ModalidadeDAO obterInstancia() {
        return instancia;
    }

    public ModalidadeDAO() {
    }

    @Override
    public List<Modalidade> buscar() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Modalidade> modalidades = null;
        try {
            tx.begin();
            TypedQuery<Modalidade> query = em.createQuery("select m from Modalidade m", Modalidade.class);
            modalidades = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return modalidades;

    }
     public Modalidade getModalidade(int idModalidade) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Modalidade modalidade = new Modalidade();
        try {
            tx.begin();
            modalidade = em.find(Modalidade.class, idModalidade);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return modalidade;
    }

    @Override
    public void salvar(Modalidade modalidade) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(modalidade);
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



    public void excluir(Modalidade modalidade) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Modalidade.class, modalidade.getIdModalidade()));
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
