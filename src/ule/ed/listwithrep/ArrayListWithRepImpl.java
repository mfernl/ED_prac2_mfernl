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
		private int cont = 0;
	
		public ArrayListWithRepIteratorRep(ElemListWithRep<T>[] cola, int count){
			
			this.items = cola;
			this.count = count;
			this.current = 0;
		}

		@Override
		public boolean hasNext() {
			if(items[current] != null) {
				int n = 0;
				for(int i=0; i<count;i++) {
					n = items[i].num + n;
				}
				if(cont == 0) {
					return (items[current + 1] != null || cont+1 < items[current].num);
				}else {
					return(items[current + 1] != null || cont < items[current].num);
				}
			}
			else {
				return false;
			}
		}

		@Override
		public T next() {
			if (! hasNext())
				 throw new NoSuchElementException();
				 T result = null;
				 if(cont < items[current].num) {
					 result = items[current].elem;
					 cont++;
				 }else {
					 result = items[current + 1].elem;
					 cont = 1;
					 current++;
				 }
				 return result;
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
		ElemListWithRep<T>[] nuevo = new ElemListWithRep[data.length*2];
			for(int i=0; i<count; i++) {
				if(this.data[i]==null) {}
				else {
				nuevo[i]=this.data[i];
				}
			}
			this.data = nuevo;
		}
	 
	
			@Override
			public void add(T element, int times) {
				if(element.equals(null)) {
					throw new NullPointerException(" ");
				}
				else if(times < 0) {
					throw new IllegalArgumentException(" ");
				}
				else if(times == 0) {
				}
				else if (!(contains(element))) {
					 if (size() == data.length)
						expandCapacity();
					 	ElemListWithRep<T> nuevo = new ElemListWithRep<T>(element,times);
					 	data[count] = nuevo;
					 	count++;
				 }else {
					 int place = whereContains(element);
					 this.data[place].num += times;
				 }
			}
			

			@Override
			public void add(T element) {
				if(element.equals(null)) {
					throw new NullPointerException(" ");
				}
				else if (!(contains(element))) {
						 if (size() == data.length)
							expandCapacity();
						 	ElemListWithRep<T> nuevo = new ElemListWithRep<T>(element,1);
						 	data[count] = nuevo;
						 	count++;
				}else {
					 int place = whereContains(element);
					 data[place].num += 1;
				 }
			}

			@Override
			public int remove(T element, int times) throws EmptyCollectionException {
				int num = 0;
				int place = 0; //donde esta el elemento que queremos eliminar
				if(element.equals(null)) {
					throw new NullPointerException("");
				}else 
				if(times < 0) {
					throw new IllegalArgumentException("");
				}else 
				if(times == 0) {
					num = 0;
				}else 
				if (isEmpty()) {
					throw new EmptyCollectionException("");
				}else 
				if(!contains(element)) {
					throw new NoSuchElementException("");
				}else {
					for (int index=0; index<count; index++) {
						if (data[index].elem.equals(element)) {
						place = index;
						}
					}
						if(times>data[place].num) {
							if(place == count-1) {
								data[place]=null;
								count--;
								num = times;
							}else {
								data[place]=data[count-1];
								data[place]=null;
								count--;
								num = times;
							}
						}else {
							data[place].num = data[place].num - times;
							num = times;
						}
				}
				return num;
				 	
			}

			@Override
			public int remove() throws EmptyCollectionException {
				int times = 0;
				if (isEmpty())
				throw new EmptyCollectionException("");

				times = data[0].num;
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
				if(element.equals(null)) {
					throw new NullPointerException("");
				}else {
				for(int i=0;i<count;i++) {
					if(data[i].elem.equals(element)) {
						return true;
					}
				}
				return false;
				}
			}
			
			public int whereContains(T element) {
				int place = 0;
				for(int i=0;i<count;i++) {
					if(data[i].elem.equals(element)) {
						place = i;
					}
				}
				return place;
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
				if(isEmpty()) {
					return 0;
				}else {
					long size=0;
					for(int i=0;i<count;i++) {
						size = size + data[i].num;
					}
					return size;	
				}
			}

			@Override
			public int count(T element) {
				int count = 0;
				if(contains(element)==false) {
					return 0;
				}else {
					for(int i=0;i<this.count;i++) {
						if(data[i].elem.equals(element)) {
							count = count + data[i].num;
						}
					}
				return count;
				}
			}

			@Override
			public Iterator<T> iterator() {
				return new ArrayListWithRepIterator<T> (data, count);
			}
			
			@Override
			public Iterator<T> iteratorRep() {
				return new ArrayListWithRepIteratorRep<T> (data, count);
			}

			
			@Override
			public String toString() {
				
				StringBuffer buffer = new StringBuffer();
				
				buffer.append("(");

				// TODO Ir añadiendo en buffer las cadenas para la representación de la cola. Ejemplo: (A A A B )
				// Se concatena cada elemento seguido por un espacio
				for( int i=0;i<data.length;i++) {
					if(data[i]==null) {}
					else {
					for(int j=0;j<data[i].num;j++) {
					buffer.append(data[i].elem + " ");
					}
					}
				}
				
				buffer.append(")");
				
				return buffer.toString();
			}

			
	
}
