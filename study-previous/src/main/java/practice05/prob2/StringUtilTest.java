package practice05.prob2;

import practice03.prob1.StringUtil;

public class StringUtilTest {
    public static void main(String args[])  {         
        String[] strArr = {"SuperMan", "BatMan", "SpiderMan"}; 
        String resultStr = StringUtil.concatenate( strArr );

        System.out.println( "��� ���ڿ� : " + resultStr ); 
    }
}
