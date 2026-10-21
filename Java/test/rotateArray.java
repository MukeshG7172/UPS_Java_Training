import java.util.Scanner;

class rotateArray{
    public static void main(String[] args) {
        int n;
        System.out.println("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the positions to be rotated");
        int k = sc.nextInt();


        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[(i + k)%n] = arr[i];
        }

        for(int i:ans) System.out.print(i+" ");
        System.out.println();
    }
}
