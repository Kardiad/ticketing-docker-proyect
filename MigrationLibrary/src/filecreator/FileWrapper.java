package filecreator;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileWrapper {

    File file;

    public FileWrapper(String path){
        this.file = new File(path);
    }

    public String readFile(){
        String read = "";
        try{
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()){
                read += scanner.nextLine()+"\n";
            }
            scanner.close();
        }catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return read;
    }

    public void generateFile(String content) {
        try {
            FileWriter f = new FileWriter(this.file);
            f.write(content);
            f.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
