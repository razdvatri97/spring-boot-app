package spring.boot.calculadora.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.calculadora.dto.HistoricoDto;
import spring.boot.calculadora.model.Historico;
import spring.boot.calculadora.model.OperacaoMatematica;
import spring.boot.calculadora.repository.HistoricoRepository;


@RestController
@RequestMapping("/dividir")
public class Dividir {

	@Autowired
	private HistoricoRepository historicoRepository;
	
	@GetMapping
	public Optional<Integer> calculaDivisao(String n) {
		
		List<Integer> numerosConvertidos = Arrays.stream(n.split(",")).map(value -> Integer.valueOf(value))
				.collect(Collectors.toList());
		
		Optional<Integer> resultadoDadivisao = numerosConvertidos.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero / segundoNumero);
		
		return resultadoDadivisao;
	}
	
	@RequestMapping("/historicoDivisao") 
	@GetMapping
	public String historicoDivisao(OperacaoMatematica operacao) {
			List<Historico> historico = historicoRepository.findByOperacao(operacao);
			return HistoricoDto.converter(historico);		
		
	}
}
