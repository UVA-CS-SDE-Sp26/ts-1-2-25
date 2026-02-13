import java.io.File;
import java.util.ArrayList;

public class ProgramControl {

    private static FileHandler fileHandler = new FileHandler();
    private static CipherDecoder cipherDecoder = new CipherDecoder();

    //run the whole thing
    public static void run(String[] args){

        //list the files if there's no arguments
        if (args.length == 0) {
            ArrayList<String> listOfFiles = listFiles();
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


    //make a list of the files
    public static ArrayList<String> listFiles(){
        ArrayList<String> fileList = new ArrayList<>();
        //list files if no args passed
        String datafolder = "data";
        File folder = new File(datafolder);

        //quit if the folder "data" doesn't exist
        if (!folder.exists() || !folder.isDirectory()){
            System.out.println("Error - data folder not found");
            return fileList;
        }

        //only use the .txt files
        File[] files = folder.listFiles(((dir, name) -> name.endsWith(".txt")));
        if (files == null || files.length == 0){ //check if there's any .txt files in the data folder
            System.out.println("No files found in data folder");
            return fileList;
        }

        //add file names to the list
        for (File file: files){
            fileList.add(file.getName());
        }

        return fileList;
    }


    //display the files
    public static void displayFiles(String[] args){
        //args[0] will convert to an int, so this will get the file contents as handled in FileHandler
        int fileNumber = Integer.parseInt(args[0]);
        String fileContents = fileHandler.getFileContent(fileNumber);

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
