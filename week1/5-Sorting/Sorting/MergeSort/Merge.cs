using System;
using System.Collections.Generic;
using System.Linq;

class SelectionSort
{
	public static void Main()
	{
		int[] myInput = { 1000, 213, 213, 213, 3, 4213, 2132312};
		MergeSort(myInput, 0, myInput.Length - 1);
		for (int i = 0; i < myInput.Length; i++)
		{
			Console.Write(myInput[i]+", ");
		}
		Console.WriteLine ("\nVoilà");
		Console.ReadKey ();
	}
	public static void ShowMe(int[] input)
	{
		Console.WriteLine ("{0}", "Step");
		for (int i = 0; i < input.Length; i++) {
			Console.Write ("{0} ",input[i]);
		}
		Console.WriteLine ();
	}

	public static void MergeSort(int[] input,int startIndex,int endIndex)
	{
		int mid;
		ShowMe(input);
		if (endIndex > startIndex)
		{
			mid = (endIndex + startIndex) / 2;
			MergeSort(input, startIndex, mid);
			MergeSort(input, (mid + 1), endIndex);
			Merge(input, startIndex, (mid + 1), endIndex);
		}
	}

	public static void Merge(int[] input, int left, int mid, int right)
	{

		//Merge procedure takes theta(n) time
		int[] temp = new int[input.Length];
		int i, leftEnd,lengthOfInput,tmpPos;
		leftEnd = mid - 1;
		tmpPos = left;
		lengthOfInput = right - left + 1;

		//selecting smaller element from left sorted array or right sorted array and placing them in temp array.
		while ((left <= leftEnd) && (mid <= right))
		{
			if (input[left] <= input[mid])
			{
				temp[tmpPos++] = input[left++];
			}
			else
			{ 
				temp[tmpPos++]=input[mid++];
			}
		}
		//placing remaining element in temp from left sorted array
		while (left <= leftEnd)
		{
			temp[tmpPos++] = input[left++];
		}

		//placing remaining element in temp from right sorted array
		while (mid <= right)
		{
			temp[tmpPos++] = input[mid++];
		}

		//placing temp array to input
		for (i = 0; i < lengthOfInput;i++ )
		{
			input[right]=temp[right];
			right--;
		}
		ShowMe (temp);
	}
}

