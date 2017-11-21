import java.util.*;
import java.io.*;

public class Opdr5Lists
{
	public static void main(String[] args)
	{
		ListsArrays l = new ListsArrays();
		int[] numbers = l.initRandomArray(10);
		
		l.displayArray(numbers);
		l.displayHighestValue(numbers);
		l.displayLowestTwo(numbers);
		l.filterArray(numbers);
		l.splitSortedArray(numbers);
		l.displaySortedArray(numbers);

	}
}

class ListsArrays
{
	final int MIN_NUM = 1;
	final int MAX_NUM = 100;
	
	public int[] initRandomArray(int arrayLength)
	{
		int[] randomNumbers = new int[arrayLength];
		Random r = new Random();

		for(int i = 0; i < randomNumbers.length; i++)
		{
			randomNumbers[i] = r.nextInt(MAX_NUM) + MIN_NUM;
		}

		return randomNumbers;
	}//end initRandomArray

	public void displayArray(int[] randomNumbers)
	{
			System.out.print("The array contains: ");
			for(int i = 0; i < randomNumbers.length; i++)
			{
				System.out.print(randomNumbers[i] + " ");
			}
			
	}//end displayRandomArray


	public void displayHighestValue(int[] randomNumbers)
	{
		int currHighest = MIN_NUM-1; //smallest num possible = MIN_NUM, which could be negative; -1 because it MIN_NUM could or could not be in the array
		for(int i = 0; i < randomNumbers.length; i++)
		{
			if(randomNumbers[i] > currHighest)
				{
					currHighest = randomNumbers[i];
				}
		}

		System.out.print("\nThe highest number in the given array is " + currHighest);
	}//end displayHighestValue

	public void displayLowestTwo(int[] randomNumbers)
	{
		int currLowest = MAX_NUM +1;
		int currSecondLowest = 0;
		
		for(int i = 0; i < randomNumbers.length; i++)
		{
			if(randomNumbers[i] < currLowest)
				{
					currSecondLowest = currLowest;
					currLowest = randomNumbers[i];					
				}
		}

		System.out.print("\nThe lowest 2 numbers in the given array is " + currLowest + " and " + currSecondLowest);
	}

	public void filterArray(int[] randomNumbers)
	{
		System.out.print("\nFiltered array: ");
		for(int i = 0; i < randomNumbers.length; i++)
		{
			if(randomNumbers[i] % 2 == 0)
			{
				System.out.print(randomNumbers[i] + " ");
			}
		}
	}


	public void splitSortedArray(int[] randomNumbers)
	{
		ArrayList<Integer> dividableBy2s = new ArrayList<Integer>();
		ArrayList<Integer> dividableBy3s = new ArrayList<Integer>();
		ArrayList<Integer> dividableBy5s = new ArrayList<Integer>();
		ArrayList<Integer> leftoverNumbers = new ArrayList<Integer>();

		//split
		for(int i = 0; i < randomNumbers.length; i++)
		{
			if(randomNumbers[i] % 2 == 0)
			{
				dividableBy2s.add(randomNumbers[i]);
			}
			else if(randomNumbers[i] % 3 == 0)
			{
				dividableBy3s.add(randomNumbers[i]);
			}
			else if(randomNumbers[i] % 5 == 0)
			{
				dividableBy5s.add(randomNumbers[i]);
			}
			else
			{
				leftoverNumbers.add(randomNumbers[i]);
			}
		}

		//Sort
		dividableBy2s = sortList(dividableBy2s);
		dividableBy3s = sortList(dividableBy3s);
		dividableBy5s = sortList(dividableBy5s);
		leftoverNumbers = sortList(leftoverNumbers);

		//Display
		System.out.println("\nDividable by 2: " + dividableBy2s + "\nDividable by 3: " + dividableBy3s + "\nDividable by 5: " + dividableBy5s + "\nRest: " + leftoverNumbers);
	}

	public void displaySortedArray(int[] randomNumbers)
	{
		int[] sortedNumbers = sortList(randomNumbers);

		displayArray(randomNumbers);
	}

	private ArrayList<Integer> sortList(ArrayList<Integer> toBeSorted)
	{
		int currNum = 0;
		int prevNum = 0;

		for(int pass = 0; pass < toBeSorted.size(); pass++)
		{
			for (int i = 1; i < toBeSorted.size(); i++)
					{
						currNum = toBeSorted.get(i);
						prevNum = toBeSorted.get(i-1);

						if(toBeSorted.get(i -1) > toBeSorted.get(i))
						{
							toBeSorted.set(i,prevNum);
							toBeSorted.set(i-1, currNum);
						}
					}
		}
		
		return toBeSorted;
	}

	public int[] sortList(int[] toBeSorted)
	{
		int currNum = 0;
		int prevNum = 0;

		for(int pass = 0; pass < toBeSorted.length; pass++)
		{
			for (int i = 1; i < toBeSorted.length; i++)
					{
						currNum = toBeSorted[i];
						prevNum = toBeSorted[i-1];

						if(toBeSorted[i -1] > toBeSorted[i])
						{
							toBeSorted[i] = prevNum;
							toBeSorted[i-1] = currNum;
						}
					}
		}
		
		return toBeSorted;
	}

}




