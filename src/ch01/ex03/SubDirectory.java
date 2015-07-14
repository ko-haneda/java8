package ch01.ex03;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class SubDirectory {

	public List<File> getSubDirectory( File file, String exp) {
//		return Arrays.asList(file.listFiles((path, name) -> (!path.isDirectory() && name.endsWith(exp)))); ファイルにも関わらず、isDirectoryがfalseにならない。あとで検討
		return Arrays.asList(file.listFiles((path, name) -> (path.exists() && name.endsWith(exp))));

		//fileとexpがキャプチャされる変数
	}

}