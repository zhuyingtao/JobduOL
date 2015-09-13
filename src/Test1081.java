import java.util.Scanner;

/**
 * @ClassName Test1081
 * @Description TODO
 * @author Zhu Yingtao
 * @date 2015��6��30�� ����2:33:41
 */
public class Test1081 {

	static int mod = 10000;

	static class Matrix {
		int a00;
		int a01;
		int a10;
		int a11;

		public Matrix(int a00, int a01, int a10, int a11) {
			this.a00 = a00;
			this.a01 = a01;
			this.a10 = a10;
			this.a11 = a11;
		}

		public Matrix multiply(Matrix m) {
			int t00 = (a00 * m.a00 + a01 * m.a10) % mod;
			int t01 = (a00 * m.a01 + a01 * m.a11) % mod;
			int t10 = (a10 * m.a00 + a11 * m.a10) % mod;
			int t11 = (a10 * m.a01 + a11 * m.a11) % mod;
			return new Matrix(t00, t01, t10, t11);
		}
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int a0 = scan.nextInt();
			int a1 = scan.nextInt();
			int p = scan.nextInt();
			int q = scan.nextInt();
			int k = scan.nextInt();

			if (k == 0) {
				System.out.println(a0 % 10000);
			} else if (k == 1) {
				System.out.println(a1 % 10000);
			} else {
				Matrix base = new Matrix(p, q, 1, 0);
				Matrix result = power(base, k - 1); // �����k-1����
				int an = (result.a00 * a1 + result.a01 * a0) % mod;
				System.out.println(an);
			}
		}
		scan.close();
	}

	public static Matrix power(Matrix m, int n) { // �������㷨
		Matrix result = new Matrix(1, 0, 0, 1); // ��ʼ��λ����
		while (n != 0) { // ����ת��Ϊ������
			if ((n & 1) == 1) // �����λ�Ƿ�Ϊ1������1��ʾҪ��
				result = result.multiply(m);
			m = m.multiply(m);// ������Ŀ�����
			n = n >> 1; // ����1λ
		}
		return result;
	};
}
