public class Test5_1 {

	public static void main(String[] args) {
		String str = "HelloWorld";
		StringBuffer sb = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i); // ��ȡ�ַ����е�ÿ���ַ�
			String str0 = ch + ""; // �����ַ�ת�����ַ����Ա����toLowerCase()��toUpperCase()���д�Сдת��
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
