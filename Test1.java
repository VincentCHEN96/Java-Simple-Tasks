import java.text.DecimalFormat;
import java.util.Scanner;

//红包类
class RedEnvelope {
	private double amount; // 红包总金额
	private int total; // 红包总数量
	public static double minAmount; // 最小红包金额
	private double iamount; // 每个人抢到的红包金额
	private double surplusAmount; // 剩余红包总金额
	private double maxAmount; // 被抢到的最大红包金额
	private int luckKing; // 抢红包的运气王
	private DecimalFormat df;

	public RedEnvelope() {

	}

	public RedEnvelope(double amount, int total) {
		this.total = total;
		this.amount = amount;
		this.surplusAmount = amount;
		df = new DecimalFormat("###.##");
		df.setMinimumFractionDigits(2); // 设置数据输出格式
	}

	// 显示红包初始信息
	public void show() {
		System.out.println("总共有" + df.format(amount) + "元红包，" + total + "个人可以抢到！");
	}

	// 红包分配方法
	private double distribution(double sa, int i) {
		double ia = Math.random() * ((sa / (total - i + 1)) * 100 / 93 - RedEnvelope.minAmount) + RedEnvelope.minAmount;
		if (ia < ((sa / (total - i + 1)) * 23 / 24)) {
			return distribution(surplusAmount, i);
		}
		return ia;
	}

	// 判断运气王
	private void judgeLuckKing(int i) {
		if (maxAmount <= iamount) {
			maxAmount = iamount;
			luckKing = i;
		}
	}

	// 抢红包
	public void grab() {
		for (int i = 1; i < total; i++) {
			iamount = distribution(surplusAmount, i);
			surplusAmount -= iamount;
			System.out.println("第" + i + "个人抢到" + df.format(iamount) + "元红包，剩下" + df.format(surplusAmount) + "元");
			judgeLuckKing(i); // maxAmount默认初始值为0，当i=1时，方法judgeLuckKing(i)里的if语句必定成立，实现了对maxAmount和luckKing的初始化
		}
		iamount = surplusAmount; // 最后一个人抢到所有的剩余红包金额
		System.out.println("第" + total + "个人抢到" + df.format(iamount) + "元红包，红包已抢完！");
		judgeLuckKing(total);
		System.out.println("本轮抢红包中第" + luckKing + "个人运气最佳！"); // 此算法仅支持单个最大值的情况，当出现多个最大值时，取最后一个
	}
}

// 自定义异常类
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
		RedEnvelope.minAmount = 0.01; // 设置最小红包金额
		Scanner in = new Scanner(System.in);
		boolean flag; // 标志位，用于判断是否出现了异常
		double amount = 0;
		System.out.println("请输入您要发的红包总金额：");
		do {
			try {
				amount = input(in);
				flag = false; // 未出现异常，设置标志位为false
			} catch (MyException e) {
				System.out.println(e.getMessage());
				flag = true; // 出现了异常，设置标志位为true
			}
		} while (flag);
		int total = 0;
		System.out.println("请输入红包的份数：");
		do {
			try {
				total = input(in, amount);
				flag = false; // 未出现异常，设置标志位为false
			} catch (MyException e) {
				System.out.println(e.getMessage());
				flag = true; // 出现了异常，设置标志位为true
			}
		} while (flag);
		RedEnvelope redEnvelope = new RedEnvelope(amount, total);
		redEnvelope.show();
		redEnvelope.grab();
	}

	// 红包金额输入方法并定义异常信息，保证数据的合理性
	public static double input(Scanner in) throws MyException {
		double data = in.nextDouble();
		if (data <= 0) {
			throw new MyException("红包金额必须大于0，请重新输入：");
		} else if (data < RedEnvelope.minAmount) {
			throw new MyException("红包最小金额为" + RedEnvelope.minAmount + "，您设置的红包金额过小，请重新输入：");
		}
		return data;
	}

	// 红包份数输入方法并定义异常信息（方法重载），保证数据的合理性
	public static int input(Scanner in, double amount) throws MyException {
		int data = in.nextInt();
		if (data <= 0) {
			throw new MyException("红包份数必须大于0，请重新输入：");
		} else if (data * RedEnvelope.minAmount > amount) {
			throw new MyException("每个红包的最小金额为" + RedEnvelope.minAmount + "，您设置的红包份数过大，当前红包金额无法被分配成此份数，请重新输入：");
		}
		return data;
	}

}
