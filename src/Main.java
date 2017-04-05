package com.company;

import java.io.IOException;

/**
 * @author Bruno & Gabriel
 */
public class Main {
    /**
     * O jogador recebe cinco cartas e pode trocar duas vezes a mao.
     */
	public static void main(String[] args) throws Exception {
		Player me = new Player();
		int n, aposta;

		while(me.getCredit() > 0) {

			System.out.println("Quer jogar? [Y/n]");
			if( EntradaTeclado.leString().charAt(0) == 'n') return;

			System.out.printf("Digite quanto quer aposta. A sua qtd atual de créditos é %d.\n", me.getCredit());
			aposta = EntradaTeclado.leInt();

			System.out.println(me);
			System.out.println("Digite o numero de cartas a trocar (0 - 5): ");
			n = qtdTrocar();
			me.swap(n);
			System.out.println(me);

			System.out.println("Digite o numero de cartas a trocar (0 - 5): ");
			n = qtdTrocar();
			me.swap(n);
			System.out.println(me);
			me.aposta(aposta);
			me.fimRound();
		}
		System.out.print("Fim do jogo, obrigado por jogar!\n");
	}

	private static int qtdTrocar() {
		int n;
		while(true) {
			try {
				n = EntradaTeclado.leInt();
				if (n > 5 || n < 0)
					System.out.println("Numero invalido, entre com um numero de 0 a 5");
				else
					break;
			} catch (IOException e){    // ja lidamos com a excecao
				System.out.println("Isso não é um número inteiro! Favor digitar um número inteiro.");
			}
		}
		return n;
	}
}
