package br.univille.sportstock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.sportstock.entity.Franquiado;

@Service
public interface FranquiadoService {
    List<Franquiado> getAll();
    Franquiado save(Franquiado franquiado);
    Franquiado findById(long id);
    void delete(long id);
}
