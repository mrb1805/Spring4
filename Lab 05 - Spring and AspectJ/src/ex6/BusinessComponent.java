package ex6;

public class BusinessComponent implements BusinessInterface {

	public void someBusinessMethod() throws BusinessException {
		//we are raising a different exception to see the aspect coming into action
		//assume that you are connecting to the database and something goes wrong
		throw new RuntimeException();
	}	
}
