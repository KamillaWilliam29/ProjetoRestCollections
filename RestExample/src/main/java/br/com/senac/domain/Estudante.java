package br.com.senac.domain;

import java.time.LocalDate;
//A LocalDate será usada para definir o tipo do Arquivo dataNascimento; também iportaremos o lobok para facilitar os contrutores e os Getters e Setters de nossa classe domain.
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estudante {
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String emailString;
	
	@Getter
	@Setter
	private LocalDate dataNascimento;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return null;
	}
}
