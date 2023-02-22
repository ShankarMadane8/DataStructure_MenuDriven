package dataStructure;

import customeException.EmptyArrayException;

public class CustomeDynamicArray {
	
	private int[] array;
	private int size;
	
	public CustomeDynamicArray() {
		this(16);
	}
	
    public CustomeDynamicArray(int size) {
		this.array=new int[size];
		this.size=0;
	}
    
    public void append(int val) {
    	if(size<array.length) {
    		array[size++]=val;
    		
    	}else {
    		//System.out.println("full");
    		resize(array.length*2);
    		append(val);
    		
    	}
    }
    
    public void resize(int dynamicSize) {
    	int[] newArray=new int[dynamicSize];
    	for(int i=0;i<array.length;i++) {
    		newArray[i]=array[i];
    	}
    	array=newArray;
    }
    
    
    
    public void delete() throws EmptyArrayException {
    	if(size==0) {
    		//System.out.println("empty");
    		throw new EmptyArrayException("Empty Array. can not perform delete operation.");
    	}else {
    		for(int i=0;i<size;i++) {
    			array[i]=array[i+1];
    		}
    		array[size]=0;
    		size--;
    	}
    }
    
    
    public void delete(int index) throws EmptyArrayException {
    	if(index>size) {
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	if(size==0) {
    		throw new EmptyArrayException("Empty Array. can not perform delete operation.");
    	}else {
    		for(int i=index;i<size;i++) {
    			array[i]=array[i+1];
    		}
    		array[size]=0;
    		size--;
    	}
    }
    
    
    
    
    public void dispaly() throws EmptyArrayException {
    	if(size==0) {
    		throw new EmptyArrayException("Empty Array. can not perform display operation.");
    	}
    	for(int i=0;i<size;i++) {
    		System.out.print(array[i]+" ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) throws EmptyArrayException {
		CustomeDynamicArray array=new CustomeDynamicArray();
		array.append(1);
		array.append(2);
		array.append(3);
		array.append(4);
			
		array.dispaly();
		array.delete();
		array.delete();
		array.delete();
		array.delete();
	    array.dispaly();
		
	}
    

}
