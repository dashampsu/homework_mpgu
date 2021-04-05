package NLogNSort;

import java.util.Arrays;

public class NLogNSort {
    public void sort(int[] data)
    {
        quicksort(data, 0, data.length -1);
    }

    private static void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            // проверка на валидность данных

            return;
        }

        int divider = divide(array, left, right, array[right-1]); // делим на сорт. и несорт. части
        quicksort(array, left, divider - 1); // сортируем левую часть
        quicksort(array, divider, right); // сортируем правую часть
    }

    private static int divide(int[] array, int left, int right, int pivot) {
        while (left <= right) { // пока поинтеры не пересеклись
            // перебираем одновременно слева и справа цифры,
            // потом сравниваем их и перекидываем из одной стороны в другую

            while (array[left] < pivot) {
                // ищем левую цифру, которую надо свопнуть

                left++;
            }

            while (array[right] > pivot) {
                // ищем правую цифру, которую надо свопнуть

                right--;
            }

            if (left <= right) {
                // если они не прошли сквозь друг друга

                swap(array, left, right);// меняем местами
                left++; // двигаем лево
                right--; // двигаем право
            }
        }
        return left;
    }

    private static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
