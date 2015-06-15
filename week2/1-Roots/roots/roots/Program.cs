using System;

class MainClass
{
	public static void Main ()
	{
		double test = 10000.00;
		double number = square_root (test);
		Console.WriteLine ("Calculation of square root {0}",(test));
		Console.WriteLine (Math.Round(number,5));
	}

	public static double square_root(double myNumber)
	{
		double precision = 0.00001;
		double low = 0;
		double high = myNumber;
		double mid = 0;
		while ((high - low)>precision) 
		{
			mid = (double)((low + high) / 2);
			if ((mid-precision )>= mid * mid && mid * mid <= (precision+mid)) 
			{
				break;
			}
			else if (mid * mid < myNumber) {
				low = mid;
			}
			else 
			{
				high = mid;
			}
		}
		return mid;

	}
}
