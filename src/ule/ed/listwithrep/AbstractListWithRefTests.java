package ule.ed.listwithrep;


import static org.junit.Assert.*;


import java.util.Iterator;


import org.junit.*;

import ule.ed.exceptions.EmptyCollectionException;


public abstract class AbstractListWithRefTests {

	protected abstract <T> ListWithRep<T> createListWithRep();
	

	private ListWithRep<String> S1;

	private ListWithRep<String> S2;
	
	@Before
	public void setupListWithReps() {

		this.S1 = createListWithRep();
		
		this.S2 = createListWithRep();
		
		S2.add("ABC", 5);
		S2.add("123", 5);
		S2.add("XYZ", 10);
	}

	@Test
	public void testConstructionIsEmpty() {
		assertTrue(S1.isEmpty());
		assertFalse(S2.isEmpty());
	}
	
	@Test
	//Las nuevas instancias del TAD tienen tamaño cero: 
	public void testConstructionCardinality() {
		assertEquals(S1.size(), 0);
	}

	@Test
	public void testToStringInEmpty() {
		assertTrue(S1.isEmpty());
		assertEquals(S1.toString(), "()");
	}
	
	@Test
	public void testToString1elem() {
		assertTrue(S1.isEmpty());
		S1.add("A",3);
		assertEquals(S1.toString(), "(A A A )");
	}
	
	@Test
	//Añadir elementos con una multiplicidad incrementa su contador y el tamaño de la cola: ")
	public void testAddWithCount() {
		S1.add("ABC", 5);
		assertEquals(S1.count("ABC"), 5);
		assertEquals(S1.size(), 5);
		S1.add("ABC", 5);
		assertEquals(S1.count("ABC"), 10);
		assertEquals(S1.size(), 10);
		S1.add("123", 5);		
		assertEquals(S1.count("123"), 5);
		assertEquals(S1.count("ABC"), 10);
		assertEquals(S1.size(), 15);
	}
	
	
	@Test
	//Se pueden eliminar cero instancias de un elemento con remove(x, 0): ")
	public void testRemoveZeroInstances() throws EmptyCollectionException {
		assertEquals(0,S1.remove("ABC", 0));
	}
	
	@Test
    public void testIterator() {
                  ArrayListWithRepImpl<String> lista = new ArrayListWithRepImpl<String>(5);
                  String e1 = "Hola";
                  String e2 = "Probando";
                  String e3 = "el";
                  String e4 = "iterador";
                  
                  lista.add(e1);
                  lista.add(e2, 1);
                  lista.add(e3, 2);    
                  lista.add(e4, 1);
                  
                  Iterator <String> oIt = lista.iterator();
                  String cadena="";
                  while(oIt.hasNext()) {
                      cadena+=oIt.next()+" ";
                  }
                 
                  assertEquals("Hola Probando el iterador ", cadena);
    }

	
	// TODO AÑADIR MAS TESTS
	@Test
	public void testRemoveLast() throws EmptyCollectionException {
		assertEquals(2,S2.remove("XYZ", 2));
		assertEquals(8,S2.count("XYZ"));
	}
	@Test
	public void testRemoveAll() throws EmptyCollectionException {
		assertEquals(10,S2.remove("XYZ", 10));
		assertEquals(0,S2.count("XYZ"));
	}
	
	

}
