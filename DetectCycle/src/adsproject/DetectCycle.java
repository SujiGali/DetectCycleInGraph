package adsproject;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class DetectCycle
{
	static int ancestor[]= new int[50],color[]=new int[50],time[][]=new int[50][2];static int globaltime;static boolean cycle=false;static int linkedlist[]=new int[50];static int top=49;
	public static void main(String[] args)
	{
		int x[][]=new int[100][100];
		try 
		{
		   POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("D:\\charlotte\\academic\\1st sem\\COURSES\\ADS-Keh Chen\\project 2\\Graph2.xls"));
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();
		   

		    int cols = 0; // No of columns
		    int temp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int j = 0; j < 10 || j < rows; j++) 
		    {
		        row = sheet.getRow(j);
		        if(row != null) 
		        {
		            temp = sheet.getRow(j).getPhysicalNumberOfCells();
		            if(temp > cols) cols = temp;
		        }
		    }
		    for(int r = 0; r < rows; r++)
		    {
		        row = sheet.getRow(r);
		        if(row != null)
		        {
		            for(int c = 0; c < cols; c++)
		            {
		                cell = row.getCell((short)c);
		                if(cell != null)
		                {
		                    x[r][c]=(int)cell.getNumericCellValue();
		                }
		            }
		        }
		    }
		    
		    DFS(x);
		    if(!(cycle))
		    {
		    	System.out.println("There is no cycle in the given graph and the topological order is");
		    	for(int i=0;i<50;i++)
		    	{
		    		System.out.print(linkedlist[i]+"  ");
		    		
		    	}
		    }
		    
		} 
		catch(Exception ioe) 
		{
		    
		}
		
	}
	 public static void DFS(int x[][]){
		 for(int k=0;k<50;k++)
		 {
			 color[k]=1;
			 ancestor[k]=-1;
		 }
		 globaltime=0;
		 for(int k=0;k<50;k++)
		 {
			 if(color[k]==1)
			 {
				 DFS_visit(x,k);
			 }
		 }
	 }
	
	
	 public static void DFS_visit(int x[][],int vertex)
	 {
		
		  globaltime=globaltime+1;
		 time[vertex][0]=globaltime;
		 color[vertex]=2;
		 for(int k=0;k<50;k++)
		 {
			 
			 if(x[vertex][k]==1)
			 {
				 if(color[k]==1)
				 {
					 ancestor[k]=vertex;
					 DFS_visit(x,k);
				 }
			  else if(color[k]==2)
			  {
				  if(k!=vertex)
				  {
					 System.out.print("The cycle formed is"+"\n"+vertex+"------->");
					 int n=vertex;
					 while(ancestor[n]!=k)
					 {
						 System.out.print(ancestor[n]+"------->");
						 n=ancestor[n];
					 }
					 System.out.print(k);
					 cycle=true;
				  
				  }
				  else
				  {
					  System.out.println("\n"+"cycle at "+k+" to "+k);
				  }
			 }
		 }}
		 color[vertex]=3;linkedlist[top]=vertex;top--;
		 globaltime=globaltime+1;
		 time[vertex][1]=globaltime;
	 }

}

