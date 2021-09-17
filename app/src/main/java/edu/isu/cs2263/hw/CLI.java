package edu.isu.cs2263.hw;

import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static edu.isu.cs2263.hw.BatchFile_Reader.readBatch;
import static edu.isu.cs2263.hw.OutputFile_Location.output_location;
import static edu.isu.cs2263.hw.User_Input.acceptInput;

public class CLI {

    public static void cli_options(String[] args) {
        //create options object
        Options options = new Options();

        //add -h, --help -> prints help/usage message
        options.addOption("h", "help", false, "print usage message");
        //add -b <file>, --batch <file> -> processes provided file rather than standard input file
        Option batch = Option.builder("b").longOpt("batch")
                .argName("file")
                .hasArg(true)
                .required(false)
                .desc("batch file containing expressions to evaluate").build();
        //add -o <file>, --output <file> -> sends the output to the provided file and standard output
        Option output = Option.builder("o").longOpt("output")
                .argName("file")
                .hasArg(true)
                .required(false)
                .desc("output file").build();

        options.addOption(batch);
        options.addOption(output);

        //create the parser
        CommandLineParser parser = new DefaultParser();

        try {
            //parse the command line arguments
            CommandLine cmd = parser.parse(options, args);
            //check for options
            if (cmd.hasOption("h")) {
                //print help/usage message
                HelpFormatter formatter = new HelpFormatter();
                System.out.println("Evaluation of simple mathematical Expressions");
                formatter.printHelp("eval", options, true);
            }
            if (cmd.hasOption("b")) {
                File file = new File(cmd.getOptionValue("b"));
                //get file name
                String lib = cmd.getOptionValue("b");
                //process provided file
                System.out.println("Batch value: " + lib);

                //read the batch file and perform the evaluation(s)
                readBatch(file);
                //exit the program
                System.exit(0);

            }
            if (cmd.hasOption("o")) {
                File file = new File(cmd.getOptionValue("o"));
                //get file name
                String lib = cmd.getOptionValue("o");
                //send output to provided file and standard output
                System.out.println("Output value: " + lib);
                int i = 1;
                do{
                Scanner input = new Scanner(System.in);
                System.out.println("Type 'end' when you are finished adding expressions.");
                System.out.print(">");
                //input is name of scanner object
                String new_argument = input.nextLine();
                if (new_argument.equals("end")){
                    i = 0;
                    break;
                    }
               // System.out.println(new_argument);
                String[] new_args = null;

                new_args = new_argument.split(" ");
                User_Input toTxtFile = acceptInput(new_args);
                output_location(toTxtFile.getExpression(), toTxtFile.getResults(), file);

                }while(i != 0);
                //exit the program
                System.exit(0);
            } else {
                acceptInput(args);
                System.exit(0);
            }
        } catch (ParseException | IOException exp) {
            //oops, something went wrong
            System.err.println("Parsing failed. Reason: " + exp.getMessage());
        }
    }
}
