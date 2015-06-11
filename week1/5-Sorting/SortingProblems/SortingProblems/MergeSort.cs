using System;
using System.Collections.Generic;
using System.Linq;

public class MergeSort
{
	public MergeSort ()
	{
		ConsoleWriteLine ("Welcome to Merge Sort");
		string sInput = Console.ReadLine ();
		List<string> myList = sInput.Select (c => c.ToString ()).ToList ();

		for (int i = 0; i < myList.Count; i++)
		{

		}

		for (int i = 0; i < myList.Count; i++) 
		{
			Console.Write(myList[i]);
		}

	}
}