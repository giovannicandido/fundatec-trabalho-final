package br.org.fundatec.tfinal.tfinal.service;

public interface CrudService<T> {
    T create(T entity);

    T findById(Long idEndereco);

    T update(T entity);
}
