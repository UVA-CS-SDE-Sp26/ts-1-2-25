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
        this.fileNumber = -1;   //-1 indicates that no file was specified
        this.cipher = "";       //Empty string indicates no cipher was specified

        //Call printFileList?
    }

    public TopSecret(int fileNumber) {
        this.fileNumber = fileNumber;
        this.cipher = "";       //Empty string indicates no cipher was specified

        //Call printFile(fileNumber, cipher)?
    }

    public TopSecret(int fileNumber, String cipher) {
        this.fileNumber = fileNumber;
        this.cipher = cipher;

        //Call printFile(fileNumber, cipher)?
    }


    //TODO - print list of files
    public void printFileList(int fileNumber, String cipher){
        //Print the list of files
    }

    //TODO - print specified file
    public void printFile(int fileNumber, String cipher){
        //Print the specified file
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
