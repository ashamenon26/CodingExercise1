import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class DeDup {

    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
	            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
	            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   
		
		int[] first = eliminateDupUsingSet(randomIntegers);
		int[] second = eliminateDupUsingMap(randomIntegers);
		int[] third = eliminateDup(randomIntegers);
		
		System.out.println(Arrays.toString(first));
		System.out.println(Arrays.toString(second));
		System.out.println(Arrays.toString(third));

	}
	/*this will put the array elements to a set and that will avoid the duplicates*/
	public static int[] eliminateDupUsingSet(int[] randomIntegers){
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<randomIntegers.length; i++){
			set.add(randomIntegers[i]);
		}
		
		int[] uniqueArr = new int[set.size()];
		Iterator<Integer> it = set.iterator();
		int i=0;
		while(it.hasNext()){
			uniqueArr[i] = it.next();
			i++;
		}
				
		return uniqueArr;
		
	}

	/*this will add the elements to a hashmap and increment the value by 1 everytime a duplicate key is found.*/
	public static int[] eliminateDupUsingMap(int[] randomIntegers){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<randomIntegers.length; i++){
			if(map.containsKey(randomIntegers[i])){
				map.put(randomIntegers[i], map.get(randomIntegers[i])+1);
			}else{
				map.put(randomIntegers[i], 1);
			}
		}
		
		int[] uniqueArray = new int[map.size()];
		int i =0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			uniqueArray[i] = entry.getKey();
			i++;
		}
		
		return uniqueArray;
	}
	
	/*this implementation will retain the original order*/
	public static int[] eliminateDup(int[] randomIntegers){
		List<Integer> noDupList=new ArrayList<Integer>(); 
		for(int i=0;i<randomIntegers.length;i++){
				int num=randomIntegers[i];
				boolean dupFound=false; 
				for(int j=0;j<noDupList.size();j++){
					if(num==noDupList.get(j)){
						dupFound=true;
						break;
					}
				} 
				if(!dupFound){
					noDupList.add(num);
				}
		} 
		for(int k:noDupList){
			System.out.print(k+",");
		}
		int[] noDupArray = new int[noDupList.size()];
		int i=0;
		for(int num : noDupList){
			noDupArray[i] = num;
			i++;
		} 
		
		return noDupArray;
		
	}
}
