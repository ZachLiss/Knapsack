///
/// Assignment 2:
/// Contents: Demonstrate solution to Knapsack Problem.
/// Author:   Zach Liss
/// Date:     2/10/12
///

import java.util.*;

public class ShowKnapsack
{
	///
	/// Set up variables needed for experiment:
	///
	public static int INITIAL_CAPACITY = 1;
	public static int MAX_CAPACITY = 100;
	public static int CALLS;
	public static ArrayList<Item>items = new ArrayList<Item>();
	
	public static boolean MEMOIZE;
	public static void main(String[] args)
	{
		///
		/// Create 5 Objects of Item with (NAME, SIZE, VALUE):
		///
		items.add(new Item("A",3,4));
   		items.add(new Item("B",4,5));
  		items.add(new Item("C",7,10));
  		items.add(new Item("D",8,11));
  		items.add(new Item("E",9,13));
  		
  		///
		/// Run experiment:
		///
		for(int capacity = INITIAL_CAPACITY; capacity <= MAX_CAPACITY; capacity++) {
			System.out.println("Capacity: " + capacity);
			
			// Run with memoization:
			MEMOIZE = true;
			CALLS = 0;
			Knapsack knapsack = new Knapsack();
			knapsack = pack(capacity);
			System.out.println("  Memoized recursive calls: " + CALLS);
			
			// Run without memoization:
			MEMOIZE = false;
			CALLS = 0;
			knapsack = pack(capacity);
			System.out.println("  Nonmemoized recursive calls: " + CALLS);
			
			// Print the optimal knapsack:
			System.out.println("  Knapsack: " + knapsack + " (" + knapsack.getVal() + ")");
		}		
	}
	
	
	///
	/// Initial pack method that is overloaded in a recursive call to the memoize version
	///
	public static Knapsack pack(int c)
	{
		Knapsack[] memoArray = new Knapsack[c + 1];
		return pack(c, memoArray);
	}
	///
	/// pack method with memoization implemented:
	///
	public static Knapsack pack(int c, Knapsack[] memo)
	{
		CALLS++;
		if(MEMOIZE && (memo[c] != null)) return memo[c];
				
		Knapsack bestKnapsack = new Knapsack();

		//for each item in I
		for(Item item : items) {
			if(item.getSize() <= c) {	
				// New Knapsack with c + some item
				Knapsack testKnapsack = new Knapsack(pack(c - item.getSize(), memo));
				testKnapsack.addItem(item);

				// if the testKnapsack is more valuable than the current bestKnapsack
				// set the bestKnapsack to the testKnapsack
				if(bestKnapsack.getVal() < testKnapsack.getVal()) {
					bestKnapsack = testKnapsack;
				}
			}
		}
		
		// add the bestKnapsack to the memo and return the bestKnapsack:
		memo[c] = bestKnapsack;
		return bestKnapsack;
	}
}
