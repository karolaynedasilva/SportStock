package br.univille.sportstock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.sportstock.entity.Funcionario;
import br.univille.sportstock.repository.FuncinarioRepository;
import br.univille.sportstock.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    private FuncinarioRepository repositorio;

    @Override
    public List<Funcionario> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repositorio.save(funcionario);
    }

    @Override
    public Funcionario findById(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        return new Funcionario();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
        
    }
    
}
