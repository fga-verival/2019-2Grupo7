package CalculadoraRendimento;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class CalculadoraTest {
	
	private double aplicacaoInicial, taxa, tempo;
	private CalculadoraAuxiliar valoresEsperados;
	
	public CalculadoraTest(
			double tempo,
			double aplicacaoInicial,
			double taxa,
			CalculadoraAuxiliar valoresEsperados)
	{
		this.tempo = tempo;
		this.aplicacaoInicial = aplicacaoInicial;
		this.taxa = taxa;
		this.valoresEsperados = valoresEsperados;
	}
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] valoresEsperados = new Object[][] {
			{60.0, 1000.0f, 8.5, new CalculadoraAuxiliar(13.97f, 3.14f, 1.0829f)},
			{120, 500.00f, 8.0f, new CalculadoraAuxiliar(13.15f, 2.96f, 2.0384f)},
			{420, 250.00f, 8.0f, new CalculadoraAuxiliar(23.01f, 4.03f, 7.5945)},
			{900, 4200.00f, 9.5f, new CalculadoraAuxiliar(983.84f, 147.58f, 19.9110f)},
			{1000, 100.00f, 7.5f, new CalculadoraAuxiliar(20.55f, 3.08f, 17.4658f)}
		};
		
		return Arrays.asList(valoresEsperados);
	}
	
	@Test
	public void getRendimentoBrutoTest() {
		Calculadora calcRendimento = new Calculadora(tempo, aplicacaoInicial, taxa);
		double rendimentoEsperado = valoresEsperados.rendimentoBruto;
		
		assertEquals(calcRendimento.getRendimentoBruto(), rendimentoEsperado, 0.01);
	}
	@Test
	public void getImpostoRendaTest() {
	    Calculadora calcImposto = new Calculadora(tempo, aplicacaoInicial, taxa);
	    double impostoEsperado = valoresEsperados.impostoRenda;
	    
	    assertEquals(calcImposto.getImpostoRenda(), impostoEsperado, 0.01);
	}
	@Test
	public void getRendimentoLiquidoTest() {
	    Calculadora calcRendimento = new Calculadora(60, 1000.00f, 8.5f);
	    double rendimentoEsperado = 1.0829;
	    
	    assertEquals(calcRendimento.getRendimentoLiquido(), rendimentoEsperado, 0.01);
	}
	@Test
	public void getRendimentoLiquidoTest2() {
	    Calculadora calcRendimento = new Calculadora(120, 500.00f, 8.0f);
	    double rendimentoEsperado = 2.0384;
	    
	    assertEquals(calcRendimento.getRendimentoLiquido(), rendimentoEsperado, 0.01);
	}
}
