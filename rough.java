
public class rough {
    public static void change(int[] a){
        for(int i = 0;i<a.length;i++){
            a[i]+=2;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[3];

        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        change(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
        }

        


    }
}
