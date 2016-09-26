package ex2;

public class ClientService {
	private static ClientService clientService;

	private ClientService() {
	}

	public static ClientService createInstance() {
		if(clientService == null)
			 clientService = new ClientService();
		return clientService;
	}
}
