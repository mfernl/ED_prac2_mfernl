package ule.ed.listwithrep;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.ed.exceptions.EmptyCollectionException;

public class ArrayListWithRepImpl<T> implements ListWithRep<T> {
	
	// atributos
	
    private final int capacityDefault = 5;
	
	ElemListWithRep<T>[] data;
    private int count;
    
	// Clase interna   
	@SuppressWarnings("hiding")
	public class ElemListWithRep<T> {
		T elem;
		int num;
		public ElemListWithRep (T elem, int num){
			this.elem=elem;
			this.num=num;
		}
	}

	
	///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class ArrayListWithRepIterator<T> implements Iterator<T> {
		
		private int count;
		private int current;
		private ElemListWithRep<T>[] items;
		 
		public ArrayListWithRepIterator(ElemListWithRep<T>[] cola, int count){
					
		this.items = cola;
		this.count = count;
		this.current = 0;
		
		}
		@Override
		public boolean hasNext() {
			//TODO
			 return (current < count); 			
		}

		@Override
		public T next() {
			if (! hasNext())
				 throw new NoSuchElementException();
				 current ++;
				 return items[current -1].elem;
		}
		
		

	}
	////// FIN ITERATOR
	
///// ITERADOR //////////
	@SuppressWarnings("hiding")
	public class ArrayListWithRepIteratorRep<T> implements Iterator<T> {
		
		private int count;
		private int current;
		private ElemListWithRep<T>[] items;
	
		public ArrayListWithRepIteratorRep(ElemListWithRep<T>[] cola, int count){
			
			this.items = cola;
			this.count = count;
			this.current = 0;
		}

		@Override
		public boolean hasNext() {
			//TODO
			 return (current < count); 						
		}

		@Override
		public T next() {
			if (! hasNext())
				 throw new NoSuchElementException();
				 current ++;
				 return items[current -1].elem;
		}
		
		

	}
	////// FIN ITERATOR
	
    // Constructores

	@SuppressWarnings("unchecked")
	public ArrayListWithRepImpl() {
		data =   new ElemListWithRep[capacityDefault];
		count=0;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayListWithRepImpl(int capacity) {
		data =  new ElemListWithRep[capacity];
		count=0;
	}
	
	
	 @SuppressWarnings("unchecked")
	 private void expandCapacity() {
		//TODO
			ElemListWithRep<T>[] nuevo= (ElemListWithRep<T>[]) new ElemListWithRep[data.length*2];
			
			// todo
		}
	 
	
			@Override
			public void add(T element, int times) {
				// TODO 
			
			}
			

			@Override
			public void add(T element) {
				// TODO 
				
				}

			@Override
			public int remove(T element, int times) throws EmptyCollectionException {
				// TODO
				return 0;
				 	
			}

			@Override
			public int remove() throws EmptyCollectionException {
				// TODO
				return 0;
				
			}

			@Override
			public void clear() {
				// TODO 
				
			}
			

			@Override
			public boolean contains(T element) {
				// TODO 
			
				return false;

			}

			@Override
			public boolean isEmpty() {
				// TODO 
				return false;
			}

			@Override
			public long size() {
				// TODO 
				return 0;	
			}

			@Override
			public int count(T element) {
				// TODO 
				return 0;
			}

			@Override
			public Iterator<T> iterator() {
				// TODO 
				return null;
			}
			
			@Override
			public Iterator<T> iteratorRep() {
				// TODO 
				return null;
			}

			
			@Override
			public String toString() {
				
				StringBuffer buffer = new StringBuffer();
				
				buffer.append("(");

				// TODO Ir añadiendo en buffer las cadenas para la representación de la cola. Ejemplo: (A A A B )
				// Se concatena cada elemento seguido por un espacio
				
				buffer.append(")");
				
				return buffer.toString();
			}

			
	
}
