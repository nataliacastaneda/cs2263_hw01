package edu.isu.cs2263.hw;

//This class contains two methods that can evaluate an expression when given in string form
// (Note: there cannot be spaces in between numbers and operands, and numbers must be single digit)
public class Evaluate_Expressions{
    String expression;

    // method to take number characters and return actual, usable numbers (or doubles, in this case so division is possible for non-integers)
    public static double toDouble(char character){
        double num = 0;

        if (character == '0') {
            num = 0;
        }
        if (character == '1') {
            num = 1;
        }
        if (character == '2') {
            num = 2;
        }
        if (character == '3') {
            num = 3;
        }
        if (character == '4') {
            num = 4;
        }
        if (character == '5') {
            num = 5;
        }
        if (character == '6') {
            num = 6;
        }
        if (character == '7') {
            num = 7;
        }
        if (character == '8') {
            num = 8;
        }
        if (character == '9') {
            num = 9;
        }
        return num;
    }

    //method to evaluate the expressions when given a string
    public static double eval_math_exp(String expression){
        double answer = 0;
        double running_num = 0;

        //go through each character in the string starting at index 1 and going to index length-1 since +,-,*,/ will never be first or last
        for (int i = 1; i < expression.length()-1; i++){
            //taking character at index, previous character, and next character
            char c = expression.charAt(i);
            char last_c = expression.charAt(i-1);
            char next_c = expression.charAt(i+1);
            //if character at index is +
            if (c == '+'){
                //take character at next index as a double
                double next_num = toDouble(next_c);
                //if this is the first operand of the expression
                if (i == 1){
                    //get the preceding number and convert it to a double
                    double first_num = toDouble(last_c);
                    //get the answer as a sum of the numbers surrounding the operand
                    answer = first_num+next_num;
                    //set the running number sum as the value of the answer
                    running_num = answer;}
                //if this is not the first operand of the expression
                if(i != 1){
                    //add the next number to the running number sum
                    answer = running_num+next_num;
                    //set the running number sum as the value of the answer
                    running_num = answer;
                }
            }
            //repeat process of + conditional statements, but for subtraction
            if (c == '-'){
                double next_num = toDouble(next_c);

                if (i == 1){
                    double first_num = toDouble(last_c);
                    answer = first_num-next_num;
                    running_num = answer;}

                if(i != 1){
                    answer = running_num-next_num;
                    running_num = answer;
                }
            }
            //repeat process of + conditional statements, but for multiplication
            if (c == '*'){
                double next_num = toDouble(next_c);

                if (i == 1){
                    double first_num = toDouble(last_c);
                    answer = first_num*next_num;
                    running_num = answer;}

                if(i != 1){
                    answer = running_num*next_num;
                    running_num = answer;
                }
            }
            //repeat process of + conditional statements, but for division
            if (c == '/'){
                double next_num = toDouble(next_c);

                if (i == 1){
                    double first_num = toDouble(last_c);
                    answer = first_num/next_num;
                    running_num = answer;}

                if(i != 1){
                    answer = running_num/next_num;
                    running_num = answer;
                }
            }
        }
        //return the final answer when every operand has been read
        return answer;
    }
}
