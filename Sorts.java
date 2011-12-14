import java.util.ArrayList;

public class Sorts {
	
	public static boolean isSorted(ArrayList<Integer> sortedList)
	{
		boolean sorted = true;
		for(int i = 0; i < sortedList.size() - 1; i++)
		{
			if(sortedList.get(i) > sortedList.get(i + 1))
			{
				sorted = false;
				break;
			}
		}
		return sorted;
	}
	
}
