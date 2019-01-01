import java.util.Scanner;
public class quicksort
{
	public static void quickSort(int[] arr,int start,int end)
	{
		if(start<end)
		{
			int pIndex=partition(arr,start,end);
			quickSort(arr,start,pIndex-1);
			quickSort(arr,pIndex+1,end);
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
	public static int partition(int[] arr,int start,int end)
	{
		int pivot=arr[end];
		int pIndex=start;
		for(int i=start;i<end;i++)
		{
			if(arr[i]<=pivot)
			{
				int temp=arr[pIndex];
				arr[pIndex]=arr[i];
				arr[i]=temp;
				pIndex++;
			}
		}
		int temp=arr[pIndex];
		arr[pIndex]=arr[end];
		arr[end]=temp;
		return pIndex;
	}
	public static void main(String[] args)
	{
		Scanner a=new Scanner(System.in);
		int N=a.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=a.nextInt();
		}
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<N;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
