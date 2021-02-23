package spring.boot.calculadora.dto;

import java.util.List;
import java.util.Optional;

import spring.boot.calculadora.model.Historico;
import spring.boot.calculadora.model.Numero;
import spring.boot.calculadora.repository.HistoricoRepository;

public class HistoricoDto {
	
	private Long id;
	private Optional<Integer> resultado;
	private HistoricoRepository historicoRepository;
	
	public HistoricoDto() {
	}
	
	public Long getId() {
		return id;
	}



	public Optional<Integer> getResultado() {
		return resultado;
	}



	public List<Integer> historico(Integer resultado){
		return null;
	}

	public static String converter(List<Historico> historico) {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Numero resultadoDaSoma) {
		historicoRepository.save(resultadoDaSoma);
	}
	
}
