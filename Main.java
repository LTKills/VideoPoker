public class Main {
	public static void main(String[] args) {
		Player me = new Player();
		int n;
		
		while(me.getCredit() > 0) {
			
			System.out.println("Quer jogar? [Y/n]");
			if(EntradaTeclado.leString()[0] == n) return;
			
			System.out.println(me);
			System.out.println("N�mero de cartas a trocar (0 - 5)");
			n = EntradaTeclado.leInt();
			while(n > 5 || n < 0) { 
				System.out.println("N�mero inv�lido, entre com um n�mero de 0 a 5");
				n = EntradaTeclado.leInt();
			} 
			
			System.out.println(me);
			System.out.println("N�mero de cartas a trocar (0 - 5)");
			n = EntradaTeclado.leInt();
			while(n > 5 || n < 0) { 
				System.out.println("N�mero inv�lido, entre com um n�mero de 0 a 5");
				n = EntradaTeclado.leInt();
			}
		}
	}
}
