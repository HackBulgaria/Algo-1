using System;

class MainClass
{
	public static void Main ()
	{
		int[] a = {5, 3, 4};
		int[] b = {-2, -1, 6};
		int[] c =  {-1, -2, 4};
		int[] d = {-1, -2, 7};
		Console.WriteLine(zero_quadruplets_count(a,b,c,d));
	}

	//sort before you start
	public static double zero_quadruplets_count(int[]a,int[] b,int[]c,int[]d)
	{
		int result = 0;
		for (int i = 0; i < a.Length; i++) {
			for (int z = 0; z < b.Length; z++) {
				for (int k = 0; k < c.Length; k++) {
					for (int m = 0; m < d.Length; m++) {
						if (a [i] + b [z] + c [k] + d [m] == 0) {
							result++;
							Console.WriteLine ("{0} {1} {2} {3}", a [i], b [z], c [k], d [m]);
						}
					}
				}
			}
		}
		return result;
	}
}
