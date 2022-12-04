/* @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
import java.util.*;
public class BashTerminal{
    public static void main(String[] args) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException {

        DirectoryTree directoryTree = new DirectoryTree();
        Scanner reader = new Scanner(System.in);

        System.out.println("Starting bash terminal.");
        String command = "";
        while(!command.equals("exit")){
            System.out.print("[tazzaman@Noya]: $ ");
            command = reader.nextLine();

            if(command.equals("pwd")){
                System.out.println(directoryTree.presentWorkingDirectory());
            }
            else if(command.equals("ls")){
                System.out.println(directoryTree.listDirectory());
            }
            else if(command.equals("ls -R")){
                directoryTree.printDirectoryTree();
            }
            else if(command.equals("cd /")){
                directoryTree.resetCursor();
            }
            else if(command.contains("cd")){
                try{
                    directoryTree.changeDirectory(command.substring(3));
                }catch(Exception e){
                    System.out.println("The cursor can't move");
                }
            }
            else if(command.contains("mkdir")){
                try{
                    directoryTree.makeDirectory(command.substring(6));
                }catch(Exception e){
                    System.out.println("Directory can't be created");
                }
            }
            else if(command.contains("touch")){
                try{
                    directoryTree.makeFile(command.substring(6));
                }catch(Exception e){
                    System.out.println("Files can't be created");
                }
            }
            else if(command.equals("exit")){
                System.out.println("Program terminating normally");
                System.exit(0);
            }
        }
        reader.close();
    }
}



