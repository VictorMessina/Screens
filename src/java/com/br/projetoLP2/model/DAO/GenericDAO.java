package com.br.projetoLP2.model.DAO;

import java.util.List;

/**
 *
 * @author Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
 */
public interface GenericDAO<T> {

    public boolean insert(T t);

    public List<T> read();

    public boolean update(T t);

    public boolean delete(T t);
}
