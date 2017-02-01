public class DrawingTool {
    public static void main(String[] args) {
        //args[0] is the path to the input file
        if(args.length != 1){
            System.out.println("Usage: java DrawingTool [path to input file]");
        }

        //tool is the main instance for the program
        DrawingTool tool = new DrawingTool();

        //input file parser
        Scanner input = new Scanner(new FileReader(new FileInputStream(args[0])));

    }
}