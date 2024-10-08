import java.util.*;

class dsu{
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    public dsu(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findP(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findP(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);


    }
    public  void union(int u,int v){
        int up_u=findP(u);
        int up_v=findP(v);
        if(up_v==up_u) return;

        if(size.get(up_u)<size.get(up_v)){
            parent.set(up_u,up_v);
            size.set(up_v,size.get(up_u)+size.get(up_v));
        }
        else{
            parent.set(up_v,up_u);
            size.set(up_u,size.get(up_u)+size.get(up_v));
        }
    }
}

public class ds {
    public static void main(String[] args) {

        dsu ds=new dsu(7);
        ds.union(1,2);
        ds.union(2,3);
        if(ds.findP(2)==ds.findP((3))){
            System.out.println("same parent");
        }

        ds.union(4,5);
        ds.union(6,7);
        ds.union(5,6);
        if(ds.findP(6)==ds.findP((7))){
            System.out.println("same parent");
        }
        else{
            System.out.println("not same");
        }
        ds.union(3,7);


    }
}
