package src;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        try {
            
        	var operacaoMatematica = Acao.valueOf(JOptionPane.showInputDialog("Escreva a operação: SOMAR, SUBTRAIR, MULTIPLICAR ou DIVIDIR").toUpperCase());
            
            var numerosDigitadosPeloUsuario = JOptionPane.showInputDialog("Informe Números Inteiros: (Exemplo: 1,2,11)");
            
            var numerosConvertidosParaInteger = Arrays.stream(numerosDigitadosPeloUsuario.split(",")).map(value -> Integer.valueOf(value))
                    .collect(Collectors.toList());

            calcular(numerosConvertidosParaInteger, operacaoMatematica);

        } catch (IllegalArgumentException e) {
            System.err.println("Ação Inválida");
        }

    }

    private static void calcular(List<Integer> numerosDigitadosPeloUsuario, Acao operacaoMatematica) {
    	
    switch (operacaoMatematica) {
    
    	case SOMAR:
    		Optional<Integer> resultadoDaSoma = numerosDigitadosPeloUsuario.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero + segundoNumero);
            resultadoDaSoma.ifPresent(resultadoInteiro -> JOptionPane.showMessageDialog(null, "Resultado da Soma: " + resultadoInteiro));
    	break;
    	
    	case SUBTRAIR:
    		Optional<Integer> resultadoDaSubtracao = numerosDigitadosPeloUsuario.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero - segundoNumero);
            resultadoDaSubtracao.ifPresent(resultadoInteiro -> JOptionPane.showMessageDialog(null, "Resultado da Subtração: " + resultadoInteiro));
    	break;
    	
    	case MULTIPLICAR:
    		Optional<Integer> resultadoDaMultiplicacao = numerosDigitadosPeloUsuario.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero * segundoNumero);
            resultadoDaMultiplicacao.ifPresent(resultadoInteiro -> JOptionPane.showMessageDialog(null, "Resultado da Multiplicação: " + resultadoInteiro));
    	break;
    	
    	case DIVIDIR:
    		Optional<Integer> resultadoDaDivisao = numerosDigitadosPeloUsuario.stream().reduce((primeiroNumero, segundoNumero) -> primeiroNumero / segundoNumero);
            resultadoDaDivisao.ifPresent(resultadoInteiro -> JOptionPane.showMessageDialog(null, "Resultado da Divisão: " + resultadoInteiro));
    	break;
    	
    	default:
    		 System.out.println("Operador inválida");
    	}
    }
}
