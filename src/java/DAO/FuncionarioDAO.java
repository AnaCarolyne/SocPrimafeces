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
import modelo.Funcionarios;


/**
 *
 * @author Juliana
 */
public class FuncionarioDAO implements CrudDAO<Funcionarios>{
      private static FuncionarioDAO instancia = new FuncionarioDAO();

    public static FuncionarioDAO obterInstancia() {
        return instancia;
    }

    public FuncionarioDAO() {
    }

      @Override
      public List<Funcionarios> buscar() {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Funcionarios> funcionarios = null;
        try {
            tx.begin();
            TypedQuery<Funcionarios> query = em.createQuery("select f from Funcionarios f", Funcionarios.class);
           funcionarios = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return funcionarios;

    }
public Funcionarios getFuncionario(int idFuncionarios) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Funcionarios funcionario = new Funcionarios();
        try {
            tx.begin();
            funcionario = em.find(Funcionarios.class, idFuncionarios);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return funcionario;
    }
      @Override
      public void salvar(Funcionarios funcionario) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(funcionario);
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
    public void excluir(Funcionarios funcionario) {

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Funcionarios.class, funcionario.getIdFuncionarios()));
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
    