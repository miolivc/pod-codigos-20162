package ifpb;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import ifpb.repositories.MessageResultRepository;

@SuppressWarnings("serial")
public class ObserverImpl extends UnicastRemoteObject implements Observer{
	private final MessageResultRepository resultRepository;
	
	public ObserverImpl(MessageResultRepository rep) throws RemoteException{
		this.resultRepository = rep;
	}
	
	public void notify(MessageResult result) throws RemoteException {
		//adicionar o resultado na lista de resultados
		resultRepository.add(result);
	}
	
	public static void registry(MessageResultRepository rep){
		boolean registered = false;
		//para garantir a continuidade, usar um ping.
		while (!registered) {
			try {
				Registry registry = LocateRegistry.getRegistry(10991);
				Subject subject = (Subject) registry.lookup("Subject");
				subject.registry(new ObserverImpl(rep));
				registered = true;
			}
			catch(NotBoundException | IOException e){
				continue;
			}
		}
		
	}
	
}