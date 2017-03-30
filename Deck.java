/**
 *
 * Baralho da cartas (de 0 até 51)
 * Naipe é determinado por card/13
 * Número da carta é dado por (card%13)+1
 * 
 */
public class Deck {
	protected boolean[] cards;
	private Random m;
	
	Deck() {
		cards = new boolean[52];
		for(int i = 0; i < 52; i++) cards[i] = true;
		m = new Random();
	}
	
	/**
	 * Recebe o vetor de cartas que você deseja trocar e realiza a troca das cartas sem repetição
	 * @return Retorna mesa.length cartas trocadas e invalida-as no vetor cards 
	 */
	int[] getCards(int[] mesa) {
		int j;
		int[] ans = new int[mesa.length];
		for(int i = 0; i < mesa.length; i++) {
			j = m.getIntRand(51);
			while(!cards[j] || j == mesa[i]) j = m.getIntRand(51);
			cards[j] = false;
			ans[i] = j;
		}
		return ans;
	}
}
