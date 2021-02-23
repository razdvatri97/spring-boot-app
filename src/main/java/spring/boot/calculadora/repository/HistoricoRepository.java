package spring.boot.calculadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.calculadora.model.Historico;
import spring.boot.calculadora.model.Numero;
import spring.boot.calculadora.model.OperacaoMatematica;

public interface HistoricoRepository extends JpaRepository<Numero, Long>{

	List<Historico> findByOperacao(OperacaoMatematica operacao); 

}
