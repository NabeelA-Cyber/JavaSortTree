import java.io.*;
import java.util.*;
import java.util.Arrays; 
import TreePackage.BinaryTreeInterface;
import TreePackage.BinaryTree;

public class bTree15 {  
    public static void main(String args[]){
		final int SIZE = 15;
		String wordList[], wordListSorted[];
		wordList = new String[SIZE];
		
		System.out.println("Opening file test.txt and reading word list");
		readData(wordList, SIZE);
		
		System.out.println("\nUnsorted word list: ");
		displayArray(wordList);
		
		
		wordListSorted = Arrays.copyOf(wordList, SIZE);
		Arrays.sort(wordListSorted);
		System.out.println("\n\nSorted Array: ");
		displayArray(wordListSorted);
		
		System.out.println("\nBuilding the full binary tree: ");
 		BinaryTreeInterface<String> nAnt = new BinaryTree<>();
		nAnt.setTree(wordListSorted[0]);
		BinaryTreeInterface<String> nBear = new BinaryTree<>();
		nBear.setTree(wordListSorted[2]);
		BinaryTreeInterface<String> nCat = new BinaryTree<>();
		nCat.setTree(wordListSorted[4]);
		BinaryTreeInterface<String> nDolphine = new BinaryTree<>();
		nDolphine.setTree(wordListSorted[6]);
		BinaryTreeInterface<String> nOrange = new BinaryTree<>();
		nOrange.setTree(wordListSorted[8]);
		BinaryTreeInterface<String> nShark = new BinaryTree<>();
		nShark.setTree(wordListSorted[10]);
		BinaryTreeInterface<String> nWolf = new BinaryTree<>();
		nWolf.setTree(wordListSorted[12]);
		BinaryTreeInterface<String> nZebra = new BinaryTree<>();
		nZebra.setTree(wordListSorted[14]);
		
		BinaryTreeInterface<String> nApple = new BinaryTree<>();
		nApple.setTree(wordListSorted[1], nAnt, nBear);
		BinaryTreeInterface<String> nCheetah = new BinaryTree<>();
		nCheetah.setTree(wordListSorted[5], nCat, nDolphine);
		BinaryTreeInterface<String> nPenguine = new BinaryTree<>();
		nPenguine.setTree(wordListSorted[9], nOrange, nShark);
		BinaryTreeInterface<String> nYear = new BinaryTree<>();
		nYear.setTree(wordListSorted[13], nWolf, nZebra);
		
		BinaryTreeInterface<String> nBird = new BinaryTree<>();
		nBird.setTree(wordListSorted[3], nApple, nCheetah);
		BinaryTreeInterface<String> nTiger = new BinaryTree<>();
		nTiger.setTree(wordListSorted[11], nPenguine, nYear);
		
		BinaryTreeInterface<String> nLion = new BinaryTree<>();
		nLion.setTree(wordListSorted[7], nBird, nTiger);
		
		System.out.println("Root of tree contains: " + nLion.getRootData());
		System.out.println("Height of tree is: " + nLion.getHeight());
		System.out.println("Tree has " + nLion.getNumberOfNodes() + " nodes");
		
		System.out.println("\n\nan inorder tranversal visits nodes in this order:");
		Iterator<String> inorder = nLion.getInorderIterator();
		while (inorder.hasNext())
			System.out.print(inorder.next() + " ");
		System.out.println("");
	}
	public static void displayArray(String w[]) {
		for(String s : w){
            System.out.print(s + " ");
        }
		System.out.println("");
	}
	public static void readData(String wordList[], int size) {
		File file = new File("test.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
			String st; 
			int k=0;
			while ((st = br.readLine()) != null && k<size) {
				//System.out.println(st); 
				wordList[k++] = st;
			}
			br.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not found " + ex);
		}
		catch (IOException e) {
			System.out.println("IOException " + e);
		}		
	}
}