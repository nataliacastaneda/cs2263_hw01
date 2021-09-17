package edu.isu.cs2263.hw;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static edu.isu.cs2263.hw.Evaluate_Expressions.eval_math_exp;

public class BatchFile_Reader {
    //method to read batch file given in command line
    public static void readBatch(File batch_file){
        try{
        //scanner object to read the file
        Scanner read_file = new Scanner(batch_file);
        //iterate across each line of the file
        while (read_file.hasNextLine()){
            //take each line as an expression
            String expression = read_file.nextLine();
            //print the expression
            System.out.println(expression);
            //print the results of the evaluation
            System.out.println(eval_math_exp(expression));
        }
        //close the file when all lines are done
        read_file.close();
        }
        catch (FileNotFoundException e){
            //if file is not found, inform user
            System.out.println("File not found. Provide valid filename.");
            //print source of error (excluded for brevity)
           // e.printStackTrace();
        }
    }

}
