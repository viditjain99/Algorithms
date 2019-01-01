import java.util.Scanner;
public class mergesort
{
	public static void mergeSort(int[] arr)
	{
		int n=arr.length;
		if(n<2)
		{
			return;
		}
		int mid=n/2;
		int[] left=new int[mid];
		int[] right=new int[n-mid];
		for(int i=0;i<mid;i++)
		{
			left[i]=arr[i];
		}
		for(int i=mid;i<n;i++)
		{
			right[i-mid]=arr[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left,right,arr);
	}
	public static void merge(int[] left,int[] right,int[] arr)
	{
		int nL=left.length;
		int rL=right.length;
		int i=0,j=0,k=0;
		while(i<nL && j<rL)
		{
			if(left[i]<=right[j])
			{
				arr[k]=left[i];
				i++;
				k++;
			}
			else
			{
				arr[k]=right[j];
				j++;
				k++;
			}
		}
		while(i<nL)
		{
			arr[k]=left[i];
			i++;
			k++;
		}
		while(j<rL)
		{
			arr[k]=right[j];
			j++;
			k++;
		}
		for(int x=0;x<arr.length;x++)
		{
			System.out.print(arr[x]+" ");
		}
		System.out.println();
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
		mergeSort(arr);
		for(int i=0;i<N;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
