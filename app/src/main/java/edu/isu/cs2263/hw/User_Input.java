package edu.isu.cs2263.hw;

import static edu.isu.cs2263.hw.Evaluate_Expressions.eval_math_exp;

public class User_Input {
    String expression;
    Double results;
    //create user input object to store both expression and results
    public User_Input(String expr, Double res){
        expression = expr;
        results = res;
    }
    //getter methods
    public String getExpression(){return expression;}
    public Double getResults(){return results;}
    //setter methods
    public void setExpression(String expr){expression = expr;}
    public void setResult(Double res){results = res;}

    public static User_Input acceptInput(String[] args) {
        User_Input input = new User_Input(null,null);
        //if a string is input directly into the command line, evaluate it
        int i = 0;
        //loop across length of command line input
        while (i < args.length) {
            //get the expression from the command line
            String the_expression = args[i];
            //evaluate the expression with the method
            Double the_result = eval_math_exp(the_expression);
            input.setExpression(the_expression);
            input.setResult(the_result);
            //increment up
            i++;
        }

      //  System.out.println(input.getExpression());
        //print the result
        System.out.println(input.getResults());
        //return the input object with expression and result
        return input;
    }

    //exit the program
}
