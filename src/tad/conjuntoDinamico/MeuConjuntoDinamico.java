package tad.conjuntoDinamico;

import java.util.Arrays;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{

	private Integer[] meusDados = new Integer[10];
	private int posInsercao = 0;
	
	@Override
	public void inserir(Integer item) {
		if(meusDados.length == posInsercao+1){
		    meusDados =	aumentarArray();
		}
		meusDados[posInsercao] = item;
		posInsercao++;
	}
	
	private Integer[] aumentarArray() {
		Integer[] novoArray = Arrays.copyOf(meusDados, meusDados.length * 2);
		return novoArray;
	}

	@Override
	public Integer remover(Integer item) {
		int index = -1;

        for(int i = 0; i < posInsercao; i++) {
			if(item == meusDados[i]) {
				index = i;
				break;
			}
		}

		if(index == -1) {
			throw new IllegalArgumentException("Item não encontrado");
		}

		item = meusDados[index];

		Integer[] copy = Arrays.copyOf(meusDados, posInsercao);
		for(int i = posInsercao-1; i > index; i--) {
			meusDados[i-1] = copy[i];
		}
		posInsercao--;
		return item;
	}

	@Override
	public Integer predecessor(Integer item) {
        if(posInsercao == 0){
			throw new IllegalArgumentException("Tamanho 0");
		}

        for(int i = 0; i < posInsercao; i++) {
			if(item == meusDados[i]) {
				if(i-1  == -1) {
					return null;
				}
				return meusDados[i-1];
			}
		}
		throw new IllegalArgumentException("Item não encontrado");
	}

	@Override
	public Integer sucessor(Integer item) {
		if(posInsercao == 0){
			throw new IllegalArgumentException("Tamanho 0");
		}

        for(int i = 0; i < posInsercao; i++) {
			if(item == meusDados[i]) {
				if(i == posInsercao) {
					return null;
				}
				return meusDados[i+1];
			}
		}
		throw new IllegalArgumentException("Item não encontrado");
	}

	@Override
	public int tamanho() {
		return posInsercao;
	}

	@Override
	public Integer buscar(Integer item) {
		for(int i = 0; i < meusDados.length; i++) {
			if(meusDados[i] == item){
				return meusDados[i];
			}
		}
		throw new IllegalArgumentException("Item não existe");
	}

	@Override
	public Integer minimum() {
        if(meusDados.length == 0){
			throw new IllegalArgumentException("Tamanho 0");
		}

		int minValue = meusDados[0];

        for(int i = 1; i < posInsercao; i++) {
			if(minValue > meusDados[i]) {
				minValue = meusDados[i];
			}
		}
		return minValue;
	}

	@Override
	public Integer maximum() {
		if(meusDados.length == 0){
			throw new IllegalArgumentException("Tamanho 0");
		}

		int maxValue = meusDados[0];

        for(int i = 1; i < posInsercao; i++) {
			if(maxValue < meusDados[i]) {
				maxValue = meusDados[i];
			}
		}
		return maxValue;
	}
}
