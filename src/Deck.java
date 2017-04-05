package com.company;

/**
 * Classe que representa um baralho da cartas (de 0 ate 51)
 * Naipe eh determinado por (card/13)
 * Numero da carta eh dado por (card%13)
 */

public class Deck {
	private boolean[] cards;
	private Random rand;

	public Deck() {
		cards = new boolean[52];
		rand = new Random();
	}

	/**
	 * Recebe a quantidade de cartas que voce deseja trocar e gera cartas novas, sem repetição
	 * @param quantidade: a quantidade de cartas a serem mudadas
	 * @return quantidade cartas trocadas e invalida-as no vetor cards
	 */
	int[] getCards(int quantidade) {
		int j;
		int[] ans = new int[quantidade];
		for(int i = 0; i < quantidade; i++) {
			j = rand.getIntRand(51);
			while(!cards[j])
				j = rand.getIntRand(51);
			cards[j] = false;
			ans[i] = j;
		}
		return ans;
	}

	/**
	 * Inicia uma nova rodada. Reseta o deck e depois retorna 5 novas cartas
	 * @return 5 cartas já invalidadas no vetor cards
	 */
	public int[] newHand() {
		int[] hand = new int[5];

		int j;
		for(int i = 0; i < 52; i++)  // reseta  o deck.
			this.cards[i] = true;
		hand = getCards(5);
		return hand;
	}
}
