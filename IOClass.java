import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class IOClass {
	
	private ArrayList<Integer> inputArray = new ArrayList<Integer>();
	
	public ArrayList<Integer> getInputArray() {
		return inputArray;
	}

	public void setInputArray(ArrayList<Integer> inputArray) {
		this.inputArray = inputArray;
	}

	public void writeToFile(ArrayList<Integer> sortedList){
		//this part was pretty easy, as you said
		String fileName = "results.txt";
		PrintWriter outputStream = null;
		try{
			outputStream = new PrintWriter(fileName);
		}
		catch(FileNotFoundException e){
			System.out.println("Error in opening the file "+fileName);
			System.exit(0);
		}
		//I have it run though each piece of of the arrayList and print in on a new line
		
		for(int i = 0; i < sortedList.size(); i++)
		{
			String output = sortedList.get(i) + " ";
			outputStream.print(output);
		}
		outputStream.close();
	}
	
	public void readFromFile() throws IOException{
		//this part put up a good fight, I ended up taming it in the end
		ArrayList<Integer> overwrite = new ArrayList<Integer>();
		String fileName = "input.txt";
		FileReader input = new FileReader(fileName);
		Scanner reader = new Scanner(input);
		//it basically looks for a piece in the file that starts with a *, which is always a date,
		//then anything after that is added to another string until it hits another *
		while(reader.hasNext()){
			int holder = reader.nextInt();
			overwrite.add(holder);
		}
		inputArray = overwrite;
		input.close();
	}
}
