package br.univille.sportstock.entity;

public class RelatorioVenda {

    private String nomeProduto;
    private double totalVendas;

    // Construtores, getters e setters

    public RelatorioVenda(String nomeProduto, double totalVendas) {
        this.nomeProduto = nomeProduto;
        this.totalVendas = totalVendas;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
}
