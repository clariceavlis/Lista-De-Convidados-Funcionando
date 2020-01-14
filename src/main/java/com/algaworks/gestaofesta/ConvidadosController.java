package com.algaworks.gestaofesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.gestaofesta.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

    @Autowired
    private Convidados convidados;

    @GetMapping

        public ModelAndView listar() {
            
            ModelAndView modelAndView = new ModelAndView("ListaConvidados");
            
            modelAndView.addObject("convidados", convidados.findAll());
            modelAndView.addObject(new Convidado());
            
            return modelAndView;
            
    }

    @PostMapping
        public String salvar(Convidado convidado) {
            this.convidados.save(convidado);
            return "redirect:/convidados";

        }

    @GetMapping("/excluir/{id}")
        public ModelAndView excluir(@PathVariable(name = "id") long id) {
            convidados.deleteById(id);
            return new ModelAndView("redirect:/convidados");
            }
}
