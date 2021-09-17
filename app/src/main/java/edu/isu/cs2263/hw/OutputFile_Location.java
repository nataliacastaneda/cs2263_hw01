package edu.isu.cs2263.hw;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

//print input and output to output file location
public class OutputFile_Location {
    public static void output_location(String expression, Double result, File output_file) throws IOException{
        //get the file to write into
        PrintWriter out_file = new PrintWriter(output_file);
        //add the expression to the file
        out_file.println(expression);
        //add the results to the file
        out_file.println(result);
        //close the file
        out_file.close();
    }
}
