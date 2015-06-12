using System;
using System.Collections.Generic;
using System.Linq;

class SelectionSort
{
	public static void Main ()
	{
		Console.WriteLine ("Welcome to Insertion Sort");
		string sInput = Console.ReadLine ();
		List<string> myList = new List<string>(sInput.Select (c => c.ToString ()).ToList ());

		for (int z = 0; z < myList.Count; z++)
		{
			for (int x = z; x>0; x--) 
			{
				if((x-1)>=0)
				{
					if ((int)Char.Parse (myList[x]) < (int)Char.Parse (myList[x-1]))
					{
						Swap (myList, x, x - 1);
					}
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
		Console.WriteLine ("{0} {1}",indexA, indexB);
	}
}