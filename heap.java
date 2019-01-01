import java.util.Scanner;
class vidit
{
	int size;
	int[] heap;
	int cap;
	public vidit(int n)
	{
		size=0;
		cap=n;
		heap=new int[cap];
	}
	public void heapify(int[] heap,int i)
	{
		int l=2*i+1;
		int r=2*i+2;
		int largest=i;
		if(l<cap && heap[l]>heap[i])
		{
			largest=l;
		}
		if(r<cap && heap[r]>heap[i])
		{
			largest=r;
		}
		if(largest!=i)
		{
			int temp=heap[i];
			heap[i]=heap[largest];
			heap[largest]=temp;
			heapify(heap,largest);
		}
	}
	public void MAX()
	{
		System.out.println(heap[0]);
	}
	public void build()
	{
		for(int i=size/2;i>=0;i--)
		{
			heapify(heap,i);
		}
	}
	public void extract_max()
	{
		if(size==0)
		{
			return;
		}
		else if(size==1)
		{
			System.out.println(heap[0]);
			return;
		}
		else
		{
			int max=heap[0];
			heap[0]=heap[size-1];
			size--;
			System.out.println(max);
			heapify(heap,0);
		}
	}
	public void insert(int num)
	{
		if(size==cap)
		{
			return;
		}
		else
		{
			size++;
			heap[size-1]=num;
			build();
		}
	}
	public void increase_key(int key,int index)
	{
		heap[index]=key;
		int i=index;
		while(i>0 && heap[i]>heap[(i-1)/2])
		{
			int temp=heap[i];
			heap[i]=heap[(i-1)/2];
			heap[(i-1)/2]=temp;
			i=(i-1)/2;
		}
	}
	public void display()
	{
		for(int i=0;i<size;i++)
		{
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}
	public void delete(int index)
	{
		if(size==0)
		{
			return;
		}
		else if(size==1)
		{
			size--;
		}
		else
		{
			for(int i=index;i<size;i++)
			{
				heap[i]=heap[i+1];
			}
			size--;
			heapify(heap,0);
		}
	}
}
public class heap
{
	public static void main(String[] args)
	{
		Scanner a=new Scanner(System.in);
		vidit h=new vidit(11);
		h.insert(5);
    	h.insert(3);
    	h.insert(17);
    	h.insert(10);
    	h.insert(84);
    	h.insert(19);
    	h.insert(6);
    	h.insert(22);
    	h.insert(9);
    	h.display();
    	h.increase_key(95,8);
    	h.display();
    	h.extract_max();
    	h.display();
    	h.delete(0);
    	h.display();
    	//System.out.println(h.extract_max(arr));
	}
}
		
			
