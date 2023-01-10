package br.org.fundatec.tfinal.tfinal.service;

/**
 * Interface para padronizar todas as operações de CRUD da camada service
 * @param <T> Tipo de Item a persistir, seja o DTO ou a Entidade
 */
public interface CrudService<T> {

    /**
     * Cria um novo item no banco de dados
     * @param entity Entidade a ser persistida
     * @return A entidade persistida no banco
     */
    T create(T entity);

    /**
     * Procura uma entidade pelo ID
     * @param id Id a ser procurado
     * @return A entidade do banco ou null se não encontrar
     */
    T findById(Long id);

    /**
     * Atualiza uma entidade no banco
     * @param entity Entidade a ser atualizada, deve possuir o ID
     * @return A entidade que foi atualizada
     */
    T update(T entity);
}
