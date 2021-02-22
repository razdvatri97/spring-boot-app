package spring.boot.calculadora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historico {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private OperacaoMatematica operacao;
	
	
	public Historico() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public OperacaoMatematica getOperacao() {
		return operacao;
	}
	public void setOperacao(OperacaoMatematica operacao) {
		this.operacao = operacao;
	}
	
	
}
