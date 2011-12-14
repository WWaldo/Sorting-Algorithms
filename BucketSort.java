import java.io.IOException;
import java.util.ArrayList;


public class BucketSort extends Sorts{
	InsertionSort insertion = new InsertionSort();
	public ArrayList<Integer> bucketSort(ArrayList<Integer> unsortedList)
	{
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 10; i++)
		{
			buckets.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < unsortedList.size(); i++)
		{
			int check = 10;
			int arrayToPlace = 0;
			boolean greater = true;
			while(greater)
			{
				if(unsortedList.get(i) > check)
				{
					check = check * 10;
					arrayToPlace++;
				}
				else
				{
					buckets.get(arrayToPlace).add(unsortedList.get(i));
					greater = false;
				}
			}
		}
		for(int i = 0; i < buckets.size(); i++)
		{
			sortedList.addAll(insertion.insertionSort(buckets.get(i)));
		}
		return sortedList;
	}
	
	public void BucketTime(IOClass ioStream) throws IOException
	{
		ioStream.readFromFile();
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		long timeBefore = System.nanoTime();
		sortedList = bucketSort(ioStream.getInputArray());
		long timeAfter = System.nanoTime();
		
		double rawTime = timeAfter - timeBefore;
		double timeInMilli = rawTime/1000000;
		
		if(isSorted(sortedList))
		{
			ioStream.setInputArray(sortedList);
			System.out.print("BucketSort time (in Milli): "); 
			System.out.println(timeInMilli);
		}
		else
		{
			ioStream.setInputArray(sortedList);
			System.out.println("Not sorted!");
		}
	}
}
