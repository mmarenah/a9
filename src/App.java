//package sorting;

import java.util.ArrayList;

public class App {

    public static <E> void swap(ArrayList<E> arrayList, int i, int j) {
        E temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }

    public static <E extends Comparable<E>> boolean isSorted(ArrayList<E> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i ++) {
            if (arrayList.get(i).compareTo(arrayList.get(i+1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void merge(ArrayList<E> arrayList, int startIndex, int midIndex, int end) {
        int i = startIndex, j = midIndex;
        ArrayList<E> tempArrayList = new ArrayList<E>();

        while ((i < midIndex) && (j < end)) {
            if (arrayList.get(i).compareTo(arrayList.get(j)) > 0) {
                tempArrayList.add(arrayList.get(j));
                j ++;
            }
            else {
                tempArrayList.add(arrayList.get(i));
                i ++;
            }
        }
        while (i < midIndex) {
            tempArrayList.add(arrayList.get(i));
            i ++;
        }
        while (j < end) {
            tempArrayList.add(arrayList.get(j));
            j ++;
        }

        for (int k = 0; k < tempArrayList.size(); k ++) {
            arrayList.set(k + startIndex, tempArrayList.get(k));
        }
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> arrayList, int startIndex, int end) {
        if (end - startIndex <= 1) {
            return;
        }

        int midIndex = (startIndex + end) / 2;

        mergeSort(arrayList, startIndex, midIndex);
        mergeSort(arrayList, midIndex, end);

        merge(arrayList, startIndex, midIndex, end);
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> arrayList) {
        mergeSort(arrayList, 0, arrayList.size());
    }

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> arrayList) {
        for (int i = arrayList.size() - 1; i > 0; i --) {
            for (int j = 0; j < i; j ++) {
                if (arrayList.get(j).compareTo(arrayList.get(j+1)) > 0 ) {
                    swap(arrayList, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(10);
        numbers.add(1);
        numbers.add(8);

        // Print the unsorted list
        System.out.println("Unsorted list: " + numbers);

        // Sort the list using bubble sort
        bubbleSort(numbers);
        System.out.println("List sorted using bubble sort: " + numbers);

        // Sort the list using merge sort
        mergeSort(numbers);
        System.out.println("List sorted using merge sort: " + numbers);

        // Check if the list is sorted
        System.out.println("Is the list sorted? " + isSorted(numbers));
    }

}