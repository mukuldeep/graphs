/*This java program implements dijkstra's algorithm(also works with negative edge weights)to find single source shortest path.*/
/*The program assumes the maximum value of integer(2147483647) as infinity*/
/*Author:Abhigyan Kole*/
import java.io.*;
import java.util.*;
class dijkstra
{   static ArrayList<Integer> not_reached=new ArrayList<Integer>();//to track which nodes are not yet reached.
    static int time_taken[];
    static int a[][];
    static int n;
    public static void main(String[]Args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();// Input for the number of nodes is taken here.
        a=new int[n+1][n+1];//The matrix representataion for the graph with edge weights.
        for(int i=1;i<n+1;i++)                                         
        {
            for(int j=1;j<n+1;j++)
            {
                a[i][j]=sc.nextInt();//Matrix is taken as input.See sample input below.
            }
            not_reached.add(i);
        }
        
        time_taken=new int[n+1];//Array to store the time.
        int s=sc.nextInt();//The source node is taken as input.
        calculate(s);//call to calculate function to calculate minimum reach time.
        System.out.print("The time taken for the nodes to be reached are:- ");
        for(int j=1;j<n+1;j++)
        {
            System.out.print(time_taken[j]+" ");
        }
    }
    public static void calculate(int s)//function to calculate the shorest time.
    {   
        int pos=0;
        Arrays.fill(time_taken,Integer.MAX_VALUE);
        time_taken[s]=0;
        while(not_reached.size()>0)
        {   
            int min=Integer.MAX_VALUE;
            for(int i:not_reached)
            {
                if(min>=time_taken[i])
                {
                   min=time_taken[i];
                   pos=i;
                }
            }
            for(int i=1;i<n+1;i++)
            {   
                if(a[pos][i]!=0)
                {
                  if(time_taken[i]>min+a[pos][i])
                  {
                    time_taken[i]=min+a[pos][i];
                  }
                }
            }
            not_reached.remove(new Integer(pos));
           
        }
        
    }
    
}
/*
Sample Input 1.
7
0  10 80  0  0  0   0
10 0  6   0  20 0   0
80 6  0   70 0  0   0
0  0  70  0  0  0   0
0  20 0   0  0  50  10
0  0  0   0  50 0   5
0  0  0   0  10 5   0
1
Sample Output
The time taken for the nodes to be reached are:- 0 10 16 86 30 45 40

Sample Input 2.
8
0 10  0 0 0  0 0 8
0  0  0 0 0  2 0 0
0  1  0 1 0  0 0 0
0  0  0 0 3  0 0 0
0  0  0 0 0 -1 0 0
0  0 -2 0 0  0 0 0
0 -4  0 0 0 -1 0 0
0  0  0 0 0  0 1 0
1
Sample Output 
The time taken for the nodes to be reached are:- 0 5 5 6 9 7 9 8
*/
    
