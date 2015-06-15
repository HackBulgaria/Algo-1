using System;

class MainClass
{
	public static void Main ()
	{
		List <int> birthdays = new List<int> ();
		birthdays = {1,1,1,3,4,5,6,6,6,6};
		int[,] ranges =  {{1,100},{23,43},{3,300},{5,300},{32,45},{2,300}};
		birthday_count(birthdays, ranges);
	}
	List<int> list = new List<int>();

	//sort before you start
	public static void birthday_count(int[] birthdaysOriginal, int[,]ranges)
	{
		int[] birthdays = {};
		for (int i = 0; i <= 365; i++) 
		{
			birthdays[i] = Array.Find(birthdaysOriginal, element => element == i);
		}
	}
}
