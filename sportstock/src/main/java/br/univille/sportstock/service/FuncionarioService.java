package br.univille.sportstock.service;

import org.springframework.stereotype.Service;
import java.util.List;
import br.univille.sportstock.entity.Funcionario;

@Service
public interface FuncionarioService {
    
    List<Funcionario> getAll();
    Funcionario save(Funcionario funcionario);
    Funcionario findById(long id);
    void delete(long id);

}
