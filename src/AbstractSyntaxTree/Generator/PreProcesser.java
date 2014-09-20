package AbstractSyntaxTree.Generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PreProcesser {

	File input;
	File output;
	List<String> microList;
	List<String> microValueList;

	public PreProcesser(File input, File output, List<String> microList,
			List<String> microValueList) {
		if (input == null || output == null)
			throw new NullPointerException();
		if (microList == null)
			microList = new ArrayList<String>();
		if (microValueList == null)
			microValueList = new ArrayList<String>();
		if (microList.size() != microValueList.size())
			throw new IllegalArgumentException();

		this.input = input;
		this.output = output;
		this.microList = microList;
		this.microValueList = microValueList;
	}

	public void Process() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(input)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(output)));

		StringBuffer sb = new StringBuffer();
		char[] buffer = new char[1024];
		int num;
		while ((num = br.read(buffer)) != -1)
			sb.append(buffer, 0, num);

		for (int index = 0; index < microList.size(); ++index) {
			StringBuffer ret = new StringBuffer();
			String s = sb.toString();
			String sub = microList.get(index);
			int pos = 0;
			while (pos < s.length()) {
				char ch = s.charAt(pos);
				if (!isWord(ch)
						|| (pos - 1 >= 0 && isWord(s.charAt(pos - 1)))
						|| pos + sub.length() - 1 >= s.length()
						|| !s.substring(pos, pos + sub.length()).equals(sub)
						|| (pos + sub.length() < s.length() && isWord(s
								.charAt(pos + sub.length())))) {
					ret.append(ch);
					++pos;
				} else {
					ret.append(microValueList.get(index));
					pos += sub.length();
				}
			}
			sb = ret;
		}

		bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}

	private boolean isWord(char ch) {
		if (ch >= 'a' && ch <= 'z')
			return true;
		if (ch >= 'A' && ch <= 'Z')
			return true;
		if (ch >= '0' && ch <= '9')
			return true;
		if (ch == '_')
			return true;
		return false;
	}
}
