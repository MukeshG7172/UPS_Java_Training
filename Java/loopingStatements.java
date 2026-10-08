import java.util.Scanner;
class A{
    public static void main(String args[]){
        // int a = 10;
        // while(a >= 0){
        //     System.out.println(a--);
        // }


        Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // if(a%2 == 1) a++;
        // while(a<=50){
        //     System.out.println(a);
        //     a+=2;
        // }
        

        // int i = 0;
        // do{
        //     System.out.println(i);
        //     i+=1;
        // }while(i<=4);


        // int sum = 0, i = 1;
        // int r = sc.nextInt();
        // do{
        //     sum += i;
        //     System.out.println(sum);
        //     i++;
        // }
        // while(--r != 0);
        

        // int a = sc.nextInt();
        // int b = 1;
        // do{
        //     b *= a;
        // }while(--a != 0);
        // System.out.println(b);


        // int a = sc.nextInt(), ans = 0;
        // while(a > 0){
        //     ans++;
        //     a/=10;
        // }
        // System.out.println(ans);
        
        
        int st = sc.nextInt(), end = sc.nextInt(), tb = sc.nextInt();
        for(int i=st;i<=end;i++) System.out.println(i + " * " + tb + " = " + (i*tb));
    }
}
