import java.io.IOException;
import java.util.ArrayList;


public class RadixSort extends Sorts{
	
	public int[] radixSort(ArrayList<Integer> unsortedList)
	{
		int largestNumber = 0;
		int index = 0;
		//Create storage unit for holding smaller arrays (size = digits of largest number)
		ArrayList<ArrayList<Integer>> storageUnit = new ArrayList<ArrayList<Integer>>();
		int[] sortedList = new int[unsortedList.size()];
		//move everything into sortedList
		for(int i = 0; i < unsortedList.size(); i++)
		{
			sortedList[i] = unsortedList.get(i);
		}		
		//initialize all of the arraylists
		for(int i = 0; i < 10; i++)
		{
			storageUnit.add(new ArrayList<Integer>());
		}
		//find largest number in set
		for(int i = 0; i < unsortedList.size(); i++)
		{
			if(unsortedList.get(i) > largestNumber)
			{
				largestNumber = unsortedList.get(i);
			}
		}
		//run through list, adding the numbers to the buckets based on its key
		for(int i = 0; largestNumber != 0; largestNumber = largestNumber/10, i++)
		{
			for(int j = 0; j < sortedList.length; j++)
			{
				int key = (int) (sortedList[j]/Math.pow(10, i))%10;
				storageUnit.get(key).add(sortedList[j]);
			}
			//the list is then put back together by dumping the buckets from 0 - 9 into the list
			for(int k = 0; k < storageUnit.size(); k++)
			{
				for(int l = 0; l < storageUnit.get(k).size(); l++)
				{
					sortedList[index] = storageUnit.get(k).get(l);
					index++;
				}
				storageUnit.get(k).clear();
			}
			index = 0;
		}
		return sortedList;
	}
	public void RadixTime(IOClass ioStream) throws IOException
	{
		ioStream.readFromFile();
		int[] holderList = new int[ioStream.getInputArray().size()];
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		long timeBefore = System.nanoTime();
		holderList = radixSort(ioStream.getInputArray());
		long timeAfter = System.nanoTime();
		
		for(int i = 0; i < holderList.length; i++)
		{
			sortedList.add(holderList[i]);
		}
		
		double rawTime = timeAfter - timeBefore;
		double timeInMilli = rawTime/1000000;
		
		if(isSorted(sortedList))
		{
			ioStream.setInputArray(sortedList);
			System.out.print("RadixSort time (in Milli): "); 
			System.out.println(timeInMilli);
		}
		else
		{
			ioStream.setInputArray(sortedList);
			System.out.println("Not sorted!");
		}
	}
}
