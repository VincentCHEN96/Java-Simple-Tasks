class AdditionThread implements Runnable {
	public static int value = 1; // ���������̼߳ӷ�����㣬������Ϊ�����̵߳Ĺ�����Դ
	private Object lock = new Object(); // ����������
	private int sum; // �����̵߳ļ�����֮��

	public void run() {
		synchronized (lock) {
			String threadName = Thread.currentThread().getName();
			int start = value; // ���õ�ǰ�̼߳ӷ��������ֵ
			int end = start + 9; // ���õ�ǰ�̼߳ӷ����յ���ֵ
			int isum = 0;
			for (int i = start; i <= end; i++) {
				isum += i;
			}
			System.out.println("�߳�" + threadName + "�����" + start + "�ӵ�" + end + "�Ľ��Ϊ��" + isum);
			sum += isum;
			value += 10;
		} // ����ͬ�������ʵ����Դvalue�Ĺ���
	}

	// ���巽������ʾ�����̵߳ļ�����֮��
	public void showSum() {
		System.out.println("�����̵߳ļ�����֮��Ϊ��"+sum);
	}
}

public class Test4_2 {

	public static void main(String[] args) {
		AdditionThread additionThread = new AdditionThread();
		new Thread(additionThread, "1").start();
		new Thread(additionThread, "2").start();
		new Thread(additionThread, "3").start();
		new Thread(additionThread, "4").start();
		new Thread(additionThread, "5").start();
		new Thread(additionThread, "6").start();
		new Thread(additionThread, "7").start();
		new Thread(additionThread, "8").start();
		new Thread(additionThread, "9").start();
		new Thread(additionThread, "10").start();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // ���߳����ߣ���֤���߳�����ͽ������ȷ��
		additionThread.showSum(); // ��ʾ�����̵߳ļ�����֮��
	}

}
