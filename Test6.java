import java.io.FileReader;
import java.util.*;

public class Test6 {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("C:/Documents and Settings/Administrator/桌面/test_text.txt");
		int bytes; // 定义一个变量用于记录读取的字符
		char[] ch = new char[189819]; // 定义一个字符数组用于存放读取的一个单词中的英文字母，世界上最长的单词为肌联蛋白（TITIN）的化学名称，共189819个字母
		int i = 0;
		ArrayList<String> list = new ArrayList<String>(); // 定义一个ArrayList集合存放读取的每个单词（含重复）,用于统计单次出现的次数
		HashMap<String, Integer> map = new HashMap<String, Integer>(); // 定义一个HashMap集合存放读取的不重复的单词，用于记录单词出现的次数
		while ((bytes = reader.read()) != -1) {
			if ((bytes >= 65 && bytes <= 90) | (bytes >= 97 && bytes <= 122)) { // 读取的字符是英文字母，则存入字符数组
				ch[i++] = (char) bytes;
			} else { // 读取的字符不是英文字母，则说明一个单词已经读取结束，当前字符数组里存放的就是一个单词
				String str = new String(ch, 0, i); // 将字符数组转换成字符串，即一个单词
				if (ch[0] != '\u0000') { // 避免将开头的空格或符号存入集合
					list.add(str); // 将字符串存入ArrayList集合
					map.put(str, 1); // 将字符串存入HashMap集合并初始化出现次数为1
				}
				for (int k = 0; k < ch.length; k++) {
					if (ch[k] == '\u0000') {
						break;
					}
					ch[k] = '\u0000';
				} // 清空字符数组以便继续存放另一个单词的英文字母
				i = 0;
			}
		}
		System.out.println(list);
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = (String) it.next(); // 从HashMap集合读取一个单词
			int value = 0; // 单词出现的次数
			Iterator<String> it0 = list.iterator();
			while (it0.hasNext()) {
				String str = (String) it0.next();
				if (str.equals(key)) {
					value++;
				}
			} // 遍历ArrayList集合，统计单词出现的次数
			map.put(key, value); // 将单词出现的次数对应存入HashMap集合
		}
		Set<String> keySet0 = map.keySet();
		Iterator<String> it0 = keySet0.iterator();
		while (it0.hasNext()) {
			String key = (String) it0.next();
			System.out.println(key + "出现了" + map.get(key) + "次");
		} // 遍历HashMap集合，输出每个单词出现的次数
		reader.close();
	}

}
