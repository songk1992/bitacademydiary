package practice01;

public class P1Q5 {

    public static void main(String[] args) {

        int num = 66;

        for(int i=0;i<num;i++){
            check_f369(i);
        }

    }

    private static void check_f369(int arg_num) {
        char[] arr = String.valueOf(arg_num).toCharArray();
        int counter = 0;

        for (char letter: arr) {
            if(letter == '3' || letter == '6' || letter == '9'){
                counter++;
            }
        }

        if(counter > 0){
            System.out.print(arg_num + " ");
            for(int i =0;i<counter;i++){
                System.out.print("짝");
            }
            System.out.println();
        }
    }
}
