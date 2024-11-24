package br.univille.sportstock.service;

import br.univille.sportstock.entity.RelatorioVenda;

import java.util.List;

public interface RelatorioVendaService {
    List<RelatorioVenda> gerarRelatorio();
}
