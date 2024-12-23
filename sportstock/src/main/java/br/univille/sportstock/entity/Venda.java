package br.univille.sportstock.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> listaItens = new ArrayList<>();

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Franquiado comprador;

    public Franquiado getComprador() {
        return comprador;
    }

    public void setComprador(Franquiado comprador) {
        this.comprador = comprador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemVenda> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemVenda> listaItens) {
        this.listaItens = listaItens;
    }
    public double calcularTotal() {
        return listaItens.stream()
                         .mapToDouble(item -> item.getQuantidade() * item.getValorVenda())
                         .sum();
    }
}
