import java.util.Scanner;

class A {
    static Scanner sc = new Scanner(System.in);

    public static int[][] getMatrix(int n, int m) {
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        return arr;
    }

    public static void displayMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void addMatrix(int[][] a, int[][] b) {
        int n = a.length;
        int m = a[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("Sum:");
        displayMatrix(res);
    }

    public static char[] getChars(int n) {
        char[] ch = new char[n];

        for (int i = 0; i < n; i++) {
            ch[i] = sc.next().charAt(0);
        }

        return ch;
    }

    public static char[] appendChars(char[] c1, char[] c2) {
        int n = c1.length;
        int m = c2.length;
        char[] res = new char[n + m];

        for (int i = 0; i < n; i++) {
            res[i] = c1[i];
        }

        for (int i = 0; i < m; i++) {
            res[n + i] = c2[i];
        }

        return res;
    }

    public static int[] getArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static int searchArray(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static int searchTwoSumArray(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] + arr[i][1] == target) {
                return i;
            }
        }

        return -1;
    }

    public static int[] findMaxAndSecondMax(int[] arr) {
        if (arr.length < 2) {
            return new int[]{-1, -1};
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            return new int[]{max, -1};
        }

        return new int[]{max, secondMax};
    }

    public static void main(String args[]) {
        // Matrix Addition
        System.out.println("Enter the Matrix Size:");
        int n = sc.nextInt();

        System.out.println("Enter first Matrix:");
        int[][] arr1 = getMatrix(n, n);

        System.out.println("Enter second Matrix:");
        int[][] arr2 = getMatrix(n, n);

        addMatrix(arr1, arr2);

        // Character Array Append
        System.out.println("Enter first char array size:");
        int nn = sc.nextInt();

        System.out.println("Enter first char array:");
        char[] ch1 = getChars(nn);

        System.out.println("Enter second char array size:");
        int mm = sc.nextInt();

        System.out.println("Enter second char array:");
        char[] ch2 = getChars(mm);

        char[] res = appendChars(ch1, ch2);

        System.out.println("Appended Array:");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
        System.out.println();

        // Array Search
        System.out.println("Enter array size:");
        int size = sc.nextInt();

        System.out.println("Enter array elements:");
        int[] arr = getArray(size);

        System.out.println("Enter target to search:");
        int target = sc.nextInt();

        int index = searchArray(arr, target);

        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found");
        }

        // Two Sum
        System.out.println("Enter target for Two Sum:");
        target = sc.nextInt();

        int[] pair = twoSum(arr, target);

        if (pair[0] != -1) {
            System.out.println("Two Sum indices: " + pair[0] + " " + pair[1]);
            System.out.println("Two Sum values: " + arr[pair[0]] + " " + arr[pair[1]]);
        } else {
            System.out.println("No valid pair found");
        }

        // Maximum and Second Maximum
        int[] maxValues = findMaxAndSecondMax(arr);

        System.out.println("Maximum: " + maxValues[0]);
        System.out.println("Second Maximum: " + maxValues[1]);

        // Search in Two Sum Pairs
        System.out.println("Enter number of pairs:");
        int count = sc.nextInt();

        int[][] pairs = new int[count][2];

        System.out.println("Enter the pairs:");
        for (int i = 0; i < count; i++) {
            pairs[i][0] = sc.nextInt();
            pairs[i][1] = sc.nextInt();
        }

        System.out.println("Enter target sum to search:");
        target = sc.nextInt();

        int pairIndex = searchTwoSumArray(pairs, target);

        if (pairIndex != -1) {
            System.out.println("Pair found at index: " + pairIndex);
        } else {
            System.out.println("No matching pair found");
        }
    }
}
