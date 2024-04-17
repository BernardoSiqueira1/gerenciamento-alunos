package com.gerenciamentoalunos.Controller;

import com.gerenciamentoalunos.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetAluno {
    @Autowired
    private AlunoRepository Alunos;

    @GetMapping("/alunos")
    public ModelAndView getAlunos(@RequestParam(required= false) String nome) {
        ModelAndView modelAndView = new ModelAndView();

        if (nome == " " || nome == null) {
            modelAndView.setViewName("alunos/listaralunos");
            modelAndView.addObject("alunosList", Alunos.findAll());
            return modelAndView;
        }

        else {
            modelAndView.setViewName("alunos/listaralunos");
            modelAndView.addObject("alunosList", Alunos.findBynomeLike(nome));
            return modelAndView;
        }
    }
}
