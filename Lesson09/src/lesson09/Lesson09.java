/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson09;

/**
 *
 * @author Wind
 */
public class Lesson09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a = "55-11+33x2+365x2343235";
        char[] operators = {'+', '-', 'x', '/'};
        String[] dataNumber = new String[100];
        char[] dataOperator = new char[100];
        int count = 0;
        String temp = "";
        for (int i = 0; i < a.length(); i++) {
            int index = 0;
            boolean isOperator = false;
            for (int j = 0; j < operators.length; j++) {
                if (a.charAt(i) == operators[j]) {
                    isOperator = true;
                    index = j;
                    break;
                }
            }
            if (isOperator) {
                dataNumber[count] = temp;
                
                dataOperator[count] = a.charAt(i);
                temp = "";
                count++;
            } else {
                temp += a.charAt(i);
            }
        }
        dataNumber[count] = temp;
        count++;
        for (int i = 0; i < count; i++) {
            System.out.println(dataNumber[i]);
            System.out.println(dataOperator[i]);
        }

    }

}
