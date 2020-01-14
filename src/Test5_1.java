public class Test5_1 {

	public static void main(String[] args) {
		String str = "HelloWorld";
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i); // 获取字符串中的每个字符
			String str0 = ch + ""; // 将该字符转换成字符串以便调用toLowerCase()和toUpperCase()进行大小写转换
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
