import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.lang.*;

// Implementing the remote interface 
public class Impl extends UnicastRemoteObject implements RemoteInterface {  
	protected Impl() throws RemoteException {
		super();
	}


	// Implementing the interface method
	public int[] printMsg(int[] arr) {  
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			System.out.println(arr[i] + " Current array number" + i);
		}
		long end = System.currentTimeMillis();
		System.out.println("Printing result on client takes " + (end - start) + "ms"); 
		return arr;
	}

	@Override
	public int[] sortNum() throws RemoteException {
		long start2 = System.currentTimeMillis();
		Random rand = new Random(); 
		int nums[] = new int[30000];
		int start = 0, end = 30000;
		for (int i = start; i < end; i++) {
			nums[i] = rand.nextInt(5) + 1;
			System.out.print(nums[i]);
		}
		QuickSort ob = new QuickSort();
		ob.sort(nums);
		
		for (int i = start; i < end; i++) {
		System.out.print(nums[i]);
			}
			
		long end2 = System.currentTimeMillis();
		System.out.println("  Generate Random and Sorting takes " + (end2 - start2) + "ms"); 
		return nums;
	}
	
	public int[] sortNum2() throws RemoteException {
		long start3 = System.currentTimeMillis();
		Random rand = new Random(); 
		int nums2[] = new int[30000];
		int start = 0, end = 30000;
		for (int i = start; i < end; i++) {
			nums2[i] = rand.nextInt(10-6+1) + 6;
			System.out.print(nums2[i]);
		}
		QuickSort ob = new QuickSort();
		ob.sort(nums2);
		
		for (int i = start; i < end; i++) {
		System.out.print(nums2[i]);
			}
		long end3 = System.currentTimeMillis();
		System.out.println("  Generate Random and Sorting takes " + (end3 - start3) + "ms"); 
		return nums2;
	}
	
	public int[] sortNum3() throws RemoteException {
		long start4 = System.currentTimeMillis();
		Random rand = new Random(); 
		int nums3[] = new int[40000];
		int start = 0, end = 40000;
		for (int i = start; i < end; i++) {
			nums3[i] = rand.nextInt(15-11+1) + 11;
			System.out.print(nums3[i]);
		}
		QuickSort ob = new QuickSort();
		ob.sort(nums3);
		
		for (int i = start; i < end; i++) {
		System.out.print(nums3[i]);
			}
		long end4 = System.currentTimeMillis();
		System.out.println("  Generate Random and Sorting takes " + (end4 - start4) + "ms"); 
		return nums3;
	}


	@Override
	public int[] sendingClientResult() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public InetAddress ipHolder(InetAddress ipAddress) throws RemoteException {
		//InetAddress ipServer1;
		System.out.println(ipAddress);
		return ipAddress;
	}


	@Override
	public int[] generateRandom() throws RemoteException {
//		Random rand = new Random(); 
//		int nums[] = new int[100000];
//		int start = 0, end = 100000;
//		//int break1[],break2[],break3[];
//		for (int i = start; i < end; i++) {
//			nums[i] = rand.nextInt(nums.length);
	System.out.println("We are now beggining printing process");
//		}
		return null;
	}	

//	public String getAddress(String address) throws UnknownHostException {
//		if (address.equals("1"))
//			return this.ipServer1.toString();
//		else if (address.equals("2"))
//			return this.ipServer2.toString();
//		else if (address.equals("3"))
//			return this.ipServer3.toString();
//		return null;
//	}
	
	
}