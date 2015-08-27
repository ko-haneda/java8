package ch03.ex09;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class SpecializedComparatorTest {

	   @Test
	    public void testLexicographicComparator() {
	        Comparator<TestClass> cmp1 = SpecializedComparator.lexicographicComparator("lastName","secondName", "firstName");
	        assertTrue(cmp1.compare(new TestClass("A", "B", "C"), new TestClass("A", "B", "C")) == 0);
	        assertTrue(cmp1.compare(new TestClass("A", "B", "C"), new TestClass("B", "B", "C")) < 0);
	        assertTrue(cmp1.compare(new TestClass("B", "B", "C"), new TestClass("A", "B", "C")) > 0);
	        
	        assertTrue(cmp1.compare(new TestClass("A", "B", "C"), new TestClass("A", "B", "B")) > 0);
	    }


	    public static class TestClass {

	        public String firstName;
	        public String secondName;
	        public String lastName;

	        public TestClass(String firstName, String secondName, String lastName) {
	            this.firstName = firstName;
	            this.secondName = secondName;
	            this.lastName = lastName;
	        }
	    }
}
