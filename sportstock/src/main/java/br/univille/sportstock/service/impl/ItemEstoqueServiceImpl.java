package br.univille.sportstock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.univille.sportstock.entity.ItemEstoque;
import br.univille.sportstock.repository.FranquiadoRepository;
import br.univille.sportstock.repository.FuncinarioRepository;
import br.univille.sportstock.repository.ProdutoRepository;
import br.univille.sportstock.service.ItemEstoqueService;

@Service
public class ItemEstoqueServiceImpl implements ItemEstoqueService{

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired 
    private FranquiadoRepository franquiadoRepository;

    @Autowired
    private FuncinarioRepository funcinarioRepository;


    @Override
    public ItemEstoque getResumo() {
        ItemEstoque estoque = new ItemEstoque();
        estoque.setQtd_funcionario(funcinarioRepository.count());
        estoque.setQtd_produto(produtoRepository.count());
		estoque.setQtd_franquiado(franquiadoRepository.count());
        return estoque;
    }
    
    
}
