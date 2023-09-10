import java.util.ArrayList;

//TODO plan: have one page of assignment interface and another page of algorithms
public class Algorithms {

	ArrayList<Integer> values = new ArrayList<>();
	int count = 0;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static int n1=0,n2=1,n3=0;    
	String output;
	public Algorithms() {
		
	}
	public int factorial(int n){    
		if (n == 0)    
			return 1;    
		else    
			return(n * factorial(n-1));    
	}  
	public boolean isPrime(int n, int i)
	{

		// Base cases
		if (n <= 2)
			return (n == 2) ? true : false;
		if (n % i == 0)
			return false;
		if (i * i > n)
			return true;

		// Check for next divisor
		return isPrime(n, i + 1);
	}

	public int binarySearch(int arr[], int l, int r, int x)
	{
		count++;
		
		// Restrict the boundary of right index
		// and the left index to prevent
		// overflow of indices
		if (r >= l && l <= arr.length - 1) {

			int mid = l + (r - l) / 2;
			values.add(arr[mid]);
			// If the element is present
			// at the middle itself
			if (arr[mid] == x)
				return mid;

			// If element is smaller than mid, then it can
			// only be present in left subarray
			if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);

			// Else the element can only be present
			// in right subarray
			return binarySearch(arr, mid + 1, r, x);
		}

		// We reach here when element is not present in
		// array
		return -1;
	}

	int RLinearSearch(int A[], int n, int key) {
	 count++;
	
		if(n<0) { // Base case - not found
	        return -1;
	    }
		 values.add(A[n]);
	    if(A[n]==key) { // Base case - found
	        return n;
	    }
	   
	    // Recursive case
	    return RLinearSearch(A, n-1, key);
	}

	public ArrayList<Integer> getValues() {
		return values;
	}
	public void setValues(ArrayList<Integer> values) {
		this.values = values;
	}
	public int fibonacciNum(int n)  {
		if (n < 2) return n;

		return fibonacciNum(n - 1) + fibonacciNum(n - 2);
	}

	public void fibonacciSeq(int n, String fibSequence) {
		long n1=1,n2=1,n3=2; 
		if(n>0){      
			n3 = n1 + n2;      //add two preceding terms 
			n1 = n2;      
			n2 = n3;      
			fibSequence = fibSequence.concat(" " + n3);    
			fibonacciSeq(n-1, fibSequence); 

		}
		System.out.println(fibSequence);
		//return fibSequence;   

	}
    
	void bubbleSort(int arr[], int n)
    {
        // Base case
        if (n == 1)
            return;
      
        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
      
        // Largest element is fixed,
        // recur for remaining array
        bubbleSort(arr, n-1);
    }
	String printFibonacci(int count, String fibSequence){    

		if(count<=0){    
			System.out.println(fibSequence); 
			n1=0;
			n2=1;
			
			n3=0; 
			return fibSequence; 
		}   
		n3 = n1 + n2;    
		n1 = n2;    
		n2 = n3;    
		fibSequence = fibSequence.concat(" " + n3);    
		return printFibonacci(count-1, fibSequence); 


	}
	public static int getN1() {
		return n1;
	}
	public static void setN1(int n1) {
		Algorithms.n1 = n1;
	}
	public static int getN2() {
		return n2;
	}
	public static void setN2(int n2) {
		Algorithms.n2 = n2;
	}
	public static int getN3() {
		return n3;
	}
	public static void setN3(int n3) {
		Algorithms.n3 = n3;
	}
}