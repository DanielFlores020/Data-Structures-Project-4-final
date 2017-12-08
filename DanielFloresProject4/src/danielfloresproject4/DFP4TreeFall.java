/*
******************************************************
*** Project 4
*** Daniel Flores
******************************************************
*** Created as part of project 4
******************************************************
*** September 30, 2017
******************************************************
*** Original, no changes
******************************************************
 */
package danielfloresproject4;



public class DFP4TreeFall 
{
    private DFP4BTreeNode root;
    private DFP4BTreeNode temp;
    
    public void addWord (String textWord)
    {
        temp = new DFP4BTreeNode();
        temp.word = textWord.toLowerCase();
        
        if (root == null)
        {
            root = temp;
            root.count += 1;
        }
        else if (root.word.compareTo(temp.word) == 0)
        {
            root.count += 1;
        }
        else
        {
            reAdd(root);
        }
    }
    
    private void reAdd(DFP4BTreeNode curWord)
    {
        if (temp.word.compareTo(curWord.leftNode) < 1) //(temp.word = (curWord.leftNode)) < 1
        {
            if (curWord.leftNode == null)
            {
                curWord.leftNode = temp;
            }
            else
            {
                reAdd(curWord.leftNode);
            }
        }
        else if ((temp.word.compareTo(curWord.rightNode)) > 1)
        {
            if (curWord.rightNode == null)
            {
                curWord.rightNode = temp;
            }
            else
            {
                reAdd(curWord.rightNode);
            }
        }
    }
    
    public String display()
    {
        return reDisplay(root);
    }
    
    private String reDisplay(DFP4BTreeNode curWord)
    {
        String tempString = "";
        
        if (curWord.leftNode != null)
        {
            tempString = reDisplay(curWord.leftNode);
        }
        tempString += " " + curWord.word;
        
        if (curWord.rightNode != null)
        {
            tempString += reDisplay(curWord.rightNode);
        }
        
        return tempString;
    }
}
