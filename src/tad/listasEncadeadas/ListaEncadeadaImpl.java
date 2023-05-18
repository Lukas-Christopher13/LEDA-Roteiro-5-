package tad.listasEncadeadas;

import java.util.Arrays;

import tad.util.Conversor;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T>{
	
//	NodoListaEncadeada<T> cabeca = null;
	
	NodoListaEncadeada<T> cabeca = null; // Estratégia usando marcação sentinela
	NodoListaEncadeada<T> cauda = null;// Estratégia usando marcação sentinela
	
	public ListaEncadeadaImpl() {// Estratégia usando marcação sentinela
		cabeca = new NodoListaEncadeada<T>();
		cauda = new NodoListaEncadeada<T>();
		cauda.setProximo(cabeca);
	}
	
	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
		NodoListaEncadeada<T> corrente = cabeca.getProximo();

		if(corrente == null) {
			return null;
		}
		
		while(!corrente.equals(cabeca)) {
			if(corrente.getChave() == chave) {
				return corrente;
			}
			corrente = corrente.getProximo();
		}
		return null;
	}

	@Override
	public void insert(T chave) {
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);
		novoNo.setProximo(cabeca);

		if(cabeca.getProximo() == null) {
			cabeca.setProximo(novoNo);
		}else {
			cauda.setProximo(novoNo);
		}
		cauda = novoNo;
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		// Criar um array usando a classe utilitária conversor
		Conversor<T> c = new Conversor<>();
		T[] meuArray = c.gerarArray(clazz, getSize());

		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		
        if(corrente == null) {
			return meuArray = null;
		}
		
		int index = 0;
		while(!corrente.equals(cabeca)) {
			meuArray[index] = corrente.getChave();
			corrente = corrente.getProximo();
			index++;
		}
		return meuArray;
	}

	public int getSize() {
		int cont = 0;
		NodoListaEncadeada<T> corrente = cabeca.getProximo();

		if(corrente == null) {
			return cont;
		}
		
		while(!corrente.equals(cabeca)) {
			cont++;
			corrente = corrente.getProximo();
		}
		return cont;
	}

	@Override
	public String imprimeEmOrdem() {
		String valores = "";
		NodoListaEncadeada<T> corrente = cabeca.getProximo();

		if(corrente == null) {
			return valores;
		}
		
		while(!corrente.equals(cabeca)) {
			valores += corrente.getChave() + ", ";
			corrente = corrente.getProximo();
		}
		
		return valores.substring(0, valores.length()-2);
	}

	@Override
	public String imprimeInverso() {
		String valores = "";
		
				
		return valores;
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}

	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}
}
