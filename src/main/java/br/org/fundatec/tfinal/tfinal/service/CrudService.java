package br.org.fundatec.tfinal.tfinal.service;

public interface CrudService<T> {
    void create(T entity);

    T findById(Long idEndereco);
}
