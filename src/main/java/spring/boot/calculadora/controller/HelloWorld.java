package spring.boot.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
	
	@RequestMapping("/")
	@ResponseBody
	public String bemVindo() {
		return "Bem vindo a calculadora, para realizar alguma operação (somar, subtrair, dividir ou multiplicar) escreva na url, exemplo: /operação?n=1,2,3 ";
	}
}
