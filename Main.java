import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException
	{
		IOClass ioStream = new IOClass();
		BubbleSort bubble = new BubbleSort();
		MergeSort merge = new MergeSort();
		QuickSort quick = new QuickSort();
		SelectionSort selection = new SelectionSort();
		InsertionSort insertion = new InsertionSort();
		BucketSort bucket = new BucketSort();
		RadixSort radix = new RadixSort();
		HeapSort heap = new HeapSort();
		
		System.out.println("Welcome to the sorting algorithm test chamber.");
		System.out.println("They are running now, the bubblesort is first, so give it a few to catch up");
		
		//bubble.BubbleTime(ioStream);
		merge.MergeTime(ioStream);
		quick.QuickTime(ioStream);
		//selection.SelectionTime(ioStream);
		//insertion.InsertionTime(ioStream);
		//bucket.BucketTime(ioStream);
		radix.RadixTime(ioStream);
		heap.HeapTime(ioStream);
		
		System.out.println("Done!");
		
		ioStream.writeToFile(ioStream.getInputArray());
	}
}
