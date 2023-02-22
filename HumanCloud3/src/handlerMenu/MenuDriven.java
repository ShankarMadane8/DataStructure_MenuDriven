package handlerMenu;


public class MenuDriven {

	public static void main(String[] args) {
	
		
		manageMenu();
	}

	public static void manageMenu() {
	

        Menu mainMenu = new Menu();


        Menu stackMenu = new Menu(1, "Stack");
        Menu queueMenu = new Menu(2, "Queue");
        Menu linkedListMenu = new Menu(3, "LinkedList");
        Menu doubleLinkedListMenu = new Menu(4, "Double LinkedList");
		Menu ArrayMenu = new Menu(5, "Array");
		//Menu systemBack = new Menu(6, "System exist");
        
		
		mainMenu.addMenuItems(stackMenu);
		mainMenu.addMenuItems(queueMenu);
		mainMenu.addMenuItems(linkedListMenu);
		mainMenu.addMenuItems(doubleLinkedListMenu);
		mainMenu.addMenuItems(ArrayMenu);
		//mainMenu.addMenuItems(systemBack);

		stackMenu.addMenuItems(new MenuItem(1, "push"));
		stackMenu.addMenuItems(new MenuItem(2, "pop"));
		stackMenu.addMenuItems(new MenuItem(3, "peek"));
		stackMenu.addMenuItems(new MenuItem(4, "back"));

		
		queueMenu.addMenuItems(new MenuItem(1, "enqueue"));
		queueMenu.addMenuItems(new MenuItem(2, "dequeue"));
		queueMenu.addMenuItems(new MenuItem(3, "display"));
		queueMenu.addMenuItems(new MenuItem(4, "back"));
		
		
		linkedListMenu.addMenuItems(new MenuItem(1,"insert"));
		linkedListMenu.addMenuItems(new MenuItem(2,"delete"));
		linkedListMenu.addMenuItems(new MenuItem(3,"delete by index"));
		linkedListMenu.addMenuItems(new MenuItem(4,"display"));
		linkedListMenu.addMenuItems(new MenuItem(5,"back"));
		
		
		doubleLinkedListMenu.addMenuItems(new MenuItem(1,"addInEnd"));
		doubleLinkedListMenu.addMenuItems(new MenuItem(2,"addInBegining"));
		doubleLinkedListMenu.addMenuItems(new MenuItem(3,"delete in Forward direction"));
		doubleLinkedListMenu.addMenuItems(new MenuItem(4,"delete in Forward direction by index"));
		doubleLinkedListMenu.addMenuItems(new MenuItem(5,"delete in Backword directionn"));
		doubleLinkedListMenu.addMenuItems(new MenuItem(6,"display in Forward direction"));
		doubleLinkedListMenu.addMenuItems(new MenuItem(7,"display in Backword direction"));
		doubleLinkedListMenu.addMenuItems(new MenuItem(8,"back"));
		
		
		ArrayMenu.addMenuItems(new MenuItem(1, "append"));
		ArrayMenu.addMenuItems(new MenuItem(2, "delete"));
		ArrayMenu.addMenuItems(new MenuItem(3, "delete by index"));
		ArrayMenu.addMenuItems(new MenuItem(4, "display"));	
		ArrayMenu.addMenuItems(new MenuItem(5, "back"));
		
		
		mainMenu.displayMenu();	
	}
}
