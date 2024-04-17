package com.gerenciamentoalunos.Controller;

import com.gerenciamentoalunos.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteAluno {
    @Autowired
    private AlunoRepository Alunos;

    //Deletar aluno
    @GetMapping("/delete/{matricula}")
    public ModelAndView deletarAluno(@PathVariable String matricula) {
        ModelAndView modelAndView = new ModelAndView();
        Alunos.deleteBymatricula(matricula);

        modelAndView.setViewName("redirect:/alunos");
        return modelAndView;
    }
}
