package br.com.senac.controller;

import java.util.List;
//Um dos métodos precisará de uma lista no retorno, portanto importaremos este objeto do Util.
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Importamos aqui todos os objetos e notações necessárias para construir a nossa API Rest.

import br.com.senac.domain.Estudante;
import br.com.senac.service.EstudanteService;
//Também importamos o nosso domain e o nosso service, como é de praxe no Controller.

@RestController
@RequestMapping("estudante")
public class EstudanteController {
	private EstudanteService estudanteService;
	//Revisando: toda vez que temos um RequestMapping estaremos importando uma classe modelo para o nosso controller,
	//a fim de podermos manipularmos os atributos delas. 
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id){
		return estudanteService.buscarEstudantePorId(id);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Estudante>> listarTodosEstudantes(){
		return estudanteService.buscarTodosEstudantes();
	}
	//Como o nome destes métodos sugerem, vamos dar um Get ao terminar de chamarmos a classe service nos atributos indicados;
	
	@PostMapping
	public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante){
		return estudanteService.cadastrarEstudante(estudante);
	}
	
	@PostMapping
	public ResponseEntity<Estudante> atualizarEstudante
	(@RequestBody Estudante estudante){
		return estudanteService.atualizarEstudante(estudante);
	}
	//Nos métodos de PostMapping, damos início ao que alteramos/cadastramos em primeiro lugar, lançando estas alterações em tempo de execução;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerEstudante(@PathVariable Long id){
		return estudanteService.removerEstudante(id);
	}
	//Como é esperado, temos também um método DeleteMapping usado sempre que precisamos tirar algo que não saiu dentro do planejado.  Pelo id do
	//ojeto, removemos da lista o que precisamos.
}
