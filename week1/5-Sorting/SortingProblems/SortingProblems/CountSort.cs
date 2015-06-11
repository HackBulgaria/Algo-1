using System;
using System.Collections.Generic;
using System.Linq;

public class CountSort
{
	public static void Main ()
	{
		ConsoleWriteLine ("Welcome to Count Sort");
		string sInput = Console.ReadLine ();
		List<string> myList = sInput.Select (c => c.ToString ()).ToList ();
		Dictionary<int, int> dictionary = new Dictionary<string, int> ();

		for (int i = 0; i < 700; i++) {
			myDictionary.Add (i, 0);
		}

		for (int i = 0; i < len(myDictionary); i++) 
		{
			Console.WriteLine(myDictionary[i]);
		}

	}
}