/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import exception.ErroSistema;
import java.util.List;

/**
 *
 * @author Juliana
 * @param <E>
 */
public interface CrudDAO<E> {
    
    /**
     *
     * @param entidade
     * @throws ErroSistema
     */
    public void salvar(E entidade) throws ErroSistema;

    /**
     *
     * @param entidade
     * @throws ErroSistema
     */
    public void excluir(E entidade) throws ErroSistema;

    /**
     *
     * @return
     * @throws ErroSistema
     */
    public List<E> buscar() throws ErroSistema;
}
