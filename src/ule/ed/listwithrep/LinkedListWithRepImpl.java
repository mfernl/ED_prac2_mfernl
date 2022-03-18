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
		
		 private int count;
		 private ListWithRepNode<T> current;
		
		 public LinkedListWithRepIterator (ListWithRepNode<T> collection, int size){
		  current= collection;
		  count = size;
		  }
		 
		@Override
		public boolean hasNext() {
			return (current != null); 
		}

		@Override
		public T next() {
			 if (! hasNext())
				throw new NoSuchElementException();
			 	T result = current.elem;
				current = current.next;
				return result; 
	}
}
	////// FIN ITERATOR
	
	
	
///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class LinkedListWithRepIteratorRep<T> implements Iterator<T> {
		
		 private int count;
		 private ListWithRepNode<T> current;
		
		 public LinkedListWithRepIteratorRep (ListWithRepNode<T> collection, int size){
		  current= collection;
		  count = size;
		  }
		 
  	   @Override
		public boolean hasNext() {
			return (current.next != null); 
		}

		@Override
		public T next() {
			 if (! hasNext())
					throw new NoSuchElementException();
				 	T result = current.elem;
					current = current.next;
					return result;
				}
	}
	////// FIN ITERATOR

	
	
	public LinkedListWithRepImpl() {
		}

	/////////////
	@Override
	public void add(T element) {
		if(element == null) {
			throw new IllegalArgumentException("IllegalArgumentException");
		}
		else if (! (contains(element))) {
		ListWithRepNode<T> node = new ListWithRepNode<T> (element,1);
		node.next=front;
		front=node;
		count++; 
		}else {
			boolean found = false;
			ListWithRepNode<T> previous, current;
			previous =front;
			current = front.next;
			for (int look=1; look<count && !found; look++) {
				if (current.elem.equals(element)) {
					found = true;
				}else{
					previous = current;
					current = current.next;
				}
			}
			current.num =+ 1;
		}
	}
	
	@Override
	public void add(T element, int times) {
		if(element == null) {
			throw new IllegalArgumentException("IllegalArgumentException");
		}
		else if(times == 0) {
			
		}
		else if (! (contains(element))) {
			ListWithRepNode<T> node = new ListWithRepNode<T> (element,times);
			node.next=front;
			front=node;
			count++; 
		}else {
			boolean found = false;
			ListWithRepNode<T> previous, current;
			previous =front;
			current = front.next;
			for (int look=1; look<count && !found; look++) {
				if (current.elem.equals(element)) {
					found = true;
				}else{
					previous = current;
					current = current.next;
				}
			}
			current.num = current.num + times;
		}
		}


	@Override
	public int remove(T element, int times) throws EmptyCollectionException {
		boolean found = false;
		ListWithRepNode<T> previous, current;
		int rep = 0;
		if(element == null) {
			throw new NullPointerException("NullPointerException");
		}else
		if(times < 0) {
			throw new IllegalArgumentException("IllegalArgumentException");
		}
		else if (isEmpty()) {
		throw new EmptyCollectionException("EmptyCollectionException");
		}
		if(times == 0) {
			
		}else
		if (front.elem.equals(element)) {
			if(times > front.num) {
				rep = front.num;
				front = front.next;
				count--;
			}else {
				rep = front.num;
				front.num = front.num - times;
			}
		}else{
			previous =front;
			current = front.next;
			for (int look=1; look<count && !found; look++) {
				if (current.elem.equals(element)) {
					found = true;
				}else{
					previous = current;
					current = current.next;
				}
			}
			if (!found) {
				throw new NoSuchElementException();
			}else {
				if(times > front.num) {
					rep = current.num;
					previous.next = current.next;
					count--;
				}else {
					rep = current.num;
					current.num = current.num - times;
				}
			}
		}
			return rep;
	}

	
	@Override
	public boolean contains(T element) {
		boolean found = false;
		ListWithRepNode<T> previous, current;
		previous =front;
		current = front.next;
		for (int look=1; look<count && !found; look++) {
			if (current.elem.equals(element)) {
				found = true;
			}else{
				previous = current;
				current = current.next;
			}
		}
		return found;
	}

	@Override
	public long size() {
		//TODO
		return 0;
		
	}

	@Override
	public boolean isEmpty() {
		if(front.next == null) {
			return true;
		}else {
			return false;
		}
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
