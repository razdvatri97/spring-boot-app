package spring.boot.calculadora.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/somar")
public class Somar {

	
	
	@GetMapping
	public Optional<Integer> calcularSomar(String n) {
		
		List<Integer> numerosConvertidos = Arrays.stream(n.split(",")).map(value -> Integer.valueOf(value))
				.collect(Collectors.toList());
		
		Optional<Integer> resultadoDaSoma = numerosConvertidos.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero + segundoNumero);

		return resultadoDaSoma;
	}

}
