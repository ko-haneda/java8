package ch03.ex07;

import java.util.Comparator;


public class SpecializedComparator {

	/**
	 * 
	 * @param isReverse 逆順の場合はtrue
	 * @param judgeBigSmall　大文字小文字を区別する場合はtrue
	 * @param existsSpace　空白を含む場合はtrue
	 * @return
	 */
	
	public static Comparator<String> generate (boolean isReverse, boolean judgeBigSmall, boolean existsSpace) {
		return (s1, s2) -> {
			int reversed = isReverse ? -1 : 1;
			if (!judgeBigSmall) {
				s1 = s1.toLowerCase();
				s2 = s2.toLowerCase();
			}
			if (!existsSpace) {
				s1 = s1.replaceAll(" ", "");
				s2 = s2.replaceAll(" ", "");
			}
			return s1.compareTo(s2) * reversed;
		};
	}
}
