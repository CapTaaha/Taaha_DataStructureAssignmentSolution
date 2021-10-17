public class MergeSort {
    void merge(int size[], int f, int mid, int e) {
        int l = mid - f + 1;
        int r = e - mid;

        int LeftArray[] = new int[l];
        int RightArray[] = new int[r];

        for (int i = 0; i < l; ++i) {
            LeftArray[i] = size[f + i];
        }

        for (int j = 0; j < r; ++j) {
            RightArray[j] = size[mid + j + 1];
        }

        int i = 0, j = 0;
        int k = f;
        while (i < l && j < r) {
            if (LeftArray[i] > RightArray[j]) {
                size[k] = LeftArray[i];
                i++;
            } else {
                size[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            size[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < r) {
            size[k] = RightArray[j];
            j++;
            k++;
        }
    }

    void sort(int size[], int f, int e) {
        if (f < e) {
            int mid = (f + e) / 2;
            sort(size, f, mid);
            sort(size, mid + 1, e);
            merge(size, f, mid, e);
        }
    }

}
