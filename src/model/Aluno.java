package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@Column(name = "ra", length = 13)
	@NotNull
	private String ra;
	
	@Column(name = "nome", length = 60)
	@NotNull
	private String nome;
	
	@Column(name = "email", length = 40)
	@NotNull
	private String email;
	
	@Column(name = "posic_vestibular")
	@NotNull
	private int posicaoVestibular;
	
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPosicaoVestibular() {
		return posicaoVestibular;
	}
	public void setPosicaoVestibular(int posicaoVestibular) {
		this.posicaoVestibular = posicaoVestibular;
	}
	
	
	
	
}
