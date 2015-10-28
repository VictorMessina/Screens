package com.br.projetoLP2.model.DAO;

import java.util.List;

/**
 *
 * @author 31449530
 */
public interface GenericDAO<T> {

    public boolean insert(T t);

    public List<T> read();

    public boolean update(T t);

    public boolean delete(T t);
}
