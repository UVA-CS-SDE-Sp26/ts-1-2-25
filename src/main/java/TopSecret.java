/**
 * Commmand Line Utility
 */
//This is the class that the command line stuff will be built in
public class TopSecret {

    //Fields
    private String cipher;
    private int fileNumber;

    //Constructors for 0-2 parameters
    public TopSecret(String[] args) {
        if(args.length >= 1) {
            setFileNumber(Integer.parseInt(args[0]));
        }
        if(args.length == 2) {
            setCipher(args[1]);
        }
    }

    //Main
    public static void main(String[] args){
        //Determine # of params and what to do from there
        //No params
        if(args.length == 0){
            TopSecret listFiles = new TopSecret(args);
            listFiles.printFileList();

        //1 param - check if first is a number
        } else if (args.length == 1) {
            int fileNumber = isInteger(args[0]);
            System.out.println(fileNumber);
            if(fileNumber < 1) {
                System.out.println("You entered: " + args[0] + " as the first parameter, but it must a number that is at least 1.");
                return;
            }
            TopSecret displayFile = new TopSecret(args);
            displayFile.printFile(args);

        //2 params - check if first is number, -----check if second is cipher???
        } else if (args.length == 2) {
            int fileNumber = isInteger(args[0]);
            if(fileNumber < 1) {
                System.out.println("You entered: " + args[0] + " as the first parameter, but it must a number that is at least 1.");
                return;
            }
            TopSecret displayCipheredFile = new TopSecret(args);
            displayCipheredFile.printFile(args);

        //Some wrong number of params
        }else{
            System.out.println("Sorry this program accepts up to 2 parameters, first a number, and second a string");
        }
    }

    //Try and convert the string to int and return, otherwise, return -1, indicating an error
    public static int isInteger(String str) {
        try{
            int fileNumber = Integer.parseInt(str);
            return fileNumber;
        }catch (NumberFormatException e){
            return -1;
        }
    }

    public void printFileList(){
        //Print the list of files
        ProgramControl.listFiles();
    }

    public void printFile(String[] args){
        //Print the specified file - if cipher is "" then no cipher was specified
        ProgramControl.run(args);
    }

    //Getters and Setters
    public String getCipher() {
        return cipher;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public void setFileNumber(int fileNumber) {
        this.fileNumber = fileNumber;
    }
}
