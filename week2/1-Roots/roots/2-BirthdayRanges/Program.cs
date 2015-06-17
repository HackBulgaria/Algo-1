using System;
using System.Collections.Generic;
using System.Linq;

class MainClass
{
	public static void Main ()
	{
		List <int> liBirthdays = new List<int> (new int[]{1,1,1,3,4,5,6,6,6,6,7,10,100,100,300,300,301});
		List<List<int>> liRanges = new List<List<int>> 
		{
			new List<int>{1,100},   //14
			new List<int>{9,100},   //3
			new List<int>{100,100}, //2
			new List<int>{300,302}, //3

		};
		birthday_count(liBirthdays, liRanges);
	}

	public static void birthday_count(List<int>liBirthdays, List<List<int>>liRanges)
	{
		Dictionary<int, int> myDictionary = new Dictionary<int,int> ();
		List <int> liBirthdaysOrdered = new List<int> ();
		List <int> liBirthdaysSum = new List<int> ();

		int iResult = 0;
		var liOriginal = liBirthdays.GroupBy (i => i);
		int iDays = 367;
		int zero = (int)0;
		int iSum = 0;

		foreach (var l in liOriginal) 
		{
			myDictionary.Add (l.Key, l.Count ());
		}

		for (int i = 0; i < iDays; i++) 
		{
			if (myDictionary.TryGetValue (i, out zero)) 
			{
				liBirthdaysOrdered.Add (myDictionary [i]);
			} 
			else 
			{
				liBirthdaysOrdered.Add (0);
			}
		}

		for (int i = 0; i < liBirthdaysOrdered.Count(); i++) 
		{
			iSum += liBirthdaysOrdered [i];
			liBirthdaysSum.Add (iSum);
		}

		foreach (var item in liRanges) {
			int iBottom = liBirthdaysSum [item [0]-1];
			int iTop = liBirthdaysSum [item [1]];
			int position = iTop - iBottom;
			iResult += position;
		}
		Console.WriteLine (iResult);

	}
}
