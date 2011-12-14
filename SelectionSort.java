import java.io.IOException;
import java.util.ArrayList;

public class SelectionSort extends Sorts{

	public ArrayList<Integer> selectionSort(ArrayList<Integer> unsortedList)
	{
		//Runs through the list
		for(int i = 0; i < unsortedList.size(); i++)
		{
			//moves smallest number to index i
			int index = i;
			for(int j = i + 1; j < unsortedList.size(); j++)
			{
				if(unsortedList.get(index) > unsortedList.get(j))
				{
					index = j;
				}
			}
			if(i != index)
			{
				int holder = unsortedList.get(index);
				unsortedList.set(index, unsortedList.get(i));
				unsortedList.set(i, holder);
			}
		}
		
		return unsortedList;
	}
	
	public void SelectionTime(IOClass ioStream) throws IOException
	{
		ioStream.readFromFile();
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
		long timeBefore = System.nanoTime();
		sortedList = selectionSort(ioStream.getInputArray());
		long timeAfter = System.nanoTime();
		
		double rawTime = timeAfter - timeBefore;
		double timeInMilli = rawTime/1000000;
		
		if(isSorted(sortedList))
		{
			ioStream.setInputArray(sortedList);
			System.out.print("SelectionSort time (in Milli): "); 
			System.out.println(timeInMilli);
		}
		else
		{
			System.out.println("Not sorted!");
		}
	}
}
