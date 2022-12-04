/* @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
public class DirectoryTree {
    private DirectoryNode root;
    private DirectoryNode cursor;
    String path = "";

    public DirectoryTree(){
        root = new DirectoryNode("root", null, null, null, false);
        this.cursor = root;
        path += root.getName();
    }

    // This method moves the cursor to the root node of the tree.
    public void resetCursor(){
        cursor = root;
        path = "";
        path += root.getName();
    }
    /* This method moves the cursor to the directory with the name indicated by name.
     * It also checks whether the name references is a valid directory or not.
     * And if the name is a file then it throw an Exception.
     */
    public void changeDirectory(String name) throws NotADirectoryException{

        if(cursor.isFile() == true)  throw new NotADirectoryException();

        if(cursor.getLeft().getName().equals(name)){
            cursor = cursor.getLeft();
            path += "/" + cursor.getName();

        }else if(cursor.getMiddle().getName().equals(name)){
            cursor = cursor.getMiddle();
            path += "/" + cursor.getName();

        }else if(cursor.getRight().getName().equals(name)){
            cursor = cursor.getRight();
            path += "/" + cursor.getName();
        }
    }

    // This is a helper method for presentWorkingDirectory function.
    // It checks whether the name of the node is equal to the cursor and then
    // It returns the node name. It also check the left, middle and right node and
    // then add it to the string.
    public String workingDirectoryHelper(DirectoryNode node){
        String string = "";

        if(node.getName().equals(cursor.getName())){
            return node.getName();
        }

        if(node.getLeft() != null){
            string += workingDirectoryHelper(node.getLeft());
        }
        if(node.getMiddle() != null){
            string += workingDirectoryHelper(node.getMiddle());
        }
        if(node.getRight() != null){
            string += workingDirectoryHelper(node.getRight());
        }
        return string;
    }
    /* It returns a String containing the path of directory names from the root node of the tree
       to the cursor, with each name separated by a forward slash "/". And rhe cursor remains at
       the same DirectoryNode.
     */
    public String presentWorkingDirectory(){
        return path;
    }

    /* This method returns a String containing a space-separated list of names
       of all the child directories or files of the cursor. And the cursor remains
       at the same DirectoryNode.
     */
    public String listDirectory(){
        String string = " ";

        if(cursor.getLeft() != null){
            string += cursor.getLeft().getName() + " ";
        }
        if(cursor.getMiddle() != null){
            string += cursor.getMiddle().getName() + " ";
        }
        if(cursor.getRight() != null){
            string += cursor.getRight().getName() + " ";
        }
        return string;
    }
    // It is a helper method for the printDirectoryTree Function. It prints
    // the left, middle and right node recursively.
    public void printDirectoryhelper(DirectoryNode node){

        if(node.isFile()){
            System.out.println(" -" + node.getName());
        }
        else{
            System.out.println("|-" + node.getName());
        }

        if(node.getLeft() != null){
            System.out.print("  ");
            printDirectoryhelper(node.getLeft());
            System.out.print(" \b");
        }
        if(node.getMiddle() != null){
            System.out.print("  ");
            printDirectoryhelper(node.getMiddle());
            System.out.print(" \b");
        }
        if(node.getRight() != null){
            System.out.print("  ");
            printDirectoryhelper(node.getRight());
            System.out.print(" \b");
        }

    }
    /* It prints a formatted nested list of names of all the nodes in the directory tree,
       starting from the cursor. And the cursor remains at the same DirectoryNode.
     */
    public void printDirectoryTree(){
        printDirectoryhelper(cursor);
    }
    /* It creates a directory with the indicated name and adds it to the children of the cursor node.
       If the name parameter contains a space or forward slace then it throws an
       IllegalArgumentException.
    */
    public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{

        if(name.contains("/") || name.equals("")) throw new IllegalArgumentException();

        DirectoryNode node = new DirectoryNode(name, null, null, null, false);

        if(cursor.getLeft() == null){
            cursor.addChild(node);
        }
        else if(cursor.getMiddle() == null){
            cursor.addChild(node);
        }
        else if(cursor.getRight() == null){
            cursor.addChild(node);
        }
    }
    /* It creates a file with the indicated name and adds it to the children of the cursor node.
       And if the name parameter contains a space or forward slace then it throws an
       IllegalArgumentException.
    */
    public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException{

        if(name.contains("/") || name.equals("")) throw new IllegalArgumentException();

        DirectoryNode node = new DirectoryNode(name, null, null, null, true);

        if(cursor.getLeft() == null){
            cursor.addChild(node);
        }
        else if(cursor.getMiddle() == null){
            cursor.addChild(node);
        }
        else if(cursor.getRight() == null){
            cursor.addChild(node);
        }
    }
}