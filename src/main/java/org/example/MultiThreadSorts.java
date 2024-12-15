package org.example;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MultiThreadSorts {

    // Multithreaded MergeSort
    public static class MergeSortTask extends RecursiveTask<Void> {
        private final int[] array;
        private final int low, high;

        public MergeSortTask(int[] array, int low, int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }

        @Override
        protected Void compute() {
            if (low < high) {
                int mid = (low + high) / 2;

                MergeSortTask leftTask = new MergeSortTask(array, low, mid);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, high);

                leftTask.fork();
                rightTask.compute();
                leftTask.join();

                merge(low, mid, high);
            }
            return null;
        }

        private void merge(int low, int mid, int high) {
            int[] temp = new int[high - low + 1];
            int i = low, j = mid + 1, k = 0;

            while (i <= mid && j <= high) {
                if (array[i] <= array[j]) {
                    temp[k++] = array[i++];
                } else {
                    temp[k++] = array[j++];
                }
            }

            while (i <= mid) {
                temp[k++] = array[i++];
            }

            while (j <= high) {
                temp[k++] = array[j++];
            }

            System.arraycopy(temp, 0, array, low, temp.length);
        }
    }

    // Multithreaded QuickSort
    public static class QuickSortTask extends RecursiveTask<Void> {
        private final int[] array;
        private final int low, high;

        public QuickSortTask(int[] array, int low, int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }


        private static final int THRESHOLD = 16;

        @Override
        protected Void compute() {
            if (high - low + 1 <= THRESHOLD) {
                Arrays.sort(array, low, high + 1);
                return null;
            }

            if (low < high) {
                int pivotIndex = partition(array, low, high);

                QuickSortTask leftTask = new QuickSortTask(array, low, pivotIndex - 1);
                QuickSortTask rightTask = new QuickSortTask(array, pivotIndex + 1, high);

                leftTask.fork();
                rightTask.compute();
                leftTask.join();
            }
            return null;
        }


        private int partition(int[] array, int low, int high) {
            int mid = low + (high - low) / 2; // Индекс среднего элемента
            swap(array, mid, high); // Переместим средний элемент в конец массива, чтобы использовать его как pivot

            int pivot = array[high]; // Новый опорный элемент
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, high); // Поместим pivot на правильное место
            return i + 1; // Вернем индекс pivot
        }


        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Multithreaded ShellSort
    public static void shellSort(int[] array, int numThreads) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            Runnable[] tasks = new Runnable[numThreads];

            for (int t = 0; t < numThreads; t++) {
                final int threadId = t;
                int finalGap = gap;
                tasks[t] = () -> {
                    for (int i = finalGap + threadId; i < n; i += finalGap * numThreads) {
                        int temp = array[i];
                        int j = i;
                        while (j >= finalGap && array[j - finalGap] > temp) {
                            array[j] = array[j - finalGap];
                            j -= finalGap;
                        }
                        array[j] = temp;
                    }
                };
            }

            Thread[] threads = new Thread[numThreads];
            for (int t = 0; t < numThreads; t++) {
                threads[t] = new Thread(tasks[t]);
                threads[t].start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


