
package assignment;
import java.util.Iterator;
import java.util.LinkedList;


// considering only 13 cities 
// all other cities are not a direct path from arad
// solving for BFS, DFS and A* search
// the cities are in alphabetic order with arr[0][n] being arad and so forth
// the maping of each city on the array is done is the fucntion converter below




public class node 
{
      String m[] = new String[13];
       
    
    int arr[][] = new int[14][14];
    int count = 0; // overall tra array counter
    int tracker = 0; //count of moving variable in the tra array 
    node()
    {
        for(int i = 0;i<14;i++)
        {
            for(int j = 0;j<14;j++)
            {
                arr[i][j] = -1;
            }
        }
    }
    
    
    
    void DFS()
    {
        System.out.println("\n\nDepth First Search\n"); 
        System.out.println(m[0]+" \n");
        int temp;
        count = 0;
        tracker = 0;
        int vis[] = new int[14];
        int tra[] = new int[20];
        tra[0] = 0;
        int y = 0;
        int sum = 0;
        count++;
        int x;
        for(int j = 0;j<14;j++)
        {
            vis[j] = -1;
            tra[j] = 0;
        }
        vis[0] = 1;
        while(true)
        {
            if(tra[tracker] == 1)
            {  
                System.out.println("The sum of DFS = "+sum);
                return;
            }
            else
            {    
                
                temp = tra[tracker];
                for(int j = 0;j<13;j++)
                {
                     
                    //System.out.println("temp = "+temp);
                    if(arr[temp][j] > 0 && vis[j] != 1)
                    {
                        vis[j] = 1;
                        tra[count] = j;
                        count++;
                        sum = sum + arr[y][j];
                        y = j;
                        break;
                    }
                }
                for(int j1 = 0;j1<count;j1++)
                {
                    
                    System.out.print(m[tra[j1]]+"  " );
                    //System.out.print(tra[j1]+"  " );
                }
                System.out.println("\n");
                tracker++;
            }
        }
    }
    
    
    
    void BFS()
    {
        System.out.println("Breadth First Search\n");
        System.out.println(m[0]+" \n");
        int temp;
        int track = 2;
        int vis[] = new int[14];
        int tra[] = new int[20];
        tra[0] = 0;
        count++;
        int x;
        int sum = 1;
        int y = 0;
        for(int j = 0;j<14;j++)
        {
            
            vis[j] = -1;
        }
        vis[0] = 1;
        while(true)
        {
            int temp3 = 0;
            int check = 0;
            for(int o=0;o<13;o++)
            {
                if(tra[o] == 1)
                {
                    for(int q=2;q<13;q++)
                    {
                        for(int r = 0 ; r<13 ;r++)
                        {

                            if(vis[r] == q)
                            {
                                vis[r] = 22;
                                temp3 = r;
                                check = 0;
                                break;
                            }
                        }
                        if(check == 0 && temp3 != 5)
                        {
                            sum = sum + arr[y][temp3];
                            y = temp3;
                            
                            check = 1;
                        }
                    }
                    System.out.println("The sum of BFS = "+sum );
                    return;
                }
            }
            
            
                int m1=0;     
                temp = tra[tracker];
                for(int j = 0;j<13;j++)
                {
                    
                    if(arr[temp][j] > 0 && vis[j] < 0)
                    {
                        if(m1 == 0)
                        {
                            vis[j] = track;
                            m1++;
                        }
                        else
                        {
                            vis[j] = 11;
                        }
                        tra[count] = j;
                        count++;
                    }
                }
                
                for(int j1 = 0;j1<count;j1++)
                {
                    
                    System.out.print(m[tra[j1]]+"  " );

                }
                System.out.println(" ");
                System.out.println("");
                tracker++;
                track++;
            
        }
    }
    
    
    void astar()
    {
        System.out.println("\n\nA star Search\n");
        System.out.println(m[0]+" \n");
        
        int vis[] = new int[14];
        int tra[] = new int[20];
        int hval[] = new int[14];
        
        hval[0] = 366;
        hval[1] = 0;
        hval[2] = 160;
        hval[3] = 242;
        hval[4] = 161;
        hval[5] = 244;
        hval[6] = 241;
        hval[7] = 380;
        hval[8] = 100;
        hval[9] = 193;
        hval[10] = 253;
        hval[11] = 329;
        hval[12] = 374;
        
        for(int j = 0;j<14;j++)
        {
            vis[j] = -1;
            tra[j] = 0;
        }
        int x = 0;
        int sum = 0;
        int temp = 0;
        int test = 0;
        int check = 0;
        while(true)
        {
            int min = 0;
            if(tra[x] == 1)
            {
                System.out.println("\nSum of A* = "+sum);
                return;
            }
            else
            {
                temp = tra[x];
                for(int i=0;i<13;i++)
                {
                    if(arr[temp][i] > 0 && vis[i]<0)
                    {
                        if(test == 0)
                        {
                            
                            min = arr[temp][i] + hval[i];
                            check = i;
                            test++;
                        }
                        else
                        {
                            if(min > arr[temp][i] + hval[i])
                            {
                                min = sum + hval[i];
                                check = i;
                            }
                        }
                        
                        vis[i] = 11;
                    }
                }
                
                sum = sum + arr[temp][check];
                test = 0;
                x++;
                tra[x] = check;
                
                for(int j1 = 0;j1<x+1;j1++)
                {
                    
                    System.out.print(m[tra[j1]]+"  " );
                }
                System.out.println("\n");
            }
        }
    }
    
    
    void makegraph()
    {
        for(int j = 0;j<14;j++)
        {
            arr[j][j] = 0;
        }
        
        arr[0][11] = 118;
        arr[0][10] = 140;
        arr[0][12] = 75;
        
        arr[1][8] = 101;
        arr[1][4] = 211;
        
        arr[2][8] = 138;
        arr[2][9] = 146;
        arr[2][3] = 120;
        
        arr[3][2] = 120;
        arr[3][6] = 75;
        
        arr[4][1] = 211;
        arr[4][10] = 99;
        
        arr[5][6] = 70;
        arr[5][11] = 111;
        
        arr[6][3] = 75;
        arr[6][5] = 70;
        
        arr[7][12] = 71;
        arr[7][10] = 151;
        
        arr[8][9] = 97;
        arr[8][1] = 101;
        arr[8][2] = 138;
        
        arr[9][8] = 97;
        arr[9][10] = 80;
        arr[9][2] = 146;
        
        arr[10][0] = 140;
        arr[10][7] = 151;
        arr[10][4] = 99;
        arr[10][9] = 80;
        
        arr[11][0] = 118;
        arr[11][5] = 111;
        
        arr[12][0] = 75;
        arr[12][7] = 71;
        
        
    }
    void print()
    {
        for(int i = 0;i<14;i++)
        {
            for(int j = 0;j<14;j++)
            {
                System.out.print(arr[i][j]+"   ");
            }
            System.out.println("");
            System.out.println("");
        }
    }
    void converter()
    {
        
        m[0] = "Arad";
        m[1] = "Bucharest";
        m[2] = "Craio va";
        m[3] = "Dorbeta";
        m[4] = "Fagaras";
        m[5] = "Lugo j";
        m[6] = "mehadia";
        m[7] = "Oradea";
        m[8] = "Pitesti";
        m[9] = "Rimanccu Vilcea";
        m[10] = "Sibiu";
        m[11] = "Timisoara";
        m[12] = "Zerind";
        
    }
    
}
