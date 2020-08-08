import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class Server2 { 


public static void main(String args[]) throws Exception { 
	   InetAddress ipAddress;
	   
      try { 
         // Instantiating the implementation class 
         Impl obj = new Impl();

	Naming.rebind("Server2", obj);  
    
         // Exporting the object of implementation class  
         // (here we are exporting the remote object to the stub) 
         //Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);  
         
         // Binding the remote object (stub) in the registry 
         //Registry registry = LocateRegistry.getRegistry(); 
         
         //RemoteInterface sendIP1toLoadBalancer = (RemoteInterface)Naming.lookup("rmi://" + hostname + "/Hello");
         
        
         
         System.err.println("Server 2 Connected");
         System.out.println(java.net.InetAddress.getLocalHost());
         //ipAddress = (java.net.InetAddress.getLocalHost());
         //sendIP1toLoadBalancer.ipHolder(ipAddress);
        
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   }


} 