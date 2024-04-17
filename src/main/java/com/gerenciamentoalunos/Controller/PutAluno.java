package com.gerenciamentoalunos.Controller;

import com.gerenciamentoalunos.Model.Aluno;
import com.gerenciamentoalunos.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PutAluno {
    @Autowired
    private AlunoRepository Alunos;

    //Editar aluno
    @GetMapping("/editar/{matricula}")
    public ModelAndView editarAluno(@PathVariable String matricula) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("alunos/editaraluno");

        modelAndView.addObject("aluno", Alunos.findBymatricula(matricula));
        return modelAndView;
    };

    @PostMapping("/editar")
    public ModelAndView editar(@ModelAttribute("aluno") Aluno aluno) {
        ModelAndView modelAndView = new ModelAndView();

        Alunos.save(aluno);

        modelAndView.setViewName("redirect:/alunos");
        return modelAndView;
    }
}
