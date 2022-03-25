package ule.ed.listwithrep;


import static org.junit.Assert.*;


import java.util.Iterator;
import java.util.NoSuchElementException;

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
		assertEquals(8,S2.remove("XYZ", 10));
		assertEquals(0,S2.count("XYZ"));
		assertEquals(false,S2.contains("XYZ"));
	}
	@Test
	public void testRemoveAll() throws EmptyCollectionException {
		assertEquals(10,S2.remove("XYZ", 10));
	}
	@Test
	public void testClearing() throws EmptyCollectionException {
		assertFalse(S2.isEmpty());
		S2.clear();
		assertTrue(S2.isEmpty());
	}
	@Test
	public void testRemoveUntilClear() throws EmptyCollectionException {
		assertEquals(2,S2.remove("XYZ", 2));
		assertEquals(2,S2.remove("XYZ", 2));
		assertEquals(2,S2.remove("XYZ", 2));
		assertEquals(2,S2.remove("XYZ", 2));
		assertEquals(2,S2.remove("XYZ", 2));
		assertFalse(S2.contains("XYZ"));
	}
	@Test
	public void testRemoveSecond() throws EmptyCollectionException {
		S1.add("hola",5);
		S1.add("aloh",5);
		assertEquals(5,S1.remove());
		assertFalse(S1.contains("hola"));
		assertEquals(5,S1.size());
		assertEquals(5,S1.remove());
		assertFalse(S1.contains("aloh"));
		assertEquals(0,S1.size());
	}
	@Test
	public void testRemoveSecondElement() throws EmptyCollectionException {
		S1.add("hola",5);
		S1.add("aloh",5);
		assertEquals(5,S1.remove("aloh",5));
		assertFalse(S1.contains("aloh"));
		assertEquals(5,S1.size());
		assertEquals(5,S1.remove());
		assertFalse(S1.contains("aloh"));
		assertEquals(0,S1.size());
	}
	@Test
	public void testSize() throws EmptyCollectionException {
		assertTrue(S1.isEmpty());
		assertEquals(0,S1.size());
		S1.add("XD",3);
		assertFalse(S1.isEmpty());
		assertEquals(3,S1.size());
		assertTrue(S1.contains("XD"));
		S1.remove();
		assertTrue(S1.isEmpty());
		assertEquals(0,S1.size());
		assertFalse(S1.contains("Xd"));
	}
	
	@Test
	public void testIteratorRep() throws EmptyCollectionException {
        ArrayListWithRepImpl<String> lista = new ArrayListWithRepImpl<String>(5);
        
        String e1 = "Hola";
        String e2 = "Probando";
        String e3 = "el";
        String e4 = "iterador";
        
        lista.add(e1);
        lista.add(e2, 2);
        lista.add(e3, 2);    
        lista.add(e4, 1);
        
        Iterator <String> listaString = lista.iteratorRep();
               
        String cadena="";
        while(listaString.hasNext()) {
            cadena+=listaString.next()+" ";
        }
        
        assertEquals("Hola Probando Probando el el iterador ",cadena);
        

	}
	
	@Test
	public void testLinkedIterator() throws EmptyCollectionException {
		LinkedListWithRepImpl<String> lista = new LinkedListWithRepImpl<String>();
        
        String e1 = "Hola";
        String e2 = "Probando";
        String e3 = "el";
        String e4 = "iterador";
        
        lista.add(e1);
        lista.add(e2, 2);
        lista.add(e3, 2);    
        lista.add(e4, 1);
        
        Iterator <String> listaString = lista.iterator();
               
        String cadena="";
        while(listaString.hasNext()) {
            cadena+=listaString.next()+" ";
        }
        
        assertEquals("Hola Probando el iterador ",cadena);
        

	}
	
	@Test
	public void testLinkedIteratorRep() throws EmptyCollectionException {
		LinkedListWithRepImpl<String> lista = new LinkedListWithRepImpl<String>();
        
        String e1 = "Hola";
        String e2 = "Probando";
        String e3 = "el";
        String e4 = "iterador";
        
        lista.add(e1);
        lista.add(e2, 2);
        lista.add(e3, 2);    
        lista.add(e4, 1);
        
        Iterator <String> listaString = lista.iteratorRep();
               
        String cadena="";
        while(listaString.hasNext()) {
            cadena+=listaString.next()+" ";
        }
        
        assertEquals("Hola Probando Probando el el iterador ",cadena);
        

	}
	
	@Test
	public void testNextHasNext() throws EmptyCollectionException {
        ArrayListWithRepImpl<String> lista = new ArrayListWithRepImpl<String>(5);
        
        String e1 = "Hola";
        String e2 = "Probando";
        
        lista.add(e1);
        lista.add(e2, 2);
        
        Iterator <String> listaString = lista.iteratorRep();
        
        assertTrue(listaString.hasNext());
        assertEquals(listaString.next(),"Hola");
        assertTrue(listaString.hasNext());
        assertEquals(listaString.next(),"Probando");
        assertTrue(listaString.hasNext());
        assertEquals(listaString.next(),"Probando");
        assertFalse(listaString.hasNext());

	}
	
	@Test
	public void testFirstHasNext() throws EmptyCollectionException {
        ArrayListWithRepImpl<String> lista = new ArrayListWithRepImpl<String>(5);
        
        String e1 = "Hola";
        
        lista.add(e1,2);
        
        Iterator <String> listaString = lista.iteratorRep();
        
        assertTrue(listaString.hasNext());
        assertEquals(listaString.next(),"Hola");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddNull() throws Exception {
        ArrayListWithRepImpl<String> lista = new ArrayListWithRepImpl<String>(5);
        
        String e1 = "Hola";
        String e2 = "Probando";
        String e3 = null;
        
        lista.add(e1);
        lista.add(e2, 2);
        lista.add(e3);
	}
	
	@Test
	public void testHasNext() throws Exception {
        ArrayListWithRepImpl<String> lista = new ArrayListWithRepImpl<String>(5);
        
        String e1 = "Hola";
        String e2 = "Probando";
        
        lista.add(e1);
        lista.add(e2, 2);
        Iterator <String> listaString = lista.iteratorRep();
        lista.remove(e2,4);
        listaString.hasNext();
	}
	@Test
	public void testHasNextNullRep() throws Exception {
        Iterator <String> listaString = S1.iteratorRep();
    
        assertFalse(listaString.hasNext());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testHasNoNextRep() throws Exception {
        ArrayListWithRepImpl<String> lista = new ArrayListWithRepImpl<String>(5);
        
        String e1 = "Hola";
        String e3 = "adios";
        
        lista.add(e1);
        lista.add(e3);
        
        Iterator <String> listaString = lista.iteratorRep();
        
        assertTrue(listaString.hasNext());
        assertEquals(listaString.next(),"Hola");
        listaString.next();
        listaString.next();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testHasNoNext() throws Exception {
        ArrayListWithRepImpl<String> lista = new ArrayListWithRepImpl<String>(5);
        
        String e1 = "Hola";
        String e3 = "adios";
        
        lista.add(e1);
        lista.add(e3);
        
        Iterator <String> listaString = lista.iterator();
        
        assertTrue(listaString.hasNext());
        assertEquals(listaString.next(),"Hola");
        listaString.next();
        listaString.next();
	}
	
	@Test
	public void testRemove() throws EmptyCollectionException {
		S2.remove("123",20);
	}
	
	@Test
	public void testRemoveLinked() throws EmptyCollectionException {
		S2.remove("ABC",2);
		assertEquals(S2.count("ABC"),3);
		S2.remove("ABC",5);
	}

	@Test
	public void testAddLinked() throws EmptyCollectionException {
		S2.add("JKL");
	}
	
	@Test(expected=NullPointerException.class)
	public void testRemoveNull() throws Exception {
		S2.remove(null,2);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddNullLinked() throws Exception {
		S2.add(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveTimesBelowCero() throws Exception {
		S2.remove("XYZ",-1);
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testRemoveEmpty() throws Exception {
		S1.remove("XYZ",2);
		S1.remove();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRemoveNoElement() throws Exception {
		S2.remove("JULIO",2);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testNextLinkedRep() throws Exception {
		LinkedListWithRepImpl<String> lista = new LinkedListWithRepImpl<String>();
        
        String e1 = "Hola";
        
        lista.add(e1);
        
        Iterator <String> listaString = lista.iteratorRep();
        
        listaString.next();
        listaString.next();
               
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testNextLinked() throws Exception {
		LinkedListWithRepImpl<String> lista = new LinkedListWithRepImpl<String>();
        
        String e1 = "Hola";
        
        lista.add(e1);
        
        Iterator <String> listaString = lista.iterator();
        
        listaString.next();
        listaString.next();
               
	}
	
	@Test
	public void testAdd() throws EmptyCollectionException {
		S2.add("123",2);
		S2.add("123");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddNull2() throws Exception {
		S2.add(null,2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddBelowCero() throws Exception {
		S2.add("XYZ",-1);
	}
	@Test(expected=NullPointerException.class)
	public void testContainsNull() throws Exception {
		S2.contains(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCountNull() throws Exception {
		S2.count(null);
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void testRemoveEmpty2() throws Exception {
		S1.remove();
	}
}