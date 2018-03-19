/*This java program finds the shortest path between all pair of nodes.*/
/*Author:Abhigyan Kole*/
import java.io.*;
import java.util.*;
class dijkstra
{   static int infinity;
    static int time_taken[][];
    static int a[][];
    static int n;
    public static void main(String[]Args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();// Input for the number of nodes is taken here.
        a=new int[n+1][n+1];//The matrix representataion for the graph with edge weights.
        ArrayList<Integer> copy_not_reached=new ArrayList<Integer>();
        for(int i=1;i<n+1;i++)                                         
        {
            for(int j=1;j<n+1;j++)
            {
                a[i][j]=sc.nextInt();//Matrix is taken as input.See sample input below.
                if(a[i][j]>0)
                infinity+=a[i][j];//The maximum path length is determined
            }
            copy_not_reached.add(i);
        }
        
        time_taken=new int[n+1][n+1];//DD Array to store the time,with row number denoting starting point.
        for (int[] row: time_taken)
        Arrays.fill(row,infinity);//The time array is initialised with maximum path length.
        for(int i=1;i<n+1;i++)
        {   
            ArrayList<Integer> not_reached=new ArrayList<Integer>(copy_not_reached);
            calculate(i,not_reached);//call to calculate function to calculate minimum reach time.
        }
        for(int y=1;y<n+1;y++)
        {
            for(int u=1;u<n+1;u++)
            {   
                if(time_taken[y][u]==infinity)
                {System.out.print("∞ ");
                continue;}
                System.out.print(time_taken[y][u]+" ");
            }
            System.out.println();
        }
    }
    public static void calculate(int s,ArrayList<Integer> not_reached)//function to calculate the shorest time.
    {   
        int pos=0;
        time_taken[s][s]=0;
        while(not_reached.size()>0)//this loop iterates until all nodes are reached or checked if unreacheable.
        {   
            int min=infinity;//min is initialised to maximum path length.
            for(int i:not_reached)
            {
                if(min>=time_taken[s][i])
                {
                   min=time_taken[s][i];
                   pos=i;
                }
            }
            for(int i=1;i<n+1;i++)
            {   
                if(a[pos][i]!=0)
                {
                  if(time_taken[s][i]>min+a[pos][i])
                  {
                    time_taken[s][i]=min+a[pos][i];//reach times of neighbours are updated if any shorter path is available.
                  }
                }
            }
            not_reached.remove(new Integer(pos));//the node just reached in deleted from the list.
           
        }
    }
}
/*

Sample Input
8
0 10  0 0 0  0 0 8
0  0  0 0 0  2 0 0
0  1  0 1 0  0 0 0
0  0  3 0 0  0 0 0
0  0  0 0 0 -1 0 0
0  0 -2 0 0  0 0 0
0 -4  0 0 0 -1 0 0
0  0  0 0 0  0 1 0

Sample Output
0  5  5  6 ∞  7 9 8 
∞  0  0  1 ∞  2 ∞ ∞ 
∞  1  0  1 ∞  3 ∞ ∞ 
∞  4  3  0 ∞  6 ∞ ∞ 
∞ -2 -3 -2 0 -1 ∞ ∞ 
∞ -1 -2 -1 ∞  0 ∞ ∞ 
∞ -4 -4 -3 ∞ -2 0 ∞ 
∞ -3 -3 -2 ∞ -1 1 0 

*/
