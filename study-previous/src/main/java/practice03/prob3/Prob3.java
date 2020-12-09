package practice03.prob3;

public class Prob3 {
    public static void main(String[] args) {
		char[] array1 = reverse("Hello World");
		printCharArray(array1);
		
		char[] array2 = reverse("Java Programming!");
		printCharArray(array2);
    }


//	문자열의 순서를 뒤집어서 char 배열로 리턴하는 메소드를 구현한다
//	예를 들어 “Hi!” 라는 문자열을 파라미터로 전달 하면 {‘!’, ‘i’, ‘H’ } 배열을 반환 한다.
    public static char[] reverse(String  str)
    {
        char [] arr = str.toCharArray();
        for(int i=0; i<arr.length/2;i++){
            char temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        return arr;
    }


//	char[]을 받아들여 출력한다.
//	{‘!’, ‘i’, ‘H’}   배열을 파라미터로 전달하면 다음과 같이 출력된다.
//  !iH
    public static void printCharArray(char[] array)
    {
        for(char letter : array){
            System.out.print(letter);
        }
        System.out.println();
    }



}