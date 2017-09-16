/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {

  private ProdutoService service = new ProdutoServiceFakeImpl();

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView listar(
	  @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
	  @RequestParam(value = "qtd", required = false, defaultValue = "20") int qtd) {
    List<Produto> itens = service.listar(offset, qtd);
    return new ModelAndView("/produto/lista").addObject("itens", itens);
  }

  @RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.GET)
  public ModelAndView obter(@PathVariable("id") Long id) {
    Produto p = service.obter(id);
    return new ModelAndView("produto/detalhe").addObject("produto", p);
  }

}
