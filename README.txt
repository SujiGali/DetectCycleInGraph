APPLICATION TO DETECT CYCLE IN A DIRECTED GRAPH
----------------------------------------------

INTRODUCTION
This application uses depth first search to detect cycle in  a directed graph.If a cycle exists, then the cycle is printed and if it does not exist, then a topological order of the vertices is printed.

ABOUT THE PROGRAM

The program takes the input value of n,representing number of nodes in the directed graph and an n by n adjacency matrix representing the graph. Using depth first search it is determined whether any cycle exists in the graph and if a cycle exists then the cycle is printed and if it does not esist then the topological ordering of the vertices is printed.

EXECUTING THE APPLICATION
The .java file can be used and executed in any environment. I have executed the application in Eclipse IDE and following are the steps to execute in Eclipse:
1.Load the project into Eclipse.  
   -Import the project into Eclipse: 
       - Goto File->Import->select "General" folder->select "Existing project into workspace" ->browse the folder and click finish. 
3. Download poi-3.9.jar from the internet and add the jar file to the project.
   -right click on project->build path->configure build path->libraries->add external jar files->browse to the required jar file->add->ok
4. In the program, the source of the input excelsheet file must be changed according to the location of the files in your computer and the input files must be saved in the .xls format.
5. Next Run/Debug DetectCycle.java
    - Navigate to src/prog/DetectCycle.java, and right click to select "Run As =>Java Aplication".
6. For the graph1.xls,a cycle exists and the cycle is printed. For the graph2.xls, no cycle exists so a topological order is printed.


 