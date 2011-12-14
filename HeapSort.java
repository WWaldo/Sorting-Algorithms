import java.io.IOException;
import java.util.ArrayList;


public class HeapSort extends Sorts{
	public ArrayList<Integer> heapSort(ArrayList<Integer> unsortedList)
	{
		int count = unsortedList.size();
		heapify(unsortedList, count);
		int end = count-1;
		while(end > 0)
		{
			swap(unsortedList, end, 0);
			end = end - 1;
			siftDown(unsortedList, 0, end);
		}
		return unsortedList;
	}
	public void heapify(ArrayList<Integer> unsortedList, int count)
	{
		int start = count/2 - 1;
		while(start >= 0)
		{
			siftDown(unsortedList, start, count - 1);
			start -= 1;
		}
	}
	public void siftDown(ArrayList<Integer> unsortedList, int start, int end)
	{
		int root = start;
		while(root*2+1 <= end)
		{
			int child = root*2+1;
			int swap = root;
			if(unsortedList.get(swap) < unsortedList.get(child))
			{
				swap = child;
			}
			if(child+1 <= end && unsortedList.get(swap) < unsortedList.get(child+1))
			{
				swap = child+1;
			}
			if(swap != root)
			{
				swap(unsortedList, root, swap);
				root = swap;
			}
			else
			{
				return;
			}
		}
	}
	public void swap(ArrayList<Integer> unsortedList, int swapOne, int swapTwo)
	{
		int holder = unsortedList.get(swapOne);
		unsortedList.set(swapOne, unsortedList.get(swapTwo));
		unsortedList.set(swapTwo, holder);
	}
	
	public void HeapTime(IOClass ioStream) throws IOException
	{
		ioStream.readFromFile();
		ArrayList<Integer> sortedList = new ArrayList<Integer>();

		long timeBefore = System.nanoTime();
		sortedList = heapSort(ioStream.getInputArray());
		long timeAfter = System.nanoTime();
		
		double rawTime = timeAfter - timeBefore;
		double timeInMilli = rawTime/1000000;
		
		if(isSorted(sortedList))
		{
			ioStream.setInputArray(sortedList);
			System.out.print("HeapSort time (in Milli): "); 
			System.out.println(timeInMilli);
		}
		else
		{
			System.out.println("Not sorted!");
		}
	}
}
