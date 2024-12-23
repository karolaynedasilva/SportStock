package br.univille.sportstock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.univille.sportstock.entity.Produto;
import br.univille.sportstock.repository.ProdutoRepository;
import br.univille.sportstock.service.ProdutoService;

@Service
public class ProdutoServiceImpl
        implements ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;

    @Override
    public List<Produto> getAll() {
        return repositorio.findAll();
    }

    @Override
    public void save(Produto produto) {
        repositorio.save(produto);
    }

    @Override
    public Produto findById(long id) {
        var resultado = repositorio.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        }
        return new Produto();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);

    }
}
