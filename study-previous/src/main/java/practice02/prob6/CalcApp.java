package practice02.prob6;

import java.util.*;
import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) throws Exception {
		
		
		String line = "5 + 4";
		String[] tokens = line.split(" ");
		
		int lValue = Integer.parseInt(tokens[0]);
		int rValue = Integer.parseInt(tokens[2]);
		String operator = tokens[1];
		Calc calc;
		
		switch(operator) {
		case"+":{
			calc = new Add();
			OperateCommonFunc(lValue,rValue,calc);
			break;
		}
		case"-":{
			calc = new Sub();
			OperateCommonFunc(lValue,rValue,calc);
			break;
		}
		case"/":{
			calc = new Div();
			OperateCommonFunc(lValue,rValue,calc);
			break;
		}
		case"*":{
			calc = new Mul();
			OperateCommonFunc(lValue,rValue,calc);
			break;
		}
		default :{
			System.out.print("지원하지 않는 연산입니다");
		}
		}
	}

	private static void OperateCommonFunc(int lValue, int rValue, Calc calc) {
		calc.setValue(lValue, rValue);
		System.out.println(calc.calculate());
	}
}
