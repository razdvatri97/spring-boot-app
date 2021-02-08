package src;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        try {
            
        	var operacaoMatematica = Acao.valueOf(JOptionPane.showInputDialog("Escreva a Opera��o: SOMAR, SUBTRAIR"));
            
            var numerosDigitadosPeloUsuario = JOptionPane.showInputDialog("Informe N�meros Inteiros: (Exemplo: 1,2,11)");
            
            var numerosConvertidosParaInteger = Arrays.stream(numerosDigitadosPeloUsuario.split(",")).map(value -> Integer.valueOf(value))
                    .collect(Collectors.toList());

            calcular(numerosConvertidosParaInteger, operacaoMatematica);

        } catch (IllegalArgumentException e) {
            System.err.println("A��o Inv�lida");
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
            resultadoDaSubtracao.ifPresent(resultadoInteiro -> JOptionPane.showMessageDialog(null, "Resultado da Subtra��o: " + resultadoInteiro));
    	break;
    	
    	case MULTIPLICAR:
    	break;
    	
    	case DIVIDIR:
    	break;
    	
    	default:
    		 System.out.println("Operador inv�lida");
    	}
    }
}
