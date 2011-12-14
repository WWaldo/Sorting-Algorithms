import java.io.IOException;
import java.util.ArrayList;

public class InsertionSort extends Sorts{

	public ArrayList<Integer> insertionSort(ArrayList<Integer> unsortedList)
	{
		for(int i = 1; i < unsortedList.size(); i++)
		{
			int j = i - 1;
			boolean done = false;
			//Checks if list[j+1] is less than list[j]
			//if so, switch, move j back one, continue
			while(!done)
			{
				if(unsortedList.get(j) > unsortedList.get(j + 1))
				{
					swap(unsortedList, j, j + 1);
					j = j - 1;
					if(j < 0)
					{
						done = true;
					}
				}
				else
				{
					done = true;
				}
			}
		}
		return unsortedList;
	}
	
	public void swap(ArrayList<Integer> unsortedList, int swapOne, int swapTwo)
	{
		int holder = unsortedList.get(swapOne);
		unsortedList.set(swapOne, unsortedList.get(swapTwo));
		unsortedList.set(swapTwo, holder);
	}
	
	public void InsertionTime(IOClass ioStream) throws IOException
	{
		ioStream.readFromFile();
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		long timeBefore = System.nanoTime();
		sortedList = insertionSort(ioStream.getInputArray());
		long timeAfter = System.nanoTime();
		
		double rawTime = timeAfter - timeBefore;
		double timeInMilli = rawTime/1000000;
		
		if(isSorted(sortedList))
		{
			ioStream.setInputArray(sortedList);
			System.out.print("InsertionSort time (in Milli): "); 
			System.out.println(timeInMilli);
		}
		else
		{
			ioStream.setInputArray(sortedList);
			System.out.println("Not sorted!");
		}
	}
}
