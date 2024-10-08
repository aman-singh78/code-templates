import java.util.*;
 class segTree{

     static int seg[];

    public segTree(int n){

         seg=new int[4*n];

    }
    static Scanner sc=new Scanner(System.in);

    public static void build(int idx,int low,int high,int arr[],int seg[]){
        if(low==high){
            seg[idx]=arr[low];
            return;
        }
        int mid=(low+high)/2;
        build(2*idx+1,low,mid,arr,seg);
        build(2*idx+2,mid+1,high,arr,seg);

        seg[idx]=Math.min(seg[2*idx+1],seg[2*idx+2]);
    }

    public static int query(int idx,int low,int high,int l,int r,int seg[]){
        //no overlap
        // l r  low high  ,  low high  l r
        if(r < low || high < l){
            return Integer.MAX_VALUE;
        }
        // complete overlap
        // [l low high r]
         if(low>=l && high <= r){
             return seg[idx];
         }
         int mid=(low+high)/2;
         int left=query(2*idx+1,low,mid,l,r,seg);
         int right=query(2*idx+2,mid+1,high,l,r,seg);

         return Math.min(left,right);
    }

    public static void update(int idx,int low,int high,int i,int val,int seg[]){
        if(low==high){
            seg[idx]=val;
            return;
        }
        int mid=(low+high)/2;
        if(i<=mid) {
            update(2 * idx + 1, low, mid, i, val, seg);
        }
            else{
                update(2*idx+2,mid+1,high,i,val,seg);
            }
        seg[idx]=Math.min(seg[2*idx+1],seg[2*idx+2]);

        }


    public static void solve() {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        int seg[] = new int[n * 4];
        build(0, 0, n - 1, arr, seg);
        int q = sc.nextInt();
        while (q-- > 0) {
            int type=sc.nextInt();
            if(type==1){
                int l=sc.nextInt();
                int r=sc.nextInt();
                int queryAns= query(0, 0, n - 1, l ,r, seg);
                System.out.println(queryAns);
            }
            else{
                int i=sc.nextInt();
                int val=sc.nextInt();
                update(0,0,n-1,i,val,seg);
                arr[i]=val;
            }



        }
    }

}

public class segment {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        segTree obj=new segTree(n);
        obj.solve();


    }
}
