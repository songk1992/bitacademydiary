
// 	문제 1. 문자열(String)을 입력 받아, 해당 문자열을 문자 순서를 뒤집어서 char[]로 반환하는 메소드를 만들고, char[]을 입력 받아 출력하는 메소드를 만드시오.
//	실행 결과: 
//	This is a pencil
//	This,is,a,pencil


package practice02;

public class P2Q3 {
    public static void main (String args[]) {
        char c[] = {'T','h','i','s',' ','i','s',' ','a',' ','p','e','n','c','i','l','.'};
        printCharArray(c);  // 원래 배열 원소 출력
        replaceSpace(c);    // 공백 문자 바꾸기
        printCharArray(c);  // 수정된 배열 원소 출력
    }

    public static void replaceSpace(char a[]) {
        for(int i=0;i<a.length;i++){
            if(a[i] == ' '){
                a[i] = ',';
            }
        }
    }

    public static void printCharArray(char a[]) {
        for (char letter : a){
            System.out.print(letter);
        }
        System.out.println();
    }

}