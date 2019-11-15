package CalculadoraRendimento;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculadoraTest {
	
	@Test
	public void getRendimentoBrutoTest() {
		Calculadora calcRendimento = new Calculadora(60, 1000.00f, 8.5f);
		double rendimentoEsperado = 13.97;
		
		assertEquals(calcRendimento.getRendimentoBruto(), rendimentoEsperado, 0.01);
	}
}