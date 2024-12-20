package org.example;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
//asdsa
public class TimesForSorts {
    static Map<String, List<Integer>> OneThreadTimeMid() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10_000_000; i += 500000) {
            arraySizes.add(i);
        }

        // Словарь для хранения времени сортировки
        Map<String, List<Integer>> sortTimes = new HashMap<>();
        for (int size : arraySizes) {
            int[] randomArray = new int[size];
            for (int i = 0; i < size; i++) {
                randomArray[i] = random.nextInt(1000000);
            }


            long startTime = System.nanoTime();
            OneThreadSorts.shellSort(randomArray.clone());
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Shell Mid", k -> new ArrayList<>()).add((int) duration);



            startTime = System.nanoTime();
            OneThreadSorts.mergeSort(randomArray.clone(), randomArray.length);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Merge Mid", k -> new ArrayList<>()).add((int) duration);

            startTime = System.nanoTime();
            OneThreadSorts.quickSort(randomArray.clone(), 0, randomArray.length -1);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Quick Mid", k -> new ArrayList<>()).add((int) duration);
        }
        System.out.println(sortTimes);
        return sortTimes;
    }

    static Map<String, List<Integer>> OneThreadTimeBest() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }

        // Словарь для хранения времени сортировки
        Map<String, List<Integer>> sortTimes = new HashMap<>();
        for (int size : arraySizes) {
            int[] randomArray = new int[size];
            for (int i = 0; i < size; i++) {
                randomArray[i] = random.nextInt(1000000);
            }

            OneThreadSorts.quickSort(randomArray, 0, randomArray.length -1); //сортируем


            long startTime = System.nanoTime();
            OneThreadSorts.shellSort(randomArray.clone());
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Shell Best", k -> new ArrayList<>()).add((int) duration);



            startTime = System.nanoTime();
            OneThreadSorts.mergeSort(randomArray.clone(),randomArray.length);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Merge Best", k -> new ArrayList<>()).add((int) duration);

            startTime = System.nanoTime();
            OneThreadSorts.quickSort(randomArray.clone(), 0, randomArray.length -1);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Quick Best", k -> new ArrayList<>()).add((int) duration);
        }
        System.out.println(sortTimes);
        return sortTimes;
    }
    static Map<String, List<Integer>> OneThreadTimeWorst() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }

        // Словарь для хранения времени сортировки
        Map<String, List<Integer>> sortTimes = new HashMap<>();
        for (int size : arraySizes) {
            int[] randomArray = new int[size];
            for (int i = 0; i < size; i++) {
                randomArray[i] = random.nextInt(1000000);
            }

            // Переворачиваем массив
            int start = 0;
            int end = randomArray.length - 1;
            while (start < end) {
                int temp = randomArray[start];
                randomArray[start] = randomArray[end];
                randomArray[end] = temp;
                start++;
                end--;
            }


            long startTime = System.nanoTime();
            OneThreadSorts.shellSort(randomArray.clone());
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Shell Worst", k -> new ArrayList<>()).add((int) duration);


            startTime = System.nanoTime();
            OneThreadSorts.mergeSort(randomArray.clone(),randomArray.length);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Merge Worst", k -> new ArrayList<>()).add((int) duration);

            startTime = System.nanoTime();
            OneThreadSorts.quickSort(randomArray.clone(), 0, randomArray.length -1);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Quick Worst", k -> new ArrayList<>()).add((int) duration);
        }
        System.out.println(sortTimes);
        return sortTimes;

    }
    static Map<String, List<Integer>> MultiThreadTimeMid() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }

        // Словарь для хранения времени сортировки
        Map<String, List<Integer>> sortTimes = new HashMap<>();
        for (int size : arraySizes) {
            int[] randomArray = new int[size];
            for (int i = 0; i < size; i++) {
                randomArray[i] = random.nextInt(1000000);
            }

            ForkJoinPool pool = new ForkJoinPool();



            long startTime = System.nanoTime();

            MultiThreadSorts.shellSort(randomArray.clone(), 4);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Multi Shell Mid", k -> new ArrayList<>()).add((int) duration);



            startTime = System.nanoTime();
            MultiThreadSorts.MergeSortTask mergeSortTask = new MultiThreadSorts.MergeSortTask(randomArray.clone(), 0, randomArray.length - 1);
            pool.invoke(mergeSortTask);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Multi Merge Mid", k -> new ArrayList<>()).add((int) duration);

            startTime = System.nanoTime();

            MultiThreadSorts.QuickSortTask quickSortTask = new MultiThreadSorts.QuickSortTask(randomArray.clone(), 0, randomArray.length - 1);
            pool.invoke(quickSortTask);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Multi Quick Mid", k -> new ArrayList<>()).add((int) duration);
        }
        System.out.println(sortTimes);
        return sortTimes;
    }

    static Map<String, List<Integer>> MultiThreadTimeBest() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }

        // Словарь для хранения времени сортировки
        Map<String, List<Integer>> sortTimes = new HashMap<>();
        for (int size : arraySizes) {
            int[] randomArray = new int[size];
            for (int i = 0; i < size; i++) {
                randomArray[i] = random.nextInt(1000000);
            }

            OneThreadSorts.mergeSort(randomArray,0); //сортируем


            long startTime = System.nanoTime();
            MultiThreadSorts.shellSort(randomArray.clone(), 4);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Multi Shell Best", k -> new ArrayList<>()).add((int) duration);

            ForkJoinPool pool = new ForkJoinPool();

            startTime = System.nanoTime();
            MultiThreadSorts.MergeSortTask mergeSortTask = new MultiThreadSorts.MergeSortTask(randomArray.clone(), 0, randomArray.length - 1);
            pool.invoke(mergeSortTask);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Multi Merge Best", k -> new ArrayList<>()).add((int) duration);


            startTime = System.nanoTime();
            MultiThreadSorts.QuickSortTask quickSortTask = new MultiThreadSorts.QuickSortTask(randomArray.clone(), 0, randomArray.length - 1);
            pool.invoke(quickSortTask);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Multi Quick Best", k -> new ArrayList<>()).add((int) duration);
        }
        System.out.println(sortTimes);
        return sortTimes;
    }

    static Map<String, List<Integer>> MultiThreadTimeWorst() {
        Random random = new Random();
        List<Integer> arraySizes = new ArrayList<>();
        for (int i = 500000; i <= 10000000; i += 500000) {
            arraySizes.add(i);
        }

        // Словарь для хранения времени сортировки
        Map<String, List<Integer>> sortTimes = new HashMap<>();
        for (int size : arraySizes) {
            int[] randomArray = new int[size];
            for (int i = 0; i < size; i++) {
                randomArray[i] = random.nextInt(1000000);
            }

            // Переворачиваем массив
            int start = 0;
            int end = randomArray.length - 1;
            while (start < end) {
                int temp = randomArray[start];
                randomArray[start] = randomArray[end];
                randomArray[end] = temp;
                start++;
                end--;
            }
        ForkJoinPool pool = new ForkJoinPool();

            long startTime = System.nanoTime();
            MultiThreadSorts.shellSort(randomArray.clone(), 4);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Multi Shell Worst", k -> new ArrayList<>()).add((int) duration);



            startTime = System.nanoTime();
            MultiThreadSorts.MergeSortTask mergeSortTask = new MultiThreadSorts.MergeSortTask(randomArray.clone(), 0, randomArray.length - 1);
            pool.invoke(mergeSortTask);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Multi Merge Worst", k -> new ArrayList<>()).add((int) duration);

            startTime = System.nanoTime();
            MultiThreadSorts.QuickSortTask quickSortTask = new MultiThreadSorts.QuickSortTask(randomArray.clone(), 0, randomArray.length - 1);
            pool.invoke(quickSortTask);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000;
            sortTimes.computeIfAbsent("Multi Quick Worst", k -> new ArrayList<>()).add((int) duration);
        }
        System.out.println(sortTimes);
        return sortTimes;
    }
}
