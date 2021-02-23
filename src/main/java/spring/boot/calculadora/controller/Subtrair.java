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
@RequestMapping("/subtrair")
public class Subtrair {

	@Autowired
	private HistoricoRepository historicoRepository;

	@GetMapping
	public Optional<Integer> subtrair(String n) {

		NumeroDto numeros = new NumeroDto();
		List<Integer> numerosConvertidos = numeros.converterStringParaInteger(n);

		return numeros.calcularSubtracao(numerosConvertidos);

	}

	@RequestMapping("/historicoSubtracao")
	@GetMapping
	public String historicoSubtracao(OperacaoMatematica op) {
		List<Historico> historico = historicoRepository.findByOperacao(op);
		return HistoricoDto.converter(historico);

	}

}
