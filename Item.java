/// 
/// Contents: Demonstrate solution to Knapsack Problem.
/// Author:   Zach Liss
/// Date:     2/10/12
///

public class Item
{
	private String name;
	private int size, value;

	/////CONSTRUCTOR/////
	public Item(String name, int size, int value) {
		this.name = name;
		this.size = size;
		this.value = value;
	}
	
	/////ACCESSORS/////
	public String getName() {
		return name;
	}
	public int getSize() {
		return size;
	}
	public int getVal() {
		return value;
	}
}



	