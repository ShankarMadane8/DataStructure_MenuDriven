package handlerMenu;

public class MenuItem {
	
	private int id;
	private String itemName;
    private MenuItem parent;
	
	
	
	public MenuItem getParent() {
		return parent;
	}


	public void setParent(MenuItem parent) {
		this.parent = parent;
	}


	public MenuItem() {
      
	}
	
	
	public MenuItem(int id, String itemName) {
		super();
		this.id = id;
		this.itemName = itemName;

	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
	
	
	
	

}
