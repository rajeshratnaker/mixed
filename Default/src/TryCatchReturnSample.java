
public class TryCatchReturnSample {
	{
		System.out.println("Class level block");
	}
	static{
		System.out.println("Static class block");
	}
	static int i=1;
	static int returnTest()throws Exception{
		try{
			if ( i==1) throw new RuntimeException();
		}catch(RuntimeException e){
			System.out.println("RuntimeException");
			throw e;
		}finally{
			System.out.println("Finally");
			return 20;
		}
		//return 30;
	}
	static class CheckedException extends Exception{
		
	}
	static class UncheckedException extends RuntimeException{
		
	}
	static void throwCheckedException() throws CheckedException{ throw new CheckedException();}
	static void throwUncheckedException() throws UncheckedException{ throw new UncheckedException();}
	
	public static void main(String[] args)throws Exception {
	
		throwCheckedException();
		throwUncheckedException();
		//System.out.println(returnTest());
	}

}
