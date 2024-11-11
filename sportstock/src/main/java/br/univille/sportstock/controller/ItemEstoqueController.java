package br.univille.sportstock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sportstock.entity.ItemEstoque;
import br.univille.sportstock.service.ItemEstoqueService;

@Controller
@RequestMapping
public class ItemEstoqueController {
    
    @Autowired
	private ItemEstoqueService itemService;

    @GetMapping("/estoque")
    public ModelAndView index(ModelMap model){
        ItemEstoque estoque = itemService.getResumo();
        model.addAttribute(estoque);
        return new ModelAndView("estoque/index","estoque", estoque);
    }

}
