package br.univille.sportstock.service;

import java.util.List;

import br.univille.sportstock.entity.Produto;


public interface ProdutoService {
    List<Produto> getAll();

    void save(Produto produto);

    Produto findById(long id);

    void delete(long id);

   

}
