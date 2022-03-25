package ule.ed.listwithrep;

import org.junit.Assert;
import org.junit.Test;


public class LinkedListWithRepRefTests extends AbstractListWithRefTests {

	@Override
	protected <T> ListWithRep<T> createListWithRep() {
		
		return new LinkedListWithRepImpl<T>();
	}

}
