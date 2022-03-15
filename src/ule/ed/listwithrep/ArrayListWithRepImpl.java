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
				 if (!(contains(element))) {
					 if (size() == data.length)
						 expandCapacity();
					 data[count].elem = element;
					 data[count].num = times;
					 count++;
				 }
			}
			

			@Override
			public void add(T element) {
					 if (!(contains(element))) {
						 if (size() == data.length)
							 expandCapacity();
						 data[count].elem = element;
						 count++;
					 }
			}

			@Override
			public int remove(T element, int times) throws EmptyCollectionException {
				int times2 = 0;
				boolean search= false;
				int place = 0; //donde esta el elemento que queremos eliminar
				if (isEmpty())
				throw new EmptyCollectionException("");

				for (int index=0; index<count && search==false; index++) {
					if (data[index].equals(element)) {
						search=true;
						place = index;
					}
				}

				if (search == false) {
				throw new NoSuchElementException();
				}else {
					data[place].num = times2;
					data[place] = data[count-1];
					data[count-1]=null;
					count--;
				}

				return times2;
				 	
			}

			@Override
			public int remove() throws EmptyCollectionException {
				int times = 0;
				if (isEmpty())
				throw new EmptyCollectionException("");

				data[0].num = times;
				data[0] = data[count-1];
				data[count-1]=null;
				count--;
				return times; 

			}

			@Override
			public void clear() {
				if (isEmpty()) {
				}else {
					for(int i=0;i<count;i++) {
						data[i]=null;
					}
				}
				
			}
			

			@Override
			public boolean contains(T element) {
				for(int i=0;i<count;i++) {
					if(data[i].elem.equals(element)) {
						return true;
					}
				}
				return false;

			}

			@Override
			public boolean isEmpty() {
				for(int i=0;i<count;i++) {
					if(data[i] != null) {
						return false;
					}
				}
				return true;
			}

			@Override
			public long size() {
				long size=0;
				for(int i=0;i<count;i++) {
					size = size + data[i].num;
				}
				return size;	
			}

			@Override
			public int count(T element) {
				int count = 0;
				if(contains(element)==false) {
					return 0;
				}else {
					for(int i=0;i<count;i++) {
						if(data[i].elem.equals(element)) {
							count = count + data[i].num;
						}
					}
				return count;
				}
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
