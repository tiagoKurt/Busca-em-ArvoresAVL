package arvores.buscarBinaria;

import java.util.ArrayList;


public class buscaBinaria {

    

    public static ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right) {
        ArrayList<String> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            String leftElement = left.get(leftIndex);
            String rightElement = right.get(rightIndex);

            if (leftElement.compareTo(rightElement) < 0) {
                result.add(leftElement);
                leftIndex++;
            } else {
                result.add(rightElement);
                rightIndex++;
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }

    public static ArrayList<String> mergeSort(ArrayList<String> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        ArrayList<String> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<String> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }


    public static int binarySearch(ArrayList<String> list, String word) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = word.compareTo(list.get(mid));

            if (cmp == 0) {
                return mid; 
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; 
    }

    public static void insertWordInSortedArray(ArrayList<String> list, String word) {
        int index = 0;
        while (index < list.size() && word.compareTo(list.get(index)) > 0) {
            index++;
        }
        list.add(word);
    }

    public static void updateFrequencyTable(ArrayList<WordFrequency> table, String word) {
        for (WordFrequency wf : table) {
            if (wf.word.equals(word)) {
                wf.frequency++;
                return;
            }
        }
        table.add(new WordFrequency(word, 1));
    }
}

class WordFrequency {

    String word;
    int frequency;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
    
    public void orderSort(){
        
    }
}

