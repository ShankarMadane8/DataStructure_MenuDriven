package handlerMenu;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import customeException.DoubleLinkedListIndexOutOfBoundException;
import customeException.EmptyArrayException;
import customeException.EmptyDoubleLinkedListException;
import customeException.EmptyLinkedListException;
import customeException.EmptyQueueException;
import customeException.EmptyStackException;
import customeException.LinkedListIndexOutOfBoundException;
import dataStructure.CustomeDoubleLinkedList;
import dataStructure.CustomeDynamicArray;
import dataStructure.CustomeDynamicQueue;
import dataStructure.CustomeLinkedList;
import dataStructure.CustomeStack;

public class Menu extends MenuItem {

	Map<Integer, MenuItem> listmap = new HashMap<>();

	static Scanner sc = new Scanner(System.in);
	static CustomeStack stack = new CustomeStack();
	static CustomeDynamicQueue queue = new CustomeDynamicQueue();
	static CustomeLinkedList linkedList = new CustomeLinkedList();
	static CustomeDoubleLinkedList doubleLinkedList = new CustomeDoubleLinkedList();
	static CustomeDynamicArray array = new CustomeDynamicArray();

	// ------------------defalut Constructure-----------------------
	public Menu() {
		super();
	}

	// -----------------Menu Constructure------------------------
	public Menu(int id, String name) {
		super(id, name);
	}

	// -----------------addMenuItem--------------------------------
	public void addMenuItems(MenuItem items) {
		items.setParent(this);
		int menuId = items.getId();
		listmap.put(menuId, items);
	}
	
	
	
	

	// -----------------Display Menu--------------------------------
	public void displayMenu() {
		System.out.println("==============Data Structure=============");
		listmap.forEach((k, v) -> {
			System.out.println(k + ". " + v.getItemName());
			//System.out.println(v.getParent()+" "+v.getParent().getItemName());

		});
		
		try {
			System.out.println("Enter choice number:");
			int menuId = sc.nextInt();
			//MenuItem menuItem = listmap.get(menuId);
			//System.out.println(menuItem.getParent().getItemName()+"=====displaymenu");
			displayMenuItem(menuId);				
		} catch (Exception e) {
			System.err.println("please Enter valid Choice... ");
			displayMenu();
		}		
		
	}
	
	
	
	//---------------------checkBack---------------------------------
		public void checkBack(MenuItem menuItem) {
			    System.out.println("check back "+menuItem.getParent());
				if(menuItem.getParent()!=null) {
					if(menuItem.getItemName().equals("back")) {
						 displayMenu();
					 }
				}else {
					System.exit(0);
			  }
				
		}

	
	// -----------------Display MenuItem--------------------------------
	public void displayMenuItem(int menuId) {

		Menu menu = (Menu) listmap.get(menuId);
		//System.out.println(listmap.get(menuId).getParent()+"-----....");

		System.out.println("-----------" + menu.getItemName() + "Data Structure------------");
		menu.listmap.forEach((k, v) -> {
			System.out.println(k + ". " + v.getItemName());
			//System.out.println(v.getParent()+" "+v.getParent().getItemName());
		});
         
		
		
		try {
			System.out.println("Enter choice number:");
			
			 int choice = sc.nextInt();
			 
			 MenuItem menuItem = menu.listmap.get(choice);
			 //manage back operation
			 checkBack(menuItem);

			switch (menu.getItemName()) {
			case "Stack": {
				StackOperation(choice);
				break;
			}
			case "Queue": {
				queueOperation(choice);
				break;
			}
			case "LinkedList": {
				linkedListOperation(choice);
				break;
			}
			case "Double LinkedList": {
				doubleLinkedListOperation(choice);
				break;
			}
			case "Array": {
				arrayOperation(choice);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu.getItemName());
			}

		} catch (Exception e) {
			System.out.println("please Enter valid Choice... ");
		}
		displayMenuItem(menuId);
	}

	// ------------------StackOperation-------------------------------------
	public void StackOperation(int choice) {
		
		switch (choice) {
		case 1: {
			System.out.println("enter Value:");
			int val = sc.nextInt();
			stack.push(val);
			System.out.println("add Value Successfully....");
			break;	
		}
		case 2: {
			try {
				int val = stack.pop();
				System.out.println("data pop successfully : " + val);
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
			break;	
		}
		case 3: {
			try {
				int val = stack.peek();
				System.out.println("peek val: " + val);
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
			break;	
		}case 4: {
			break;	
		}
		default:{
			System.err.println("Inavlid Choice, Please try again");
		}			
		}
	}

	// -----------------QueueOperation--------------------------
	public void queueOperation(int choice) {
		switch (choice) {
		case 1: {
			System.out.println("Enter val:");
			int val = sc.nextInt();
			queue.enQueue(val);
			System.out.println("val add successfully...");
			break;
		}
		case 2: {

			try {
				int val = queue.deQueue();
				System.out.println("deQueue val: " + val);
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			break;
		}
		case 3: {
			System.out.println("all values: ");
			try {
				queue.display();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
			break;
		}
		case 4: {
			
			break;
		}
		default: {
			System.err.println("Inavlid Choice, Please try again");
		}

		}
	}

	// ----------------LinkedList dataStructure----------------
	public void linkedListOperation(int choice) {

		switch (choice) {
		case 1: {
			System.out.println("enter val:");
			int val = sc.nextInt();
			linkedList.insert(val);
			System.out.println("insert value successfully...");
			break;
		}
		case 2: {
			try {
				linkedList.delete();
				System.out.println("delete value successfully...");
			} catch (EmptyLinkedListException e) {
				e.printStackTrace();
			}
			break;
		}
		case 3: {
			System.out.println("enter index:");
			int index = sc.nextInt();
			try {
				linkedList.delete(index);
				System.out.println("delete value successfully by index...");
			} catch (LinkedListIndexOutOfBoundException | EmptyLinkedListException e) {
				e.printStackTrace();
			}
			break;
		}
		case 4: {
			try {
				linkedList.display();
			} catch (EmptyLinkedListException e) {
				e.printStackTrace();
			}
			break;
		}
		case 5: {
			//for back operation;
			break;
		}
		default: {
			System.err.println("Inavlid Choice, Please try again");
		}
		}

	}

	// --------------Double LinkedList--------------------
		public void doubleLinkedListOperation(int choice) {
			switch (choice) {
			case 1: {
				System.out.println("enter val:");
				int val = sc.nextInt();
				doubleLinkedList.addInEnd(val);
				System.out.println(" value addInEnd successfully...");
				break;
			}
			case 2: {
				System.out.println("enter val:");
				int val = sc.nextInt();
				doubleLinkedList.addInBegining(val);
				System.out.println(" value addInBegining successfully...");
				break;
			}
			case 3: {
				try {
					doubleLinkedList.deleteForward();
					System.out.println("delete value Forward direction successfully ...");
				} catch (EmptyDoubleLinkedListException e) {
					e.printStackTrace();
				}
				break;
			}
			case 4: {
				System.out.println("enter index:");
				int index = sc.nextInt();
				try {
					doubleLinkedList.deleteForward(index);
					System.out.println("delete value Forward direction successfully by index ...");
				} catch (EmptyDoubleLinkedListException | DoubleLinkedListIndexOutOfBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 5: {
				try {
					doubleLinkedList.deleteInBackword();
					System.out.println("delete value Backword direction successfully ...");
				} catch (EmptyDoubleLinkedListException e) {
					e.printStackTrace();
				}
				break;
			}
			case 6: {
				try {
					System.out.println("dispaly value Forword Direction:");
					doubleLinkedList.displayForward();
				} catch (EmptyDoubleLinkedListException e) {
					e.printStackTrace();
				}
				break;
			}
			case 7: {
				try {
					System.out.println("dispaly value Backword Direction:");
					doubleLinkedList.displayBackword();
				} catch (EmptyDoubleLinkedListException e) {
					e.printStackTrace();
				}
				break;
			}
			case 8: {
				// for back operation	
				break;
			}
			default: {
				System.err.println("Inavlid Choice, Please try again");
			}
			}

		}

	// ------------------ArrayOperation---------------------
	public void arrayOperation(int choice) {
		switch (choice) {
		case 1: {
			System.out.println("enter val:");
			int val = sc.nextInt();
			array.append(val);
			System.out.println("add value Successfully...");
			break;
		}

		case 2: {
			try {
				array.delete();
				System.out.println("delete value Successfully....");
			} catch (EmptyArrayException e) {
				e.printStackTrace();
			}
			break;
		}
		case 3: {
			System.out.println("enter index:");
			int index = sc.nextInt();
			try {
				array.delete(index);
				System.out.println("delete value Successfully....");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		case 4: {
			try {
				System.out.println("All values:");
				array.dispaly();
			} catch (EmptyArrayException e) {
				e.printStackTrace();
			}
			break;
		}
		case 5: {
			// For Back operation
			break;
		}
		default: {
			System.err.println("Inavlid Choice, Please try again");
		}

		}
	}

}