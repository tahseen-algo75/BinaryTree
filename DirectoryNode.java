/* @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
public class DirectoryNode{
    private DirectoryNode left;
    private DirectoryNode middle;
    private DirectoryNode right;
    private String name;
    private boolean isFile = false;

    public DirectoryNode(String name, DirectoryNode left, DirectoryNode middle, DirectoryNode right, boolean isFile){
        this.name = name;
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.isFile = isFile;
    }
    /* @ return
         It returns the name of the DirectoryNode as a String value.
     */
    public String getName(){
        return name;
    }
    /* @ param name
         It can change the name of the DirectoryNode.
     */
    public void setName(String name){
        this.name = name;
    }
    /* @ return
       It returns the left child pointer of the DirectoryNode.
     */
    public DirectoryNode getLeft(){
        return left;
    }
    /* @ return
       It returns the middle child pointer of the DirectoryNode.
     */
    public DirectoryNode getMiddle(){
        return middle;
    }
    /* @ return
       It returns the right child pointer of the DirectoryNode.
     */
    public DirectoryNode getRight(){
        return right;
    }
    /* In this method, it adds newChild to any of the open child positions of the node.
       The newChild has been added as a child of this node. And if there is no room
       for a new node, throw a FullDirectoryException.
     */
    public void addChild(DirectoryNode newChild)throws FullDirectoryException, NotADirectoryException{
        if(left == null){
            left = newChild;
        }
        else if(middle == null){
            middle = newChild;
        }
        else if(right == null){
            right = newChild;
        }
        else{
            throw new FullDirectoryException();
        }
    }
    /* @ return
       This method checks whether the node is a file or not.
     */
    public boolean isFile(){
        return isFile;
    }
}
