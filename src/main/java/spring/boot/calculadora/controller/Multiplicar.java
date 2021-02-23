package spring.boot.calculadora.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.calculadora.dto.HistoricoDto;
import spring.boot.calculadora.dto.NumeroDto;
import spring.boot.calculadora.model.Historico;
import spring.boot.calculadora.model.OperacaoMatematica;
import spring.boot.calculadora.repository.HistoricoRepository;

@RestController
@RequestMapping("/multiplicar")
public class Multiplicar {
	
	@Autowired
	private HistoricoRepository historicoRepository;
	NumeroDto numeros = new NumeroDto();
	
	@GetMapping
	public Optional<Integer> multiplicar(String n) {
		
		
		List<Integer> numerosConvertidos = numeros.converterStringParaInteger(n);
		
		return numeros.calcularMultiplicacao(numerosConvertidos);
	}
	
	@RequestMapping("/historicoMultiplicacao") 
	@GetMapping
	public String historicoMultiplicacao(OperacaoMatematica op) {
			List<Historico> historico = historicoRepository.findByOperacao(op);
			return HistoricoDto.converter(historico);		
		
	}

}
