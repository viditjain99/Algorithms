import java.util.Scanner;
import java.util.ArrayList;
public class dijkstra
{
	public static int min(ArrayList<Integer> dist,ArrayList<Integer> q)
	{
		int i=0;
		int index=i;
		int min=dist.get(q.get(i));
		while(i<q.size())
		{
			if(min>dist.get(q.get(i)))
			{
				min=dist.get(q.get(i));
				index=i;
			}
			i++;
		}
		return index;
	}
	public static void dij(ArrayList<ArrayList<Integer>> conn,ArrayList<ArrayList<Integer>> weight,int N,int source)
	{
		int[] prev=new int[N];
		ArrayList<Integer> q=new ArrayList<Integer>();
		ArrayList<Integer> dist=new ArrayList<Integer>();
		for(int i=0;i<N;i++)
		{
			dist.add(Integer.MAX_VALUE);
			prev[i]=-1;
			q.add(i);
		}
		dist.set(source,0);
		while(q.size()!=0)
		{
			int index=min(dist,q);
			int v=q.get(index);
			q.remove(index);
			for(int i=0;i<conn.get(v).size();i++)
			{
				int d=dist.get(v)+weight.get(v).get(i);
				if(d<dist.get(conn.get(v).get(i)))
				{
					dist.set(conn.get(v).get(i),d);
					prev[conn.get(v).get(i)]=v;
				}
			}
		}
		for(int i=0;i<N;i++)
		{
			System.out.print(dist.get(i)+" ");
		}
		System.out.println();
		for(int i=0;i<N;i++)
		{
			System.out.print(prev[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Scanner a=new Scanner(System.in);
		int N=a.nextInt();
		int[][] graph=new int[N][N];
		ArrayList<ArrayList<Integer>> conn=new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> weight=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N;i++)
		{
			conn.add(new ArrayList<Integer>());
			weight.add(new ArrayList<Integer>());
			for(int j=0;j<N;j++)
			{
				graph[i][j]=a.nextInt();
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(graph[i][j]!=0)
				{
					conn.get(i).add(j);
					weight.get(i).add(graph[i][j]);
				}
			}
		}
		int source=a.nextInt();
		dij(conn,weight,N,source);
	}
}
		
