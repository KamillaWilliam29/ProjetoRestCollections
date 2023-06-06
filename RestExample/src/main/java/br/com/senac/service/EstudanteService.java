
package br.com.senac.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Estudante;
import br.com.senac.repository.EstudanteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudanteService {
//	private static Map<Long, Estudante> listaEstudantes = new HashMap<>();
	
	private EstudanteRepository estudanteRepository;

	public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
		Estudante estudante = estudanteRepository.findById(id).get();
		if(estudante != null) {
			return ResponseEntity.status(HttpStatus.OK).body(estudante);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
//		Estudante estudante = listaEstudantes.get(id);
//		if (estudante == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//		}
//
//		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	public ResponseEntity<List<Estudante>> buscarTodosEstudantes(){
		List<Estudante> listaEstudantes = estudanteRepository.findAll();
		if(listaEstudantes != null) {
			return ResponseEntity.status(HttpStatus.OK).body(listaEstudantes);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		
//		ArrayList<Estudante> listaEstudante = new ArrayList<>(listaEstudantes.values());
//		if(listaEstudante.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//		}
//		
//		return ResponseEntity.status(HttpStatus.OK).body(listaEstudante);
	}
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante){
		Estudante estudanteCadastrado = estudanteRepository.save(estudante);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudanteCadastrado);
		 
//		 listaEstudantes.put(estudante.getId(), estudante);
//		 return ResponseEntity.status(HttpStatus.CREATED).body(estudante);
	}
	
	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante){
		if(estudanteRepository.existsById(id)) {
			Estudante estudanteEncontrado = estudanteRepository.save(estudante);
			return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
//		Estudante estudanteEncontrado = listaEstudantes.get(id);
//		if(estudanteEncontrado == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}
//		
//		listaEstudantes.put(estudante.getId(), estudante);
//		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	public ResponseEntity<String> removerEstudante(long id){


		if(estudanteRepository.existsById(id)) {
			estudanteRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Removido com sucesso.");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
//		Estudante estudanteEncontrado = listaEstudantes.get(id);
//		if(estudanteEncontrado == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}
//		
//		listaEstudantes.remove(id);
//		return ResponseEntity.status(HttpStatus.OK).body("Detonado com sucesso!");
	}

	public Page<Estudante> buscarEstudantePorPaginacao(PageRequest page){
		return estudanteRepository.findAll(page);
	}
	
}