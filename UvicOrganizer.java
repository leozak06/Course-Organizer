/*
*Leoza Kabir V00840048
*
*Program description: The program uses a scanner to read user input from the console,and after the scanner has been linked to a text file,
*which contains UvicCourses,course department, the course's unique number and the course title.
*All the contentin the file is copied into an array of object(UvicCourses) and then the information abour each element in the array is printed.
*Two more methods are created, where a scanner is used to read user input, about the department and the year the user is interested in, 
*from the console and then the method prints out all the UvicCourses in the array that matches the department and the year. 
*Last but not the least, the program takes the array of UvicCourses and sorts the array by num instance variable(the course number) by using the 
*selection sort code.
*/
import java.util.*;
import java.io.*;

public class UvicOrganizer{
	public static void main(String[]args)throws FileNotFoundException{
		Scanner console=new Scanner(System.in);
		System.out.print("What is the name of the input file?");
		File file=new File(console.nextLine());
		
		while(!file.exists()){
			System.out.println("Error scanning that file,please try again.");
			System.out.print("What is the name of the input file?");
			file=new File(console.nextLine());
		}
		Scanner input=new Scanner(file);
		
		//makeArray
		UvicCourse[]courseArray=makeArray(input);
		
		//printArray
		printArray(courseArray);
		System.out.println();
		
		//listCoursesinDept
		System.out.print("What department are you interested in?");
		String dept=console.next();
		//listCoursesInDept(dept,courseArray);
		
		//listCoursesByDeptAndYear
		System.out.print("What year are you interested in? ");
		int year=console.nextInt();
		listCoursesByDeptAndYear(dept,courseArray,year);
		System.out.println();
		
		//sortByNumber
		sortByNumber(courseArray);
		for(int i=0;i<courseArray.length;i++){
			System.out.println(courseArray[i]);
		}
		
		
	}
		
	
	public static UvicCourse[]makeArray(Scanner s){
		UvicCourse[]courseArray=new UvicCourse[s.nextInt()];
		for(int i=0; i<courseArray.length; i++){
			courseArray[i]=new UvicCourse(s.next(),s.nextInt(),s.nextLine());
		}
		return courseArray;
		
	}
	public static void printArray(UvicCourse[]arr){
		for(int i=0; i<arr.length; i++){
		System.out.println(arr[i]);
		}
	}
	public static void listCoursesInDept(String targetDept,UvicCourse[]arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i].getDept().equals(targetDept)){
				System.out.println(arr[i]);
			}
		}
	}
	public static void listCoursesByDeptAndYear(String targetDept,UvicCourse[]arr,int year){
		for(int i=0;i<arr.length;i++){
			int num=arr[i].getNum();
			int firstDigit=Integer.parseInt(Integer.toString(num).substring(0,1));
			if(arr[i].getDept().equals(targetDept)){
				if(firstDigit==year){
				System.out.println(arr[i]);
				}
			}
		}
	}
	public static void sortByNumber(UvicCourse[]arr){
		for(int i=0; i<arr.length-1;i++){
			int index=i;
			int min=arr[i].getNum();
			for(int j=i+1;j<arr.length;j++){
				int minNum=arr[j].getNum();
				if(minNum<min){
					index=j;
					min=arr[j].getNum();
				}
			}
			
			//swap two UvicCourse objects
			UvicCourse tmp=arr[i];
			arr[i]=arr[index];
			arr[index]=tmp;
		}
		
	}
}


	
