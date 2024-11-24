package br.univille.sportstock.service.impl;

import br.univille.sportstock.entity.ItemVenda;
import br.univille.sportstock.entity.RelatorioVenda;
import br.univille.sportstock.entity.Venda;
import br.univille.sportstock.repository.VendaRepository;
import br.univille.sportstock.service.RelatorioVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioVendaServiceImpl implements RelatorioVendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Override
    public List<RelatorioVenda> gerarRelatorio() {
        List<Venda> vendas = vendaRepository.findAll();
        Map<String, Double> vendasPorProduto = new HashMap<>();

        for (Venda venda : vendas) {
            for (ItemVenda itemVenda : venda.getListaItens()) {
                String nomeProduto = itemVenda.getProduto().getMarca();
                double totalItem = itemVenda.getQuantidade() * itemVenda.getValorVenda();
                vendasPorProduto.put(nomeProduto, vendasPorProduto.getOrDefault(nomeProduto, 0.0) + totalItem);
            }
        }

        List<RelatorioVenda> relatorioVendas = new ArrayList<>();
        for (Map.Entry<String, Double> entry : vendasPorProduto.entrySet()) {
            relatorioVendas.add(new RelatorioVenda(entry.getKey(), entry.getValue()));
        }

        return relatorioVendas;
    }
}
