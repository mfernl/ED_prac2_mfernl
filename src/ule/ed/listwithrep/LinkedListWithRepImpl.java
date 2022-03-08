package ule.ed.listwithrep;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.ed.exceptions.EmptyCollectionException;


public class LinkedListWithRepImpl<T> implements ListWithRep<T> {
 
	// Atributos
	private ListWithRepNode<T> front;
	int count;
	
	
	// Clase interna
	@SuppressWarnings("hiding")
	public class ListWithRepNode<T> {
		T elem;
		int num;
		ListWithRepNode<T> next;
		
		public ListWithRepNode (T elem, int num){
			this.elem=elem;
			this.num=num;
		}
		
	}
	
	///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class LinkedListWithRepIterator<T> implements Iterator<T> {
		
		
		@Override
		public boolean hasNext() {
			//TODO
			return false;
		}

		@Override
		public T next() {
			//TODO
			return null;	
				}

	}
	////// FIN ITERATOR
	
	
	
///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class LinkedListWithRepIteratorRep<T> implements Iterator<T> {
		
  	   @Override
		public boolean hasNext() {
			//TODO
			return false;
		}

		@Override
		public T next() {
			//TODO
			return null;
			
				}
	}
	////// FIN ITERATOR

	
	
	public LinkedListWithRepImpl() {
		}

	/////////////
	@Override
	public void add(T element) {
		//TODO
		}
	
	@Override
	public void add(T element, int times) {
		//TODO
		}


	@Override
	public int remove(T element, int times) throws EmptyCollectionException {
		//TODO
		return 0;
		
	}

	
	@Override
	public boolean contains(T element) {
		//TODO
		return false;
		
	}

	@Override
	public long size() {
		//TODO
		return 0;
		
	}

	@Override
	public boolean isEmpty() {
		//TODO
	   return false;	
	}

	@Override
	public int remove() throws EmptyCollectionException {
		//TODO
	 return 0;
    }

	@Override
	public void clear() {
		//TODO		
	}

	@Override
	public int count(T element) {
		//TODO
		return 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		//TODO
		return null;
	}

	@Override
	public Iterator<T> iteratorRep() {
		// TODO 
		return null;
	}
	@Override
	public String toString() {
		//TODO
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");
		
		// TODO Ir añadiendo en buffer las cadenas para la representación de la cola. Ejemplo: (A A A B )
		// Se concatena cada elemento seguido por un espacio
		
		buffer.append(")");
		return buffer.toString();
	}

	

	

	
	

}
