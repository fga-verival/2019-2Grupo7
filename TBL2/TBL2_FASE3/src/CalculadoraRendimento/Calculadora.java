package CalculadoraRendimento;

public class Calculadora {
	public double tempo, aplicacaoInicial, taxa;

	public Calculadora (double tempo, double aplicacaoInicial, double taxa) {
		this.tempo = tempo/365.0f;
		this.aplicacaoInicial = aplicacaoInicial;
		this.taxa = taxa/100.0f;
	}

}
