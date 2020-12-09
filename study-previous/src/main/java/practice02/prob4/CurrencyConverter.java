package practice02.prob4;

public class CurrencyConverter {

	   private static double rate;

	   public static double  toDollar(double won) {
		   
	      // �ѱ� ��ȭ�� �޷��� ��ȯ
			return won / rate;
	   }
	   public static double  toKRW(double dollar) {
	      // �޷��� �ѱ� ��ȭ�� ��ȯ
			return dollar * rate;
	   }
	   public static void setRate(double r) {
	       // ȯ�� ����(KRW/$1)
		   rate = r;
	   }
	}
