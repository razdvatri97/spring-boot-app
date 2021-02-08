package src;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        try {
            var op = Acao.valueOf(JOptionPane.showInputDialog("Escreva a Operação: SOMAR, SUBTRAIR"));
            var valores = JOptionPane.showInputDialog("Informe Números Inteiros: (Exemplo: 1,2,11)");
            var valConvertidos = Arrays.stream(valores.split(",")).map(value -> Integer.valueOf(value))
                    .collect(Collectors.toList());
            calcular(valConvertidos, op);

        } catch (IllegalArgumentException e) {
            System.err.println("Ação Inválida");
        }

    }

    private static void calcular(List<Integer> valores, Acao op) {
        if (op == Acao.SOMAR) {
            Optional<Integer> valor = valores.stream().reduce((valorUm, valorDois) -> valorUm + valorDois);
            valor.ifPresent(integer -> JOptionPane.showMessageDialog(null, "Resultado Valores Somados: " + integer));
        } else if (op == Acao.SUBTRAIR) {
            Optional<Integer> valor = valores.stream().reduce((valorUm, valorDois) -> valorUm - valorDois);
            valor.ifPresent(integer -> JOptionPane.showMessageDialog(null, "Resultado Valores Subtraidos: " + integer));
        } else {
            System.out.println("Operador inválida");
        }
    }
}
