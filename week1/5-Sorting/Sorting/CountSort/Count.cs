using System;
using System.Collections.Generic;
using System.Linq;

class MainClass
{
	public static void Main ()
	{
		Console.WriteLine ("Welcome to Count Sort");
		string sInput = Console.ReadLine ();
		List<string> myList = sInput.Select (c => c.ToString ()).ToList ();
		Dictionary<int, int> myDictionary = new Dictionary<int, int> ();

		for (int i = 0; i < 700; i++) {
			myDictionary.Add (i, 0);
		}

		foreach (string sValue in myList)
		{
			myDictionary [(int)Char.Parse (sValue)] ++;
		}

		foreach(KeyValuePair<int, int> pair in myDictionary)
		{
			if (pair.Value>0)
			{
				for (int i = 0; i < pair.Value; i++) {
					Console.Write("{0}",(char)pair.Key);
				}
			}
		}
	}
}