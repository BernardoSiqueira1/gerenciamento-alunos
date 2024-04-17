package com.gerenciamentoalunos.Controller;

import com.gerenciamentoalunos.Model.Aluno;
import com.gerenciamentoalunos.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateAluno {
    @Autowired
    private AlunoRepository Alunos;
    @GetMapping("/cadastroAluno")
    public ModelAndView cadastroAluno() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("alunos/enviaralunos");
        modelAndView.addObject("aluno", new Aluno());
        return modelAndView;
    }

    @PostMapping("/inseriraluno")
    public ModelAndView inserirAluno(@ModelAttribute("aluno") Aluno aluno) {
        System.out.println(aluno.getMatricula());
        ModelAndView modelAndView = new ModelAndView();
        Alunos.insert(aluno);

        modelAndView.setViewName("redirect:/alunos");
        return modelAndView;
    };
}
