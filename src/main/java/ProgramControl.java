
import java.util.ArrayList;

public class ProgramControl {

    private static FileHandler fileHandler = new FileHandler();
    private static CipherDecoder cipherDecoder = new CipherDecoder();

    //run the whole thing
    public static void run(String[] args){

        //list the files if there's no arguments
        if (args.length == 0) {
            ArrayList<String> listOfFiles = fileHandler.listFiles();
            int arrayNumber = 0;
            for (int i = 0; i < listOfFiles.size(); i++){
                arrayNumber += 1;
                System.out.println(arrayNumber + " " + listOfFiles.get(i));
            }
            return;
        }

        //do the rest of the stuff if args > 0
        //runs code from FileHandler and CipherDecoder
        if (args.length >= 1){
            displayFiles(args);
        }
    }

    public static ArrayList<String> listFiles(){
        return fileHandler.listFiles();
    }

    //display the files
    public static void displayFiles(String[] args){
        //args[0] will convert to an int, so this will get the file contents as handled in FileHandler
        int fileNumber = Integer.parseInt(args[0]);
        String fileContents = fileHandler.getFileContent(fileNumber);
        if (fileContents == null){
            System.out.println("Error. file not found");
            return;
        }
        //if it needs to go to the decoder
        //if no key is provided
        if (args.length == 1){
            fileContents = cipherDecoder.decipherDefaultKey(fileContents);
        }
        //if there is a key
        if (args.length == 2){
            fileContents = cipherDecoder.decipherProvidedKey(fileContents, args[1]);
        }
        System.out.println(fileContents);
    }
}
