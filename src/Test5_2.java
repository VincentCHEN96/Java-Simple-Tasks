public class Test5_2 {

	public static void main(String[] args) {
		String str = "HelloWorld";
		String str0;
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			if (i == str.length() - 1) {
				str0 = str.substring(i); // ���ַ�����ʽ��ȡ�ַ��������һ���ַ�
			} else {
				str0 = str.substring(i, i + 1); // ���ַ�����ʽ��ȡ�ַ����е�ÿһ���ַ�
			}
			char ch = str0.charAt(0); // ��ȡ���ַ����е��ַ��Ա��жϴ�Сд
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
