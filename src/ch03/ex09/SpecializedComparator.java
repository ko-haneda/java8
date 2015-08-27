package ch03.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;

public class SpecializedComparator {
	public static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
		return (first, second) -> {
			for (String s : fieldNames) {
				try {
					Field f1 = first.getClass().getDeclaredField(s);
					f1.setAccessible(true);
					Object obj1 = f1.get(first);

					Field f2 = second.getClass().getDeclaredField(s);
					f2.setAccessible(true);
					Object obj2 = f1.get(second);
					
					//「フィールドが異なる場合はその差を返します」は下記でいいのか？
					int result = ((Comparable<Object>) obj1).compareTo(obj2);
					if (result != 0) {
						return result;
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			return 0;
		};
	}
//	public static void main(String[] args) {
//		String first = "aaaa";
//		Field[] f1 = first.getClass().getDeclaredFields();
//		for(Field f: f1){
//			System.out.println(f);
//		}
//	}
}
