package ifpb;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class SenderImpl extends UnicastRemoteObject implements ISender {
	private final MessageRepository repository;
	
	public SenderImpl(MessageRepository rep) throws RemoteException{
		this.repository = rep;
	}

	@Override
	public void sendMessage(Message dto) throws RemoteException{
		//armazenar temporariamente a mensagem
		repository.add(dto);
	}

}