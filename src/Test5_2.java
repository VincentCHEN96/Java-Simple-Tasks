public class Test5_2 {

	public static void main(String[] args) {
		String str = "HelloWorld";
		String str0;
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			if (i == str.length() - 1) {
				str0 = str.substring(i); // 以字符串形式截取字符串的最后一个字符
			} else {
				str0 = str.substring(i, i + 1); // 以字符串形式截取字符串中的每一个字符
			}
			char ch = str0.charAt(0); // 获取该字符串中的字符以便判断大小写
			if (Character.isUpperCase(ch)) {
				str0 = str0.toLowerCase();
			} else {
				str0 = str0.toUpperCase();
			}
			sb.append(str0);
		}
		System.out.println(sb.toString());
	}

}
