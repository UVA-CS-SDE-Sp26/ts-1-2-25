import static java.sql.Types.NULL;

/**
 * Commmand Line Utility
 */
//This is the class that the command line stuff will be built in
public class TopSecret {


    //Fields
    private String cipher;
    private int fileNumber;

    //Constructors for 0-2 parameters
    public TopSecret() {
        this.fileNumber = -1;   //-1 indicates that no file was specified, but I don't think these matter as they arn't being used
        this.cipher = "";       //Empty string indicates no cipher was specified
    }

    public TopSecret(int fileNumber) {
        this.fileNumber = fileNumber;
        this.cipher = "";       //Empty string indicates no cipher was specified
    }

    public TopSecret(int fileNumber, String cipher) {
        this.fileNumber = fileNumber;
        this.cipher = cipher;
    }

    //Main
    public static void main(String[] args){
        //Determine # of params and what to do from there
        //No params
        if(args.length == NULL){
            TopSecret listFiles = new TopSecret();
            listFiles.printFileList();

        //1 param - check if first is a number
        } else if (args.length == 1) {
            int fileNumber = isInteger(args[0]);
            if(fileNumber < 1) {
                System.out.println("You entered: " + args[0] + " as the first parameter, but it must a number that is at least 1.");
            }
            TopSecret displayFile = new TopSecret(fileNumber);
            displayFile.printFile(displayFile.getFileNumber(), displayFile.getCipher());

        //2 params - check if first is number, -----check if second is cipher???
        } else if (args.length == 2) {
            int fileNumber = isInteger(args[0]);
            if(fileNumber < 1) {
                System.out.println("You entered: " + args[0] + " as the first parameter, but it must a number that is at least 1.");
            }
            TopSecret displayCipheredFile = new TopSecret(fileNumber, args[1]);
            displayCipheredFile.printFile(displayCipheredFile.getFileNumber(), displayCipheredFile.getCipher());

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

    //TODO - print list of files
    public void printFileList(){
        //Print the list of files
    }

    //TODO - print specified file
    public void printFile(int fileNumber, String cipher){
        //Print the specified file - if cipher is "" then no cipher was specified
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
