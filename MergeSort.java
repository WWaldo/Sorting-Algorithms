import java.io.IOException;
import java.util.ArrayList;

public class MergeSort extends Sorts{
	
	public ArrayList<Integer> mergeSort(ArrayList<Integer> unsortedList)
	{
		if(unsortedList.size() <= 1)
		{
			return unsortedList;
		}
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		int middle = unsortedList.size()/2;
		//Splits the array into unsortedList size lists of size one
		for(int i = 0; i < unsortedList.size(); i++)
		{
			if(i < middle)
			{
				left.add(unsortedList.get(i));
			}
			else
			{
				right.add(unsortedList.get(i));
			}
		}
		left = mergeSort(left); 
		right = mergeSort(right);
		//combines the lists
		sortedList = merge(left, right);
		return sortedList;
	}
	
	public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right)
	{
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		while(left.size() > 0 || right.size() > 0)
		{
			if(left.size() > 0 && right.size() > 0)
			{
				if(left.get(0) < right.get(0))
				{
					mergedList.add(left.get(0));
					left.remove(0);
				}
				else
				{
					mergedList.add(right.get(0));
					right.remove(0);
				}
			}
			else if(left.size() > 0)
			{
				mergedList.add(left.get(0));
				left.remove(0);
			}
			else if(right.size() > 0)
			{
				mergedList.add(right.get(0));
				right.remove(0);
			}
		}
		return mergedList;
	}
	
	public void MergeTime(IOClass ioStream) throws IOException
	{
		ioStream.readFromFile();
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		long timeBefore = System.nanoTime();
		sortedList = mergeSort(ioStream.getInputArray());
		long timeAfter = System.nanoTime();
		
		double rawTime = timeAfter - timeBefore;
		double timeInMilli = rawTime/1000000;
		
		if(isSorted(sortedList))
		{
			ioStream.setInputArray(sortedList);
			System.out.print("MergeSort time (in Milli): "); 
			System.out.println(timeInMilli);
		}
		else
		{
			System.out.println("Not sorted!");
		}
	}
}
