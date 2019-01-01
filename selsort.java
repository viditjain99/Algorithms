import java.util.Scanner;
public class selsort
{
	public static int sort(int[] a,int n)
	{
		return sort(a,0,n-1);
	}
	private static int sort(int []a,int low,int high)
	{
		if(low>high)
		{
			return -1;
		}
		int min=low;
		for(int i=low+1;i<=high;i++)
		{
			if(a[i]<a[min])
			{
				min=i;
			}
		}
		int temp=a[low];
		a[low]=a[min];
		a[min]=temp;
		return sort(a,low+1,high);
	}
	public static void main(String[] args)
	{
		Scanner b=new Scanner(System.in);
		System.out.print("Enter n:");
		int n=b.nextInt();
		int arr[];
		arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=b.nextInt();
		}
		sort(arr,n);
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
}
		
