import java.util.Scanner;

class findDuplicate{
    public static void main(String[] args) {
        System.out.println("Enter the array size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int mx = 0;
        for(int i:arr){
            mx = Math.max(i, mx);
        }
        System.out.println("Max" + mx);

        int[] chk = new int[mx*2 +1];
        for(int i=0;i<n-1;i++){
            int cd;
            if(arr[i] < 0) cd = -arr[i];
            else cd = arr[i]*2;

            if(chk[cd] == 1) continue;

            for(int j=i+1;j<n;j++){
                if(arr[i] == arr[j]){
                    System.out.print(arr[i] + " ");
                    chk[cd] = 1;
                    break;
                }
            }
        }
    }
}
