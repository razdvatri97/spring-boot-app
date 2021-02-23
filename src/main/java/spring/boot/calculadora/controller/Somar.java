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
@RequestMapping("/somar")
public class Somar {

	@Autowired
	private HistoricoRepository historicoRepository;
	NumeroDto numeroDto = new NumeroDto();

	@GetMapping
	public Optional<Integer> somar(String n) {
		
		List<Integer> numerosConvertidos = numeroDto.converterStringParaInteger(n);
		return numeroDto.calcularSoma(numerosConvertidos);
	}

	@GetMapping
	@RequestMapping("/historicoSoma")
	public String historicoSoma(OperacaoMatematica op) {
		System.out.println(op);
		List<Historico> historico = historicoRepository.findByOperacao(op);
		return HistoricoDto.converter(historico);

	}

}
