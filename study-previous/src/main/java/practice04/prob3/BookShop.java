package prob3;

import java.util.Scanner;

public class BookShop {
	public static void main(String[] args) {
		Book[] books = new Book[10];
		books[0] = new Book(1,"Ʈ���϶���","�����Ĵϸ��̾�");
		books[1] = new Book(2,"����","�����Ĵϸ��̾�");
		books[2] = new Book(3,"��Ŭ����","�����Ĵϸ��̾�");
		books[3] = new Book(4,"�극��ŷ��","�����Ĵϸ��̾�");
		books[4] = new Book(5,"�Ƹ���","������");
		books[5] = new Book(6,"�����׵�","�赿��");
		books[6] = new Book(7,"�����ϱ� û���̴�","�賭��");
		books[7] = new Book(8,"��õ","õ��");
		books[8] = new Book(9,"�¹���","������");
		books[9] = new Book(10,"Ǯ�Ͽ콺","������");
		Scanner key = new Scanner(System.in);
		System.out.print("�뿩 �ϰ� ���� å�� ��ȣ�� �Է��ϼ���.:");
		int num = key.nextInt();
		//(1)���⿡ �Է¹��� å��ȣ�� ��ġ�ϴ� å�� rent�� ȣ���ϴ� �ڵ带 �ۼ��ϼ���.

		System.out.println("*****���� ���� ����ϱ�******");
		displayBookInfo(books);
	}

}
