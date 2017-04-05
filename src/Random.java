package com.company;
import java.util.Calendar;

/** 
 * gerador simples de numeros aleatorios
 * @author delamaro
 *
 */
public class Random {
	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	
	
	private long xi;

/**
 * Retorna um numero aleatorio no intervalo (0,1[
 * @return o numero gerado.
 */
	public double getRand() {
		xi = (a + m * xi) % p;
		double d = xi;
		return d / p;
	}
	
	/**
	 * Retorna um valor inteiro no intervalo [0,max]
	 * @param max O valor limite para a geracao do numero inteiro
	 * @return o numero gerado
	 */
	public int getIntRand(int max)
	{
		double d = getRand() * max;
		return (int) d;
	}

	/**
	 * Permite alterar a semente de gerador de numeros aleatorios. Supostamente deve ser chamada
	 * antes de iniciar a geracao, mas se for chamado a qualquer instante, reseta o valor
	 * da semante.
	 * @param semente o valor da nova semente de geracao
	 */
	public void setSemente(int semente) {
       xi = semente;		
	}

	/**
	 * Construtor que permite criar o gerador, especificando o valor inicial da semente.
	 * @param k O valor inicial da semente.
	 */
	public Random(int k)
	{
		xi = k;
	}
	
	/**
	 * Construtor que usa uma semente aleatoria, adquerida usando o metodo Calendar.getTimeInMillis().
	 */
	public Random() {
		xi = Calendar.getInstance().getTimeInMillis() % p;
	}
	
}