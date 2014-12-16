package cap2.ex8.tratare.exceptii;

public class TestThrowable {
	public static void main(String[] args) {
        TestThrowable test = new TestThrowable();

        String str = test.returnObjectMethod();
        System.out.println("str - " + str);

        try{
            test.throwObjectMethod();
        }catch(Throwable t){
            System.out.println("t - " + t.getMessage());
        }		
	}
	
	String returnObjectMethod(){
        return "obiect-returnat";
	}
	void throwObjectMethod() throws Throwable{
        throw new Throwable("object-returned");
	}	
}
