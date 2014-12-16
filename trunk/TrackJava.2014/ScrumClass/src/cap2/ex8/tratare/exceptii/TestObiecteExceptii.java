package cap2.ex8.tratare.exceptii;

public class TestObiecteExceptii {
	
	public static void main(String[] args) throws Exception{
		new TestObiecteExceptii().
//			testFinally();
//		testLocalExceptions("UPDATE");
//		testDeclaredExceptions("UPDATE");
//		testErrors("DELETE");
		testUncheckedExceptions("UPDATE");
	}
	
	void testFinally(){
        try{
            if (1==1){
                throw new Throwable("Trebuie sa-l prinzi!");
            }
            if (1==1){
                throw new RuntimeException("Runtime Exception");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Tratament pentru " 
								+ e.getMessage());
        }catch(Throwable e){
            System.out.println("Tratament pentru " 
								+ e.getMessage());
        }finally{
            System.out.println(
					"Anyway ... with or without exception ...");
        }
    }
	
	void testLocalExceptions(String str) {
        try {
            if (!str.matches("SELECT.*")) {
                throw new Exception(
					"Not SELECT command : " + str);
            }
        } catch (Exception ex) {
            System.out.println("Catched: " 
					+ ex.getMessage());
        }
    }

	//------------------------------------------------//
	void testDeclaredExceptions(String str) throws Exception{
        processSelectComands(str);
	}
	void processSelectComands(String str) throws Exception {
	    if (!str.matches("SELECT.*")) {
	        throw new Exception("Not SELECT command : " + str);
	    }
	}
	//------------------------------------------------//

	//------------------------------------------------//
    void testErrors(String str) {
        processUpdateComands(str);

    }
    void testUncheckedExceptions(String str) {
        try {
            processDeleteComands(str);
        } catch (Exception ex) {
            System.out.println("Catched: " 
					+ ex.getMessage());
        }

    }
    
    void processUpdateComands(String str) {
        if (!str.matches("UPDATE.*")) {
            throw new Error("Not UPDATE command : " + str);
        }
    }
    void processDeleteComands(String str) {
        if (!str.matches("DELETE.*")) {
            throw new RuntimeException("Not DELETE command : " 
					+ str);
        }
    }
  //------------------------------------------------//
	
}
