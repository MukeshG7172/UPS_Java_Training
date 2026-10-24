import java.util.Scanner;

class findduplicate{
    public static void main(String[] args) {
        System.out.println("Enter the array size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            boolean dup = true;
            for(int j=0;j<=i-1;j++){
                if(arr[i] == arr[j]) {
                    dup = false;
                    break;
                }
            }

            if(dup){
                for(int j=i+1;j<n;j++){
                    if(arr[i] == arr[j]){
                        System.out.print(arr[i] + " ");
                        break;
                    }
                }
            }
        }
        
        System.out.println();
    }
}
