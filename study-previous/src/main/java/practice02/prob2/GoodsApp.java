package practice02.prob2;

import java.util.Scanner;

public class GoodsApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numberOfProducts = 3;
		Goods[] gd = new Goods[numberOfProducts];
		
		for(int i=0; i<numberOfProducts; i++) {
			gd[i] = new Goods();
			gd[i].setProductName(sc.next());
			gd[i].setProductPrice(sc.nextInt());
			gd[i].setProductAmount(sc.nextInt());
		}

		for(int i=0; i<numberOfProducts; i++) {
			System.out.println(
					gd[i].getProductName()
					+ "(����: "
					+gd[i].getProductPrice()
					+"��)�� "
					+gd[i].getProductAmount()
					+"�� �԰� �Ǿ����ϴ�."
					);
		}
		
		
	}

}
