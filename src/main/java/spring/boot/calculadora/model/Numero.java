package spring.boot.calculadora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Numero {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private int valor;
	
	
	public Numero(int valor) {
		super();
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	} 
}
