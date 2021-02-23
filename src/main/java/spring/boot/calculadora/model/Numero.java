package spring.boot.calculadora.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Numero {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private OperacaoMatematica operacao;
	//private Optional<Integer> valor;
	
	
	public Numero(Optional<Integer> valor) {
		super();
		//this.valor = valor;
	}

	public Long getId() {
		return id;
	}
	
	//public Optional<Integer> getValor() {
	//	return valor;
	//}
	
	//public void setValor(Optional<Integer> valor) {
	//	this.valor = valor;
	//}

	public OperacaoMatematica getOperacao() {
		return operacao;
	}

	public void setOperacao(OperacaoMatematica operacao) {
		this.operacao = operacao;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
