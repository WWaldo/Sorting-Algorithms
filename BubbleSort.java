import java.io.IOException;
import java.util.ArrayList;

//BubbleSort
//Runs through data, swapping 2 neighboring data points, and continuing down the list, returning to the beginning once at the end until it is sorted

public class BubbleSort extends Sorts{
	public ArrayList<Integer> bubbleUp(ArrayList<Integer> unsortedList)
	{
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		boolean swapped = true;
		while(swapped)
		{
			swapped = false;
			for(int i = 1; i < unsortedList.size(); i++)
			{
				if(unsortedList.get(i) < unsortedList.get(i - 1))
				{
					//Swapping neighboring data points
					int holder = unsortedList.get(i);
					unsortedList.set(i, unsortedList.get(i - 1));
					unsortedList.set(i - 1, holder);
					swapped = true;
				}
			}
		}
		sortedList = unsortedList;
		return sortedList;
	}
	
	public void BubbleTime(IOClass ioStream) throws IOException
	{
		ioStream.readFromFile();
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
		long timeBefore = System.nanoTime();
		sortedList = bubbleUp(ioStream.getInputArray());
		long timeAfter = System.nanoTime();
		
		double rawTime = timeAfter - timeBefore;
		double timeInMilli = rawTime/1000000;
		
		if(isSorted(sortedList))
		{
			ioStream.setInputArray(sortedList);
			System.out.print("BubbleSort time (in Milli): "); 
			System.out.println(timeInMilli);
		}
		else
		{
			System.out.println("Not sorted!");
		}
	}
}
