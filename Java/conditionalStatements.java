import java.util.Scanner;

class bookMovie{
    public static void main(String[] args){
        boolean z = true;
        while(z){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the theater number to list the movies which are being screened in it....");
            System.out.println("1: Vijaya Mall PVR, 2: Kamala theater, 3: Rohini theater, 4:End");
            int a = sc.nextInt();

            switch(a){
                case 1:
                {
                    System.out.println("Enter the movie number to book a ticket...");
                    System.out.println("1: Anbil Avan, 2: Meesayamurukku 2, 3: Doraemon(3D Available)");
                    int b = sc.nextInt();
                    if(b == 1){
                        System.out.println("You have booked Anbil Avan");
                    }
                    else if(b == 2){
                        System.out.println("You have booked Meesayamurukku 2");
                    }
                    else if(b == 3){
                        System.out.println("Enter 1 for 3D, 0 for 2D");
                        int sel = sc.nextInt();
                        if(sel == 1) System.out.println("You have booked 3D Doraemon ticket");
                        else if(sel == 0) System.out.println("You have booked 2D Doraemon ticket");
                        else System.out.println("Enter a valid input");
                    }
                    else System.out.println("Invalid movie selection");
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the movie number to book a ticket...");
                    System.out.println("1: Vikram, 2: Sardar, 3: Jeans(3D Available)");
                    int b = sc.nextInt();
                    if(b == 1){
                        System.out.println("You have booked Vikram");
                    }
                    else if(b == 2){
                        System.out.println("You have booked Sardar");
                    }
                    else if(b == 3){
                        System.out.println("Enter 1 for 3D, 0 for 2D");
                        int sel = sc.nextInt();
                        if(sel == 1) System.out.println("You have booked 3D Jeans ticket");
                        else if(sel == 0) System.out.println("You have booked 2D Jeans ticket");
                        else System.out.println("Enter a valid input");
                    }
                    else System.out.println("Invalid movie selection");
                    break;
                }
                case 3:
                {
                    System.out.println("Enter the movie number to book a ticket...");
                    System.out.println("1: Kaithi, 2: Bigil, 3: Avatar(3D Available)");
                    int b = sc.nextInt();
                    if(b == 1){
                        System.out.println("You have booked Kaithi");
                    }
                    else if(b == 2){
                        System.out.println("You have booked Bigil");
                    }
                    else if(b == 3){
                        System.out.println("Enter 1 for 3D, 0 for 2D");
                        int sel = sc.nextInt();
                        if(sel == 1) System.out.println("You have booked 3D Avatar ticket");
                        else if(sel == 0) System.out.println("You have booked 2D Avatar ticket");
                        else System.out.println("Enter a valid input");
                    }
                    else System.out.println("Invalid movie selection");
                    break;
                }
                case 4:
                    System.out.println("Task Ended");
                    z = false;
                    break;
                default:
                {
                    System.out.println("Invalid theater selection");
                }
            }
        }
    }
}
