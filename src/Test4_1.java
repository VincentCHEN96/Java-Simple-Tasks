class AdditionThread implements Runnable {
	private int sum; // �����̵߳ļ�����֮��

	public void run() {
		String threadName = Thread.currentThread().getName();
		int end = 10 * Integer.valueOf(threadName); // ͨ���߳����ƻ�ȡ��ǰ�߳�Ҫ������յ���ֵ
		int start = end - 9;// ���õ�ǰ�̼߳ӷ��������ֵ
		int isum = 0;
		for (int i = start; i <= end; i++) {
			isum += i;
		}
		System.out.println("�߳�" + threadName + "�����" + start + "�ӵ�" + end + "�Ľ��Ϊ��" + isum);
		sum += isum;
	}

	// ���巽������ʾ�����̵߳ļ�����֮��
	public void showSum() {
		System.out.println("�����̵߳ļ�����֮��Ϊ��"+sum);
	}
}

public class Test4_1 {

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
