package spring.boot.calculadora.dto;

import java.util.List;
import java.util.stream.Collectors;

public class NumeroDto {

	private Long id;
	private int valor;
	
	public NumeroDto(Integer numero) {
		this.valor = numero;
	}
	
	public Long getId() {
		return id;
	}
	public int getValor() {
		return valor;
	}
	
	public static List<NumeroDto> converterParaDto(List<Integer> numeros){
		return numeros.stream().map(NumeroDto:: new).collect(Collectors.toList()); 
	}
	
}
