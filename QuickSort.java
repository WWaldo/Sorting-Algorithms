import java.io.IOException;
import java.util.ArrayList;

public class QuickSort extends Sorts{
	public ArrayList<Integer> quickSort(ArrayList<Integer> unsortedList)
	{
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
		if(unsortedList.size() <= 1)
		{
			return unsortedList;
		}
		//picking pivot
		//FUTURE CHANGES:
		//Pick better pivot
		int pivot = unsortedList.size()/2;
		int pivotData = unsortedList.get(pivot);
		
		unsortedList.remove(pivot);
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		//Sort into numbers larger and smaller than the pivot
		for(int i = 0; i < unsortedList.size(); i++)
		{
			if(unsortedList.get(i) > pivotData)
			{
				right.add(unsortedList.get(i));
			}
			else
			{
				left.add(unsortedList.get(i));
			}
		}
		//combine the lists
		sortedList = concatinate(quickSort(left), pivotData, quickSort(right));
		return sortedList;
	}
	
	public ArrayList<Integer> concatinate(ArrayList<Integer> left, int pivot, ArrayList<Integer> right)
	{
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for(int i = 0; i < left.size(); i++)
		{
			sortedList.add(left.get(i));
		}
		sortedList.add(pivot);
		for(int i = 0; i < right.size(); i++)
		{
			sortedList.add(right.get(i));
		}
		return sortedList;
	}
	
	public void QuickTime(IOClass ioStream) throws IOException
	{
		ioStream.readFromFile();
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		long timeBefore = System.nanoTime();
		sortedList = quickSort(ioStream.getInputArray());
		long timeAfter = System.nanoTime();
		
		double rawTime = timeAfter - timeBefore;
		double timeInMilli = rawTime/1000000;
		
		if(isSorted(sortedList))
		{
			ioStream.setInputArray(sortedList);
			System.out.print("QuickSort time (in Milli): "); 
			System.out.println(timeInMilli);
		}
		else
		{
			System.out.println("Not sorted!");
		}
	}
}
