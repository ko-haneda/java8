package ch03.ex07;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SpecializedComparatorTest {

	//正しい順序、大文字小文字区別する、空白含める
	@Test
	public void testDefaultCompare() {
		String[] actual = {"bbb", "aaa", "CCC", " ddd"};
		String[] expected = {" ddd", "CCC", "aaa", "bbb"};
		Arrays.sort(actual,SpecializedComparator.generate(false, true, true));
		for (int i = 0; i < actual.length ; i++) assertTrue(actual[i].equals(expected[i]));
	}
	
	//逆順、大文字小文字区別する、空白含める
	@Test
	public void testReverseCompare() {
		String[] actual = {"bbb", "aaa", "CCC", " ddd"};
		String[] expected = {"bbb", "aaa", "CCC", " ddd"};
		Arrays.sort(actual,SpecializedComparator.generate(true, true, true));
		for (int i = 0; i < actual.length ; i++) assertTrue(actual[i].equals(expected[i]));
	}

	//正しい順序、大文字小文字区別しない、空白含める
	@Test
	public void testIgnoreBigSmallCompare() {
		String[] actual = {"bbb", "aaa", "CCC", " ddd"};
		String[] expected = {" ddd", "aaa", "bbb", "CCC"};
		Arrays.sort(actual,SpecializedComparator.generate(false, false, true));
		for (int i = 0; i < actual.length ; i++) assertTrue(actual[i].equals(expected[i]));
	}

	//正しい順序、大文字小文字区別する、空白含めない
	@Test
	public void testIgnoreSpaceCompare() {
		String[] actual = {"bbb", "aaa", "CCC", " ddd"};
		String[] expected = {"CCC", "aaa", "bbb", " ddd"};
		Arrays.sort(actual,SpecializedComparator.generate(false, true, false));
		for (int i = 0; i < actual.length ; i++) assertTrue(actual[i].equals(expected[i]));
	}
}
