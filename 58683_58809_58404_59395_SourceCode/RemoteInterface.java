import java.net.InetAddress;
import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Creating Remote interface for our application 
public interface RemoteInterface extends Remote {  
	int[] printMsg(int[] arr) throws RemoteException;  
	int[] sortNum() throws RemoteException;
	int[] sortNum2() throws RemoteException;
	int[] sortNum3() throws RemoteException;
	int[] sendingClientResult() throws RemoteException;
	InetAddress ipHolder(InetAddress ipAddress) throws RemoteException;
	
	//Generate Random at Load Balancer
	int[] generateRandom() throws RemoteException;
	
	
} 