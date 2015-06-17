using System;
using System.Collections.Generic;
using System.Linq;


class MainClass
{
	public static void Main ()
	{
		var liPhoneBook = new List<Tuple<int,string>>();
		liPhoneBook.Add(Tuple.Create(100, "Pesho"));
		liPhoneBook.Add(Tuple.Create(200, "Gosho"));
		liPhoneBook.Add(Tuple.Create(300, "Atanas"));
		liPhoneBook.Add(Tuple.Create(400, "Az"));
		liPhoneBook.Add(Tuple.Create(500, "Ivan"));
		liPhoneBook.Add(Tuple.Create(600, "Ivan Petrov"));
		liPhoneBook.Add(Tuple.Create(900, "Vitosh"));


		List <int> liNumbers = new List<int> (new int[]{900, 300,400,100,600});
		findNumbers (liNumbers, liPhoneBook);
	}

	public static void findNumbers(List<int> liNumbers, List<Tuple<int,string>> liPhoneBook)
	{
		liNumbers.Sort ();
		liPhoneBook.Sort ();
		int iPosition = 0;

		foreach (var item in liNumbers) {
			for (int i = iPosition; i < liPhoneBook.Count; i++) 
			{
				Console.WriteLine (i);
				if (item == liPhoneBook[i].Item1) 
				{
					Console.WriteLine (liPhoneBook[i].Item2);
					iPosition = i+1;
					break;
				}
			}
		}
	}
}
