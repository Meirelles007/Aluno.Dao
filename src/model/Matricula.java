package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "matricula")
public class Matricula {

	
	@Id
	@ManyToOne
	@JoinColumn(name = "ra")
	@NotNull
	private Aluno raAluno;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "cod_disc")
	@NotNull
	private Disciplina cod_disc;
	
	@Column(name="ano")
	@NotNull
	private int ano;
	
	@Column(name = "semestre")
	@NotNull
	private int semestre;
	
	public Aluno getRaAluno() {
		return raAluno;
	}
	public void setRaAluno(Aluno raAluno) {
		this.raAluno = raAluno;
	}
	public Disciplina getCod_disc() {
		return cod_disc;
	}
	public void setCod_disc(Disciplina cod_disc) {
		this.cod_disc = cod_disc;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	
}
