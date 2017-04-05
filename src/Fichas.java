package com.company;

import java.util.Arrays;

/**
 * Classe que verifica as combinações que premiam o jogador
 * @author Bruno
 */
public class Fichas {

    /**
     * Verifica se há um straight dado as cartas do usuário
     * @param cartas: as cartas do usuário já ordenadas
     * @return True se houver straight, se não Falso
     */
    private Boolean isStraight(int[] cartas) {
        if (cartas[0] != 0) { // não há um ás
			if (cartas[0] + 1 == cartas[1] && cartas[1] + 1 == cartas[2] && cartas[2] + 1 == cartas[3] && cartas[3]+1 == cartas[4])
                return true;
        }
        else { // há um ás
            if ((cartas[4] + 1) % 13 == 0) // penúltima é rei
	            if (cartas[1] + 1 == cartas[2] && cartas[2] + 1 == cartas[3] && cartas[3] + 1 == cartas[4])
		            return true;
            }
        return false;
    }

    /**
     * Verifica se há um flush dado as cartas do usuário
     * @param cartas: as cartas do usuário já ordenadas
     * @return True se houver flush, se não Falso
     */
    private Boolean isFlush(int[] cartas) {
        int naipePrimeiraCarta = cartas[0] / 13;
        boolean flush = true;
        for (int i = 1; i<5; i++)
            if (cartas[i]/13 != naipePrimeiraCarta)
                flush = false;
        return flush;
    }


    /**
     * Verifica se há uma quadra dado as cartas do usuário
     * @param cartas: as cartas do usuário já ordenadas
     * @return True se houver quadra, se não Falso
     */
    private Boolean isQuadra(int[] cartas) {
        if ( (cartas[0] == cartas[1] && cartas[1] == cartas[2] && cartas[2] == cartas[3]) ||
                (cartas[1] == cartas[2] && cartas[2] == cartas[3] && cartas[3] == cartas[4]) )
            return true;
        return false;
    }

    /**
     * Verifica se há uma trinca dado as cartas do usuário
     * @param cartas: as cartas do usuário já ordenadas
     * @return True se houver trinca, se não Falso
     */
    private Boolean isTrinca(int[] cartas) {
        int i;
        for (i=0; i<3; i++)
            if (cartas[i] == cartas[i+1] && cartas[i+1] == cartas[i+2])
                return true;
        return false;
    }

    /**
     * Verifica se há um par dado as cartas do usuário
     * @param cartas: as cartas do usuário já ordenadas
     * @return True se houver par, se não Falso
     */
    private Boolean isPar(int[] cartas) {
        int i;
        for (i=0; i<4; i++)
            if (cartas[i] == cartas[i+1])
                return true;
        return false;
    }

    /**
     * Verifica se com execeção da carta passada como parâmetro, há um par dado as cartas do usuário
     * @param cartas: as cartas do usuário já ordenadas
     * @param cartaRetirada: a carta que não deve ser levada em consideração.
     * @return true se houver um par sem levar em consideração a cartaRetirada, se não false
     */
    private Boolean isPar(int[] cartas, int cartaRetirada) {
        int i;
        for (i=0; i<4; i++)
            if (cartas[i] == cartas[i+1] && cartas[i] != cartaRetirada)
                return true;
        return false;
    }

    /**
     * Retorna o valor ganho com a aposta do usuário dado as suas cartas
     * @param cartas: as cartas do usuário
     * @return um inteiro, a quantidade de créditos ganho (caso exista) ou zero.
     */
    public int pontuação(int[] cartas, int aposta) {
    	int[] numero = new int[5];  // guarda apenas o número da carta, sem informacao do naipe
	    for (int i = 0; i < 5; i++)
		    numero[i] = cartas[i] % 13;
        Arrays.sort(cartas);
        Arrays.sort(numero);
        boolean straight = isStraight(numero), flush = isFlush(cartas), trinca = isTrinca(numero);

        if (straight && flush) {
            if (numero[0] == 0) {// royal straight flush
	            System.out.printf("Parabens, voce conseguiu um royal straight flush!!!!!!\n");
	            return aposta * 200;
            }
	        System.out.printf("Parabens, voce conseguiu um straight flush!!!!!\n");
            return aposta * 100;
        }

        if (isQuadra(numero)) {
	        System.out.printf("Parabens, voce conseguiu uma quadra!!!!\n");
	        return aposta * 50;
        }
        if (trinca && isPar(numero, numero[2])) {
	        // full hand, uma trinca mais um par sem levar em consideração a carta da trinca (carta[2])
	        System.out.printf("Parabens, voce conseguiu um full-hand!!!\n");
	        return aposta * 20;
        }
        if (flush) {
	        System.out.printf("Parabens, voce conseguiu um flush!!\n");
	        return aposta * 10;
        }
        if (straight) {
	        System.out.printf("Parabens, voc conseguiu um straight!\n");
	        return aposta * 5;
        }
        if (trinca) {
	        System.out.printf("Voce conseguiu uma trinca\n");
	        return aposta * 2;
        }
        if (isPar(numero)) {
	        System.out.printf("Voce conseguiu um par\n");
	        return aposta;
        }
	    System.out.printf("Voce nao conseguiu nenhuma combinacao :( \n");
        return 0;
    }
}
