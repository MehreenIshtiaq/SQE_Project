//package businessLogic;
//
//import java.util.Scanner;
//
//public class InputsAdmin {
//	Scanner input= new Scanner(System.in);
//	
//	LMS lms= new LMS();
//	
//	public InputsAdmin(){
//		
//		//loginCredentials();
//		
//	}
//	
//	
//	
//	public void adminFunctionalities() {
//		System.out.println("Plese enter user name: ");
//		String name= input.nextLine();
//		
//		System.out.println("Plese enter password: ");
//		String password= input.nextLine();
//		
//		boolean flag=lms.adminLogin(name,password);
//		
//		if(flag==true) {
//			
//			System.out.println("Login successfully");
//			
//			//********************************************************
//
//			boolean loop=true;
//
//
//			while(loop)
//			{
//				System.out.println("Enter Choice:");
//				
//				switch(input.nextInt())
//				{
//				case 1:
//
//					break;
//				case 2:
//
//					break;
//
//
//				case 3:
//
//					break;
//
//
//
//				case 4:
//					
//
//					break;
//
//				case 5:
//					
//
//
//					break;
//
//				case 8:
//					loop=false;
//					break;
//
//				default :
//					System.out.println("Invalid Input");
//				}
//
//
//
//			}
//
//		//************************************************************************
//		}else {
//			
//			System.out.println("worng password or user name");
//			
//		}
//		
//		
//	}
//	
//	
//		
//
//
//}
