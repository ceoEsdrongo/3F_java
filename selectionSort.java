public class SelectionSort
{
	public static void main(String[] args) {
		int[] array = {15,-2,7,1,4,9};
		int posMin=0, temp;
		for (int i=0; i<array.length; i++){
		    posMin=i;
		    for (int j=i; j<array.length; j++){
		        if (array[j]<array[posMin]){
		            posMin=j;
		        }
		    }
		    if(i!=posMin){
		    temp=array[i];
		    array[i]=array[posMin];
		    array[posMin]=temp;
		    }
		}
		for(int i=0; i<array.length; i++){
		System.out.println(array[i]);
		}
	}
}
