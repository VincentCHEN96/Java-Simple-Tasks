class AdditionThread implements Runnable {
	private int sum; // 所有线程的计算结果之和

	public void run() {
		String threadName = Thread.currentThread().getName();
		int end = 10 * Integer.valueOf(threadName); // 通过线程名称获取当前线程要计算的终点数值
		int start = end - 9;// 设置当前线程加法的起点数值
		int isum = 0;
		for (int i = start; i <= end; i++) {
			isum += i;
		}
		System.out.println("线程" + threadName + "计算从" + start + "加到" + end + "的结果为：" + isum);
		sum += isum;
	}

	// 定义方法，显示所有线程的计算结果之和
	public void showSum() {
		System.out.println("所有线程的计算结果之和为："+sum);
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
		} // 主线程休眠，保证主线程中求和结果的正确性
		additionThread.showSum(); // 显示所有线程的计算结果之和
	}

}
