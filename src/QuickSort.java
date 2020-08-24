public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Hello quick sorting....");
        Integer[] arr = initArray().clone();
        System.out.println("Initial array :");
        displayArray(arr,-10,-10);System.out.println();
        quickSort(arr,0,arr.length-1);
        System.out.print("\r\nSorted  array :");
        displayArray(arr,-10,-10);System.out.println();
    }

    // the quicksort procedure
    private static void quickSort(Integer[]arr, int low, int high){

        if (low<high) {
            // ---- Diagnostic message ----
            System.out.println("\r\n---\r\nArray before calculating pi : ");
            displayArray(arr, low, high);System.out.println(" array.");
            int pi = calculatePi(arr, low, high); //
            System.out.print("The position of pi is:"+pi+" and the value of arr[pi] ist "+arr[pi]+". Neue Array ist:\r\n");
            displayArray(arr,-10,-10);System.out.print(". Die neue 2 Berecheie sind :");
            // display the intermediate values for left and right array
            displayArray(arr,low, pi - 1);
            System.out.print("+"+arr[pi]+"+");
            displayArray(arr,pi + 1, high);
            // ---- end diagnostic message ----

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

    }

    private static Integer calculatePi(Integer[]arr, int low, int high){
        int i=low-1; int piPosition = high;


                for (int j = i+1 ; j < high ; j++) {
                    if (arr[j] < arr[piPosition]) {
                        i++;
                        int temp;
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp; // switch arr[i] and arr[j]
                    }
                }
                // now we are at the end of "j" and i++ will be the new position for our divider
                i++;
                int temp;
                temp = arr[i];
                arr[i] = arr[piPosition];
                arr[piPosition] = temp; // switch arr[i] and arr[j]

        return i;
    }

    // init the array
    private static Integer[] initArray(){
        // generating an array with 500 elements
        final int numberOfElements = 100;
        Integer[] tempArray = new Integer [numberOfElements];
        for (int i = 0 ; i< numberOfElements ; i++) {tempArray[i]= (int)(Math.random()*99);}
        //Integer[] tempArray= {30,20,10,5,80,90,60,50};
        return tempArray;
    }

    // display the array
    private static void displayArray(Integer[] arr, int start, int stop){

        // start and stop are index postions in the array, if it's -1, the whole array will be display
        if (start==-10){
            start = 0;
        }
        if (stop==-10) {
            stop = arr.length-1;
        }
        System.out.print("[ ");
        for (int i= start ; i<=stop; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
    }
}
