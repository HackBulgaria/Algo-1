using System;
using System.Collections.Generic;
using System.Linq;

class MainClass
{
	public static void Main ()
	{
		Console.WriteLine ("Welcome to Bubble Sort");
		string sInput = Console.ReadLine ();
		List<string> myList = sInput.Select (c => c.ToString ()).ToList ();

		for (int i = 0; i < myList.Count-1; i++) {
			for (int z = myList.Count-2; z > 0; z--) {
				if (int.Parse(myList[z])<int.Parse(myList[z+1]))
				{
					Swap (myList, z, z + 1);
				}
			}
		}
		for (int i = 0; i < myList.Count; i++)
		{
			Console.Write(myList[i]);
		}
	}
	public static void Swap(IList<string> list, int indexA, int indexB)
	{
		string tmp = list[indexA];
		list[indexA] = list[indexB];
		list[indexB] = tmp;
	}
}