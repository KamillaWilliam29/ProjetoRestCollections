package br.com.senac.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//importamos diversos itens úteis do Java para criar Listas e mapear objetos.

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//será necessário importar os frameworks de http: Status e ResponseEntity, além de indicar para o Spring que se trata de um @Service nesta classe.

import br.com.senac.domain.Estudante;
//Por fim, como estamos referenciado diretamente esta classe, vamos importar o Estudante de nosso domain.

@Service
public class EstudanteService {
	private static Map<Long, Estudante> listaEstudantes = new HashMap<>();

	public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
		Estudante estudante = listaEstudantes.get(id);
		if (estudante == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	//Neste primeiro método, usamos o objeto ResponseEntity do Spring para retornar uma página vazia,
	//caso não encontremos um estudante pelo seu id; caso encontremos este estudante, o método pede que 
	//retorne um estudante na página(body).
	
	public ResponseEntity<List<Estudante>> buscarTodosEstudantes(){
		ArrayList<Estudante> listaEstudante = new ArrayList<>(listaEstudantes.values());
		if(listaEstudante.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listaEstudante);
	}
	//Neste segundo método, retormas uma lista(List, do Java.util) e retormas a ArrayList do tipo <Estudante>
	//para que nas páginas em que forem exibidas, apareça a listaEstudante no corpo(body) da página.
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante){
		 listaEstudantes.put(estudante.getId(), estudante);
		 return ResponseEntity.status(HttpStatus.CREATED).body(estudante);
	}
	//Este é um método simples que permite cadastrar novos estudantes e exibí-los na ponta da página carregada.
	
	public ResponseEntity<Estudante> atualizarEstudante(Estudante estudante){
		Estudante estudanteEncontrado = listaEstudantes.get(estudante.getId());
		if(estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		listaEstudantes.put(estudante.getId(), estudante);
		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	//Por meio deste método atualizar, buscamos um(a) estudante pelo seu Id e editamos seus dados encontrados pelo
	//resultado da busca; É retornado um erro NotFound caso não se encontre o(a) estudante.
	public ResponseEntity<String> removerEstudante(long id){
		Estudante estudanteEncontrado = listaEstudantes.get(id);
		if(estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		listaEstudantes.remove(id);
		return ResponseEntity.status(HttpStatus.OK).body("Estudante removido com sucesso!");
	}
	//O último método, o de remoção de itens da lista, segue os padrões que já vimos em outras classes, e por meio de
	//uma busca direta do id do(a) estudante, podemos ter a  certeza de removê-lo ou não.
}
