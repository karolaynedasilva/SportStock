package br.univille.sportstock.controller;

import br.univille.sportstock.entity.RelatorioVenda;
import br.univille.sportstock.entity.Venda;
import br.univille.sportstock.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/vendas")
    public String vendas(Model model) {
        // Obter todas as vendas
        List<Venda> listaVendas = vendaService.getAll();

        // Ajuste na transformação dos dados para garantir que a lista de itens da venda
        // seja percorrida corretamente e o nome do produto e total de vendas sejam extraídos
        var relatorioVendas = listaVendas.stream()
            .map(venda -> {
                // Para cada venda, criar um relatório com os nomes dos produtos e o total de vendas
                String nomeProduto = venda.getListaItens().stream()
                    .map(item -> item.getProduto().getMarca()) // Obter nome do produto
                    .collect(Collectors.joining(", "));  // Se houver mais de um produto, junta os nomes
                
                double totalVendas = venda.calcularTotal(); // Calcular o total da venda

                // Retorna um objeto RelatorioVenda com o nome do produto e o total
                return new RelatorioVenda(nomeProduto, totalVendas);
            })
            .collect(Collectors.toList());

        // Adicionar o relatório ao modelo para que o Thymeleaf possa acessá-lo
        model.addAttribute("relatorioVendas", relatorioVendas);

        // Retornar o template Thymeleaf
        return "relatorio/vendas";
    }
}
// @Controller
// @RequestMapping("/relatorios")
// public class RelatorioVendaController {

//     @Autowired
//     private RelatorioVendaService relatorioVendaService;

//     @GetMapping("/vendas")
//     public ModelAndView gerarRelatorioVendas() {
//         List<RelatorioVenda> relatorioVendas = relatorioVendaService.gerarRelatorio();
//         ModelAndView modelAndView = new ModelAndView("relatorio/vendas");
//         modelAndView.addObject("relatorioVendas", relatorioVendas);
//         return modelAndView;
//     }
// }
