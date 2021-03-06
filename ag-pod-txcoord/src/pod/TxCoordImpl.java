package pod;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class TxCoordImpl extends UnicastRemoteObject implements TxCoord {
  private TxAccount txAccountA;
  private TxAccount txAccountB;
  private TxAccount txAccountC;
  private TxAccount txAccountD;
  private TxAccount txAccountE;
  
  public TxCoordImpl(TxAccount txa, TxAccount txb, TxAccount txc, TxAccount txd, TxAccount txe) throws RemoteException {
    txAccountA = txa;
    txAccountB = txb;
//    txAccountC = txc;
    txAccountD = txd;
    txAccountE = txe;
  }

  @Override
  public void prepareAll() throws RemoteException {
    txAccountA.prepare();
    txAccountB.prepare();
//    txAccountC.prepare();
    txAccountD.prepare();
    txAccountE.prepare();
  }

  @Override
  public void commitAll() throws RemoteException {
    txAccountA.commit();
    txAccountB.commit();
//    txAccountC.commit();
    txAccountD.commit();
    txAccountE.commit();
  }

  @Override
  public void rollbackAll() throws RemoteException {
    txAccountA.rollback();
    txAccountB.rollback();
    txAccountC.rollback();
    txAccountD.rollback();
    txAccountE.rollback();
  }

}
