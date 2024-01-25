package com.gerenciamentoalunos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gerenciamentoalunos.Model.Aluno;
import com.gerenciamentoalunos.Repository.AlunoRepository;


@Controller
public class AlunoController {
	@Autowired
	private AlunoRepository Alunos;
	
	//Home
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
		
	}
	
	//Inserir novo aluno
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
		
	
	//Visualizar alunos
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
	
	//Deletar aluno
	@GetMapping("/delete/{matricula}")
	public ModelAndView deletarAluno(@PathVariable String matricula) {
		ModelAndView modelAndView = new ModelAndView();
		Alunos.deleteBymatricula(matricula);
			
		modelAndView.setViewName("redirect:/alunos");
		return modelAndView;
	}
}
