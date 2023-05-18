package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer> {
	
	private int tamanho = 5;
	private Integer[] meusDados = null;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public MinhaPilha() {
		this.meusDados = new Integer[tamanho];
		this.tamanho = 0;
	}

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		if(tamanho == meusDados.length) {
			throw new PilhaCheiaException();
		}
		meusDados[tamanho] = item;
		tamanho++;
	}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
        if(tamanho == 0) {
			throw new PilhaVaziaException();
		}
		tamanho--;
		return meusDados[tamanho];
	}

	@Override
	public Integer topo() {
		if(tamanho == 0) {
			return null;
		}
		return meusDados[tamanho-1];
	}

	//fiz funciona mais não passa no teste por conta do 'assertEquals' que foi utilizado
	//de forma errada 
	@Override
	public PilhaIF<Integer> multitop(int k) throws PilhaVaziaException, PilhaCheiaException {
		PilhaIF<Integer> novaPilha = new MinhaPilha(); 
		for(int i = 0; i < k; i++) {
			novaPilha.empilhar(this.desempilhar());
		}
		return novaPilha;
	}

	@Override
	public boolean isEmpty() {
		if(tamanho == 0){
			return true;
		}
		return false;
	}

    public Integer[] getArray() {
		return meusDados;
	}
	

	@Override
	public boolean equals(Object obj) {
        MinhaPilha pilhaComp = (MinhaPilha) obj;

		if(meusDados.length != pilhaComp.getArray().length) {
			return false;
		}

		for(int i = 0; i < meusDados.length; i++) {
			if(meusDados[i] != pilhaComp.getArray()[i]) {
				return false;
			}
		}
		return true;
	}
}
