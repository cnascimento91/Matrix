package lab03;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Matrix {
private File file; 
private ArrayList<Array> result;
	public Matrix(File file ) {
		this.file = file;
		result= new ArrayList<Array>();
		
	}
	public void buildMatriX(){
		
	}
	@Override
	public String toString() {
		
		return "Matrix [result=" + result + "]";
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	public void multiply(){
		
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
	

}
