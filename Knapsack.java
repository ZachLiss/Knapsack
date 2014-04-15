/// 
/// Contents: Demonstrate solution to Knapsack Problem.
/// Author:   Zach Liss
/// Date:     2/10/12
///

import java.util.*;

public class Knapsack
{
	private int totalValue;
	private ArrayList <Item> packedItems = new ArrayList<Item>();
	
	/////CONSTRUCTORS/////
	public Knapsack() {
		totalValue = 0;
	}
	public Knapsack(Knapsack k) {
		totalValue = k.getVal();
		for(Item item: k.getItems()) {
			packedItems.add(item);
		}
	}

	/////ACCESSORS/////
	public int getVal() {
		int printVal = 0;
		
		for(int i = 0; i < packedItems.size(); i++) {
			printVal = printVal + packedItems.get(i).getVal();
		}
		return printVal;
	}
	public ArrayList <Item> getItems() {
		return packedItems;
	}
	
	/////MUTATOR/////
	public void addItem(Item i) {
		packedItems.add(i);
		totalValue = totalValue + i.getVal();
	}

	/////toString/////
	public String toString() {
		StringBuilder b = new StringBuilder();
		for(Item item : packedItems) {
				b.append(item.getName() + " ");
		}
		return b.toString();
	}
}