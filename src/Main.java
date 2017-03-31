public class Main {
    /**
     * O jogador recebe cinco cartas e pode trocar duas vezes a mao.
     */
	public static void main(String[] args) {
		Player me = new Player();
		int n;

		while(me.getCredit() > 0) {

			System.out.println("Quer jogar? [Y/n]");
			if(EntradaTeclado.leString()[0] == 'n') return;

			System.out.println(me);
			System.out.println("Numero de cartas a trocar (0 - 5)");
			n = EntradaTeclado.leInt();
			while(n > 5 || n < 0) {
				System.out.println("Numero invalido, entre com um numero de 0 a 5");
				n = EntradaTeclado.leInt();
			}

			System.out.println(me);
			System.out.println("Numero de cartas a trocar (0 - 5)");
			n = EntradaTeclado.leInt();
			while(n > 5 || n < 0) {
				System.out.println("Numero invalido, entre com um numero de 0 a 5");
				n = EntradaTeclado.leInt();
			}
		}
	}
}
