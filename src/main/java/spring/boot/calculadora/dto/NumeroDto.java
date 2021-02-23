package spring.boot.calculadora.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import spring.boot.calculadora.model.Numero;

public class NumeroDto {

	private Long id;
	private int valor;

	public NumeroDto() {

	}

	public NumeroDto(Numero numero) {
		this.valor = numero.getValor();
	}

	public Long getId() {
		return id;
	}

	public int getValor() {
		return valor;
	}

	public List<Integer> converterStringParaInteger(String n) {
		return Arrays.stream(n.split(",")).map(value -> Integer.valueOf(value)).collect(Collectors.toList());
	}

	public Optional<Integer> calcularSoma(List<Integer> numerosConvertidos) {
		return numerosConvertidos.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero + segundoNumero);
	}

	public Optional<Integer> calcularSubtracao(List<Integer> numerosConvertidos) {
		return numerosConvertidos.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero - segundoNumero);
	}

	public Optional<Integer> calcularMultiplicacao(List<Integer> numerosConvertidos) {
		return numerosConvertidos.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero * segundoNumero);

	}

	public Optional<Integer> cacularDivisao(List<Integer> numerosConvertidos) {
		return numerosConvertidos.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero / segundoNumero);
	}

	public static List<NumeroDto> converterParaDto(List<Numero> numeros) {
		return numeros.stream().map(NumeroDto::new).collect(Collectors.toList());
	}

}
