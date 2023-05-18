package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 * @author fabioleite
 *
 */
public class MinhaFila implements FilaIF<Integer> {
	
	private int tamanho = 10;
	private int cauda = 0;
	private int cabeca = 0;
	private int total = 0;
	
	private Integer[] meusDados = null;

	public MinhaFila(int tamanhoInicial) {
		tamanho = tamanhoInicial;
		meusDados = new Integer[tamanho];
	}
	
	public MinhaFila() {
		meusDados = new Integer[tamanho];
	}

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		if((cauda == meusDados.length) && (total != meusDados.length)) {
			cauda = 0;
		}
		if(total == meusDados.length) {
			throw new FilaCheiaException();
		}

		meusDados[cauda] = item;
		cauda++;
		total++;
	}

	@Override
	public Integer desenfileirar() throws FilaVaziaException{
        if(total == 0) {
			throw new FilaVaziaException();
		}

		cabeca++;
		total--;
		return meusDados[cabeca-1];
	}

	@Override
	public Integer verificarCauda() {
		return meusDados[cauda];
	}

	@Override
	public Integer verificarCabeca() {
		return meusDados[cabeca];
	}

	@Override
	public boolean isEmpty() {
		if(total == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(total == meusDados.length) {
			return true;
		}
		return false;
	}

}
