using System;
using System.Collections.Generic;
using System.Linq;

class SelectionSort
{
	public static void Main ()
	{
		Console.WriteLine ("Welcome to Selection Sort");
		string sInput = Console.ReadLine ();
		List<string> myList = new List<string>(sInput.Select (c => c.ToString ()).ToList ());

		for (int i = 0; i < myList.Count; i++)
		{
			int iPosition = i;
			int iValue = ((int)Char.Parse(myList [i]));
			for (int z = i; z < myList.Count; z++) {
				if (iValue > ((int)Char.Parse (myList [z])))
				{
					iValue = ((int)Char.Parse (myList [z]));
					iPosition = z;
				}
			}
			myList.Insert(i, myList[iPosition]);
			myList.RemoveAt (iPosition+1);
		}

		for (int i = 0; i < myList.Count; i++)
		{
			Console.Write(myList[i]);
		}
	}
}