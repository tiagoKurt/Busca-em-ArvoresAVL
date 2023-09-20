package arvores.buscarBinaria;

import java.util.ArrayList;


public class buscaBinaria {
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
        list.add(index, word);
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
}

