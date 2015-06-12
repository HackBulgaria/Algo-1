//From http://codereview.stackexchange.com/questions/47128/quicksort-c-implementation

using System;
using System.Collections.Generic;

public class Test
{
	static List<int> RandomList(int size) {
		List<int> ret = new List<int>(size);
		Random rand = new Random(1);
		for (int i = 0; i < size; i++) {
			ret.Add(rand.Next(size));
		}
		return ret;
	}

	static int MyPartition(List<int> list, int left, int right)
	{
		int start = left;
		int pivot = list[start];
		left++;
		right--;

		while(true)
		{
			while(left <= right && list[left] <= pivot)
				left++;

			while(left <= right && list[right] > pivot)
				right--;

			if(left > right)
			{
				list[start] = list[left - 1];
				list[left - 1] = pivot;

				return left;
			}


			int temp = list[left];
			list[left] = list[right];
			list[right] = temp;

		}
	}

	static void MyQuickSort(List<int> list, int left, int right)
	{
		if(list == null || list.Count <= 1)
			return;

		if(left < right)
		{
			int pivotIdx = MyPartition(list, left, right);
			//Console.WriteLine("MQS " + left + " " + right);
			//DumpList(list);
			MyQuickSort(list, left, pivotIdx - 1);
			MyQuickSort(list, pivotIdx, right);
		}
	}

	static void DumpList(List<int> list) {
		list.ForEach(delegate(int val)
			{
				Console.Write(val);
				Console.Write(", ");
			});
		Console.WriteLine();
	}

	public static void Main()
	{
		List<int> list = RandomList(100);
		DumpList(list);
		MyQuickSort(list, 0, list.Count);
		DumpList(list);
	}
}