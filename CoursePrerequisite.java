//Jose Mora
//5-25-16

import java.util.Scanner;
public class CoursePrerequisite 
{	
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		String preReq, courseName; //source and target initialization 
		
		System.out.println("Enter total courses: ");
		int numCourses = s.nextInt();
		Graph<String> graph = new Graph<String>(numCourses);
		
		int choice;
		do {
			System.out.println("-----Enter 0 to quit-----");
			System.out.println("1: Enter a new course");
			System.out.println("2: Enter a new relationship");
			System.out.println("3: Remove a relationship");
			System.out.println("4: Check prereq ");
			System.out.println("5: Check required courses");
			System.out.println("6: Print all required courses");
			System.out.println("7: Print total courses");
			choice = s.nextInt();

			if(choice == 1) { //adds new course 
				
				System.out.println("Enter course name");
				courseName = s.next();
				int i = 0;
				while(i < numCourses && graph.getLabel(i)!= null){
					i++;
				}
				graph.setLabel(i, courseName);
			}
			
			if (choice == 2){ //adds edge 
				System.out.println("Enter prereq course: ");
				preReq = s.next();
				System.out.println("Enter course: ");
				courseName = s.next();
				int preReqIndex = graph.getVertex(preReq);
			 	int courseIndex = graph.getVertex(courseName);
					if(preReqIndex == -1 && courseIndex == -1){ //checks to see if courses exist
						throw new ArrayIndexOutOfBoundsException("Courses not found");
					}
			 	graph.addEdge(preReqIndex, courseIndex);
			}
			
			if(choice == 3){ //removes edge 
				System.out.println("Enter prereq course: ");
				preReq = s.next();
				System.out.println("Enter course: ");
				courseName = s.next();
				int preReqIndex = graph.getVertex(preReq);
			 	int courseIndex = graph.getVertex(courseName);
			 	graph.removeEdge(preReqIndex, courseIndex);
			}
			
		   if(choice == 4){ //checks if edge is there 
			   System.out.println("Enter prereq course: ");
				preReq = s.next();
				System.out.println("Enter course: ");
				courseName = s.next();
				int preReqIndex = graph.getVertex(preReq);
			 	int courseIndex = graph.getVertex(courseName);
	            if(graph.isEdge(preReqIndex,courseIndex)){
	            	System.out.println(preReq + " is a prereq of " + courseName);
	            } else {
	            	System.out.println(preReq + " is not a prereq of " + courseName);
	            }			   
		   }
		   
		   if(choice == 5){ //checks all paths 
			   System.out.println("Enter prereq course: ");
				preReq = s.next();
				System.out.println("Enter course: ");
				courseName = s.next();
				int preReqIndex = graph.getVertex(preReq);
			 	int courseIndex = graph.getVertex(courseName);
	            if(graph.isPath(preReqIndex,courseIndex)){
	            	System.out.println(preReq + " is a prereq course of " + courseName);
	            } else {
	            	System.out.println(preReq + " is not a prereq of " + courseName);
	            }
		   }
		   
		   if(choice == 6){ //prints all courses according to vertex neighbors 
				System.out.println("Enter course: ");
				courseName = s.next();
				int courseIndex = graph.getVertex(courseName);
				int []neededCourses = graph.neighbors(courseIndex);
				System.out.println("You do need to take any courses");
				for(int i = 0; i < neededCourses.length; i++) {
					System.out.println(graph.getLabel(neededCourses[i]));
				}
		   }
		   
		   if(choice == 7){ //Print all courses 
			   
			   System.out.println("Courses you need to take");
				for(int i = 0; i < numCourses; i++){
					if(graph.getLabel(i) != null){
						System.out.println(graph.getLabel(i));
					}else {
						System.out.println("No courses");
					}
				}			   
		   }
	} while(choice != 0);
	}//main
}//class