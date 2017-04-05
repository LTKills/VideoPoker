package com.company;

/**
 * Classe que guarda as informações atuais sobre o jogador.
 * Guarda a quantidade de créditos e as cartas dele.
 * @author Bruno & Gabriel
 */

public class Player {
    private int[] cartas;
    private int startCredit = 200;
    private int credit;
    private Deck deck;
    private Fichas fichas;

    public int getCredit() {
        return this.credit;
    }

    /**
     * Inicializa um novo player, com startCredito de creditos, e uma nova hand.
     */
    public Player() {
        this.credit = startCredit;
        deck = new Deck();
        cartas = deck.newHand();
        fichas = new Fichas();
    }

    /**
     * Faz uma nova aposta. Se o usuário não tem créditos o suficiente, joga uma exceção
     * @param aposta: a quantidade de cŕeditos que o usuário quer apostar
     * @throws IllegalArgumentException se o usuário não tem credito o sufuciente para a aposta
     */
    public void aposta(int aposta) throws IllegalArgumentException {
        if (aposta > this.credit)
            throw new IllegalArgumentException(String.format("ERRO: Você tem %d cŕeditos e está tentando apostar %d\n",
                    this.credit, aposta));
        else
	        this.credit += (fichas.pontuação(this.cartas, aposta) - aposta);
    }

	public void fimRound() {
		System.out.printf("Você agora tem %d créditos\n\n\n", this.getCredit());
		this.deck.newHand();
	}

    /**
     * Troca uma determinada quantidade de cartas
     * @param quantidade: quantas cartas o usuário deseja mudar
     */
    public void swap(int quantidade) throws Exception {
    	int[] trocar = new int[quantidade];
    	int [] novasCartas = new int[quantidade];
    	int var;
    	boolean[] swapped = new boolean[5];
	    for (int i = 0; i < 5; i++)
		    swapped[i] = false;
    	for (int i=0; i<quantidade; i++) {  // le do usario quais cartar a serem trocadas
		    System.out.println("Escolha qual carta (1 - 5) quer trocar:");
		    var = EntradaTeclado.leInt();
		    while (var < 1 || var > 5 || swapped[var - 1]) {
			    System.out.println("Carta inválida! Tente novamente: ");
			    var = EntradaTeclado.leInt();
		    }
		    trocar[i] = var-1;
		    swapped[var-1] = true;
	    }

	    novasCartas = deck.getCards(quantidade);
	    for (int i = 0; i < quantidade; i++)
		    cartas[trocar[i]] = novasCartas[i];
    }

    /**
     * Retorna as cartas do usuário em formato para impressão, número e naipe.
     * @return as cartas do usuário.
     */
    @Override
    public String toString() {
    	String s = "Suas cartas são\n";
    	int carta, naipe;
	    for (int i = 0; i < 5; i++)
	    	s += String.format("     (%d)       ", i+1);
	    s += "\n";
	    for (int i = 0; i < 5; i++) {
    		naipe = cartas[i]/13;
    		carta = (cartas[i]%13)+1;
		    if (carta == 1)
		    	s += "A";
		    else if (carta <= 10)
		    	s += String.format("%d", carta);
		    else if (carta == 11)
		    	s += "J";
		    else if (carta == 12)
		    	s += "Q";
		    else if (carta == 13)
		    	s += "K";

		    if (naipe == 0)
		    	s += " de paus  ";
		    else if (naipe == 1)
		    	s += " de copas ";
		    else if (naipe == 2)
		    	s += " de espada";
		    else if (naipe == 3)
		    	s += " de ouros ";

		    s += "    ";
	    }
	    return s;
    }

}
