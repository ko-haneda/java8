package ch08.ex09;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ScannerConversion {
	//TODO

	//単語に変換
	public static Stream<String> wordsStream(Scanner scanner) {
		Iterator<String> iter = new Iterator<String>() {
			String nextLine = null;

			@Override
			public boolean hasNext() {
				if (nextLine != null) {
					return true;
				} else {
					try {
						nextLine = scanner.next();
						return (nextLine != null);
					} catch (NoSuchElementException e) {
						return false;
					}

				}
			}

			@Override
			public String next() {
				if (nextLine != null || hasNext()) {
					String line = nextLine;
					nextLine = null;
					return line;
				} else {
					throw new NoSuchElementException();
				}
			}
		};

		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	//行に変換
	public static Stream<String> linesStream(Scanner scanner) {
		Iterator<String> iter = new Iterator<String>() {
			String nextLine = null;

			@Override
			public boolean hasNext() {
				if (nextLine != null) {
					return true;
				} else {
					try {
						nextLine = scanner.nextLine();
						return (nextLine != null);
					} catch (NoSuchElementException e) {
						return false;
					}
				}
			}

			@Override
			public String next() {
				if (nextLine != null || hasNext()) {
					String line = nextLine;
					nextLine = null;
					return line;
				} else {
					throw new NoSuchElementException();
				}
			}
		};

		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	//TODO	
	//	//整数に変換
	//	public static Stream<String> IntegerStream(Scanner scanner) {
	//		Iterator<Integer> iter = new Iterator<Integer>() {
	//			Integer nextLine = null;
	//
	//			@Override
	//			public boolean hasNext() {
	//				if (nextLine != null) {
	//					return true;
	//				} else {
	//					nextLine = scanner.nextInt();
	//					return (nextLine != null);
	//				}
	//			}
	//
	//			@Override
	//			public Integer next() {
	//				if (nextLine != null || hasNext()) {
	//					Integer line = nextLine;
	//					nextLine = null;
	//					return line;
	//				} else {
	//					throw new NoSuchElementException();
	//				}
	//			}
	//		};
	//		;
	//		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
	//				iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
	//	}
	//	//double値の整数に変換

	public static void main(String[] args) {
		System.out.println("words:\n"
				+ wordsStream(new Scanner("Hello World\nHello World")).collect(Collectors.joining("\n")));
		System.out.println("lines:\n"
				+ linesStream(new Scanner("Hello World\nHello World")).collect(Collectors.joining("\n")));
	}

}

///**
// * Returns a {@code Stream}, the elements of which are lines read from
// * this {@code BufferedReader}.  The {@link Stream} is lazily populated,
// * i.e., read only occurs during the
// * <a href="../util/stream/package-summary.html#StreamOps">terminal
// * stream operation</a>.
// *
// * <p> The reader must not be operated on during the execution of the
// * terminal stream operation. Otherwise, the result of the terminal stream
// * operation is undefined.
// *
// * <p> After execution of the terminal stream operation there are no
// * guarantees that the reader will be at a specific position from which to
// * read the next character or line.
// *
// * <p> If an {@link IOException} is thrown when accessing the underlying
// * {@code BufferedReader}, it is wrapped in an {@link
// * UncheckedIOException} which will be thrown from the {@code Stream}
// * method that caused the read to take place. This method will return a
// * Stream if invoked on a BufferedReader that is closed. Any operation on
// * that stream that requires reading from the BufferedReader after it is
// * closed, will cause an UncheckedIOException to be thrown.
// *
// * @return a {@code Stream<String>} providing the lines of text
// *         described by this {@code BufferedReader}
// *
// * @since 1.8
// */
//public Stream<String> lines() {
//    Iterator<String> iter = new Iterator<String>() {
//        String nextLine = null;
//
//        @Override
//        public boolean hasNext() {
//            if (nextLine != null) {
//                return true;
//            } else {
//                try {
//                    nextLine = readLine();
//                    return (nextLine != null);
//                } catch (IOException e) {
//                    throw new UncheckedIOException(e);
//                }
//            }
//        }
//
//        @Override
//        public String next() {
//            if (nextLine != null || hasNext()) {
//                String line = nextLine;
//                nextLine = null;
//                return line;
//            } else {
//                throw new NoSuchElementException();
//            }
//        }
//    };
//    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
//            iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
//}