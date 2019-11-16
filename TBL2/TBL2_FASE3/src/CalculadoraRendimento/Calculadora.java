package CalculadoraRendimento;

public class Calculadora {
	public double tempo, aplicacaoInicial, taxa;

	public Calculadora (double tempo, double aplicacaoInicial, double taxa) {
		this.tempo = tempo/365.0f;
		this.aplicacaoInicial = aplicacaoInicial;
		this.taxa = taxa/100.0f;
	}

	public double getRendimentoBruto() {
		return this.tempo * this.aplicacaoInicial * this.taxa;
	}
	
	public double getImpostoRenda() {
		double rendimento = this.getRendimentoBruto();
		double aliquota = 0;
		if(this.tempo <= 180/365.0f) {
			aliquota = 0.225;
		}
		else if(this.tempo <= 360/365.0f) {
			aliquota = 0.200;
		}
		else if(this.tempo <= 720/365.0f) {
			aliquota = 0.175;
		}
		else {
			aliquota = 0.150;
		}
	    return rendimento * aliquota;
	}
	
	public double getRendimentoLiquido() {
		double valorAcumulado = this.aplicacaoInicial;
		valorAcumulado += this.getRendimentoBruto();
		valorAcumulado -= this.getImpostoRenda();
		return (valorAcumulado/this.aplicacaoInicial)*100.0f - 100.0f;
	}
}
