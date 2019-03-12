import java.text.DecimalFormat;
import java.util.Scanner;

//�����
class RedEnvelope {
	private double amount; // ����ܽ��
	private int total; // ���������
	public static double minAmount; // ��С������
	private double iamount; // ÿ���������ĺ�����
	private double surplusAmount; // ʣ�����ܽ��
	private double maxAmount; // ����������������
	private int luckKing; // �������������
	private DecimalFormat df;

	public RedEnvelope() {

	}

	public RedEnvelope(double amount, int total) {
		this.total = total;
		this.amount = amount;
		this.surplusAmount = amount;
		df = new DecimalFormat("###.##");
		df.setMinimumFractionDigits(2); // �������������ʽ
	}

	// ��ʾ�����ʼ��Ϣ
	public void show() {
		System.out.println("�ܹ���" + df.format(amount) + "Ԫ�����" + total + "���˿���������");
	}

	// ������䷽��
	private double distribution(double sa, int i) {
		double ia = Math.random() * ((sa / (total - i + 1)) * 100 / 93 - RedEnvelope.minAmount) + RedEnvelope.minAmount;
		if (ia < ((sa / (total - i + 1)) * 23 / 24)) {
			return distribution(surplusAmount, i);
		}
		return ia;
	}

	// �ж�������
	private void judgeLuckKing(int i) {
		if (maxAmount <= iamount) {
			maxAmount = iamount;
			luckKing = i;
		}
	}

	// �����
	public void grab() {
		for (int i = 1; i < total; i++) {
			iamount = distribution(surplusAmount, i);
			surplusAmount -= iamount;
			System.out.println("��" + i + "��������" + df.format(iamount) + "Ԫ�����ʣ��" + df.format(surplusAmount) + "Ԫ");
			judgeLuckKing(i); // maxAmountĬ�ϳ�ʼֵΪ0����i=1ʱ������judgeLuckKing(i)���if���ض�������ʵ���˶�maxAmount��luckKing�ĳ�ʼ��
		}
		iamount = surplusAmount; // ���һ�����������е�ʣ�������
		System.out.println("��" + total + "��������" + df.format(iamount) + "Ԫ�������������꣡");
		judgeLuckKing(total);
		System.out.println("����������е�" + luckKing + "����������ѣ�"); // ���㷨��֧�ֵ������ֵ������������ֶ�����ֵʱ��ȡ���һ��
	}
}

// �Զ����쳣��
@SuppressWarnings("serial")
class MyException extends Exception {
	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}
}

public class Test1 {

	public static void main(String[] args) {
		RedEnvelope.minAmount = 0.01; // ������С������
		Scanner in = new Scanner(System.in);
		boolean flag; // ��־λ�������ж��Ƿ�������쳣
		double amount = 0;
		System.out.println("��������Ҫ���ĺ���ܽ�");
		do {
			try {
				amount = input(in);
				flag = false; // δ�����쳣�����ñ�־λΪfalse
			} catch (MyException e) {
				System.out.println(e.getMessage());
				flag = true; // �������쳣�����ñ�־λΪtrue
			}
		} while (flag);
		int total = 0;
		System.out.println("���������ķ�����");
		do {
			try {
				total = input(in, amount);
				flag = false; // δ�����쳣�����ñ�־λΪfalse
			} catch (MyException e) {
				System.out.println(e.getMessage());
				flag = true; // �������쳣�����ñ�־λΪtrue
			}
		} while (flag);
		RedEnvelope redEnvelope = new RedEnvelope(amount, total);
		redEnvelope.show();
		redEnvelope.grab();
	}

	// ���������뷽���������쳣��Ϣ����֤���ݵĺ�����
	public static double input(Scanner in) throws MyException {
		double data = in.nextDouble();
		if (data <= 0) {
			throw new MyException("������������0�����������룺");
		} else if (data < RedEnvelope.minAmount) {
			throw new MyException("�����С���Ϊ" + RedEnvelope.minAmount + "�������õĺ������С�����������룺");
		}
		return data;
	}

	// ����������뷽���������쳣��Ϣ���������أ�����֤���ݵĺ�����
	public static int input(Scanner in, double amount) throws MyException {
		int data = in.nextInt();
		if (data <= 0) {
			throw new MyException("��������������0�����������룺");
		} else if (data * RedEnvelope.minAmount > amount) {
			throw new MyException("ÿ���������С���Ϊ" + RedEnvelope.minAmount + "�������õĺ���������󣬵�ǰ�������޷�������ɴ˷��������������룺");
		}
		return data;
	}

}
