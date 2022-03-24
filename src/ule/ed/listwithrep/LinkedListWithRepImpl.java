package ule.ed.listwithrep;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.ed.exceptions.EmptyCollectionException;
import ule.ed.listwithrep.ArrayListWithRepImpl.ArrayListWithRepIterator;


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
		 private int cont = 0;
		
		 public LinkedListWithRepIteratorRep (ListWithRepNode<T> collection, int size){
		  current= collection;
		  count = size;
		  }
		 
  	   @Override
		public boolean hasNext() {
  		   if(current != null) {
  			   if(cont == 0) {
  				   return (current.next != null || cont+1 < current.num);
  			   }else {
  				   return (current.next != null || cont < current.num);
  			   }
  		   }else {
  			   return false;
  		   }
		}

		@Override
		public T next() {
			 if (! hasNext())
					throw new NoSuchElementException();
				 	T result;
					if(cont == current.num) {
						current = current.next;
						result = current.elem;
						cont = 1;
					}else {
						result = current.elem;
						cont++;
					}
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
			throw new NullPointerException(" ");
		}
		else if (! (contains(element))) {
			ListWithRepNode<T> node = new ListWithRepNode<T> (element,1);
			if(isEmpty()) {
				front = node;
				count++;
			}else {
				ListWithRepNode<T> current;
				current = front;
				while(current.next != null) {
					current = current.next;
				}
				current.next = node;
				count++; 
			}
		}else {
			boolean found = false;
			ListWithRepNode<T> current;
			current = front;
			for (int look=0; look<count && !found; look++) {
				if (current.elem.equals(element)) {
					found = true;
				}else{
					current = current.next;
				}
			}
			current.num = current.num + 1;
		}
	}
	
	@Override
	public void add(T element, int times) {
		if(element == null) {
			throw new NullPointerException(" ");
		}
		else if(times < 0) {
			throw new IllegalArgumentException(" ");
		}
		else if(times == 0) {
		}
		else if (! (contains(element))) {
			ListWithRepNode<T> node = new ListWithRepNode<T> (element,times);
			if(isEmpty()) {
				front = node;
				count++;
			}else {
				ListWithRepNode<T> current;
				current = front;
				while(current.next != null) {
					current = current.next;
				} 
				current.next = node;
				count++; 
			}
		}else {
			boolean found = false;
			ListWithRepNode<T> current;
			current = front;
			for (int look=0; look<count && !found; look++) {
				if (current.elem.equals(element)) {
					found = true;
				}else{
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
		}else if(times == 0) {
			rep = 0;
		}else if (isEmpty()) {
		throw new EmptyCollectionException("EmptyCollectionException");
		}
		else if(!contains(element)) {
			throw new NoSuchElementException("");
		}else
			if (front.elem.equals(element)) {
				if(times >= front.num) {
					rep = front.num;
					front = front.next;
					count--;
				}else if (times<front.num) {
					rep = times;
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
				if(times >= current.num) {
					rep = current.num;
					previous.next = current.next;
					count--;
				}else if(times<current.num) {
					rep = times;
					current.num = current.num - times;
				}
		}
			return rep;
	}

	
	@Override
	public boolean contains(T element) {
		if(element == null) {
			throw new NullPointerException("");
		}else {
		boolean found = false;
		ListWithRepNode<T> current;
		current = front;
		while(current != null && found != true) {
		if (current.elem.equals(element)) {
				found = true;
			}else{
				current = current.next;
			}
		}
		return found;
		}
	}

	@Override
	public long size() {
	 long size = 0;
	 if(isEmpty()) {}
	 else{
		 ListWithRepNode<T> current;
			current = front;
			for (int look=0; look<count; look++) {
				size = size + current.num;
				current = current.next;
			}
	 }
		return size;
		
	}

	@Override
	public boolean isEmpty() {
		if(this.front == null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int remove() throws EmptyCollectionException {
		int rep = 0;
		if(isEmpty()) {
			throw new EmptyCollectionException("");
		}else {
			ListWithRepNode<T> aux;
			aux = front.next;
			rep = front.num;
			front = aux;
			count--;
		}
		return rep;
    }

	@Override
	public void clear() {
		ListWithRepNode<T> aux;
		aux = null;
		front = aux;
	}

	@Override
	public int count(T element) {
		int num = 0;
		if(element == null) {
			throw new NullPointerException("");
		}else {
			ListWithRepNode<T> current;
			current = front;
			for (int look=0; look<count; look++) {
				if(current.elem.equals(element)) {
				num = num + current.num;
				}
				current = current.next;
			}
		}
		return num;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListWithRepIterator<T> (front, count);
	}

	@Override
	public Iterator<T> iteratorRep() {
		return new LinkedListWithRepIteratorRep<T> (front, count);
	}
	@Override
	public String toString() {
		//TODO
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");
		
		// TODO Ir añadiendo en buffer las cadenas para la representación de la cola. Ejemplo: (A A A B )
		ListWithRepNode<T> current;
		current = front;
		for (int look=0; look<count; look++) {
			if(current== null) {}
			else{
				for(int i=0; i<current.num;i++ ) {
					buffer.append(current.elem + " ");
				}
			}
			current = current.next;
		}
		// Se concatena cada elemento seguido por un espacio
		
		buffer.append(")");
		return buffer.toString();
	}

}
