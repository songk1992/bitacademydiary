package week2.javaoop.practice.P3Q2;

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
					+ "(가격: "
					+gd[i].getProductPrice()
					+"원)이 "
					+gd[i].getProductAmount()
					+"개 입고 되었습니다."
					);
		}
		
		
	}

}
