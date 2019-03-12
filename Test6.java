import java.io.FileReader;
import java.util.*;

public class Test6 {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("C:/Documents and Settings/Administrator/����/test_text.txt");
		int bytes; // ����һ���������ڼ�¼��ȡ���ַ�
		char[] ch = new char[189819]; // ����һ���ַ��������ڴ�Ŷ�ȡ��һ�������е�Ӣ����ĸ����������ĵ���Ϊ�������ף�TITIN���Ļ�ѧ���ƣ���189819����ĸ
		int i = 0;
		ArrayList<String> list = new ArrayList<String>(); // ����һ��ArrayList���ϴ�Ŷ�ȡ��ÿ�����ʣ����ظ���,����ͳ�Ƶ��γ��ֵĴ���
		HashMap<String, Integer> map = new HashMap<String, Integer>(); // ����һ��HashMap���ϴ�Ŷ�ȡ�Ĳ��ظ��ĵ��ʣ����ڼ�¼���ʳ��ֵĴ���
		while ((bytes = reader.read()) != -1) {
			if ((bytes >= 65 && bytes <= 90) | (bytes >= 97 && bytes <= 122)) { // ��ȡ���ַ���Ӣ����ĸ��������ַ�����
				ch[i++] = (char) bytes;
			} else { // ��ȡ���ַ�����Ӣ����ĸ����˵��һ�������Ѿ���ȡ��������ǰ�ַ��������ŵľ���һ������
				String str = new String(ch, 0, i); // ���ַ�����ת�����ַ�������һ������
				if (ch[0] != '\u0000') { // ���⽫��ͷ�Ŀո����Ŵ��뼯��
					list.add(str); // ���ַ�������ArrayList����
					map.put(str, 1); // ���ַ�������HashMap���ϲ���ʼ�����ִ���Ϊ1
				}
				for (int k = 0; k < ch.length; k++) {
					if (ch[k] == '\u0000') {
						break;
					}
					ch[k] = '\u0000';
				} // ����ַ������Ա���������һ�����ʵ�Ӣ����ĸ
				i = 0;
			}
		}
		System.out.println(list);
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = (String) it.next(); // ��HashMap���϶�ȡһ������
			int value = 0; // ���ʳ��ֵĴ���
			Iterator<String> it0 = list.iterator();
			while (it0.hasNext()) {
				String str = (String) it0.next();
				if (str.equals(key)) {
					value++;
				}
			} // ����ArrayList���ϣ�ͳ�Ƶ��ʳ��ֵĴ���
			map.put(key, value); // �����ʳ��ֵĴ�����Ӧ����HashMap����
		}
		Set<String> keySet0 = map.keySet();
		Iterator<String> it0 = keySet0.iterator();
		while (it0.hasNext()) {
			String key = (String) it0.next();
			System.out.println(key + "������" + map.get(key) + "��");
		} // ����HashMap���ϣ����ÿ�����ʳ��ֵĴ���
		reader.close();
	}

}
