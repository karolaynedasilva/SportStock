package br.univille.sportstock.service;

import java.util.List;

import br.univille.sportstock.entity.Venda;

public interface VendaService {
    List<Venda> getAll();

    void save(Venda venda);

    Venda findById(long id);

}
