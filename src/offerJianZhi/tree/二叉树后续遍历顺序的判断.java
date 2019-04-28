package offerJianZhi.tree;

public class 二叉树后续遍历顺序的判断 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        if(sequence.length==1)
            return true;
        return ju(sequence, 0, sequence.length-1);

    }

    public boolean ju(int[] a,int star,int root){
        if(star>=root)
            return true;
        int i = root;
        //从后面开始找
        while(i>star&&a[i-1]>a[root])
            i--;//找到比根小的坐标
        //从前面开始找 star到i-1应该比根小
        for(int j = star;j<i-1;j++)
            if(a[j]>a[root])
                return false;;
        return ju(a,star,i-1)&&ju(a, i, root-1);
    }

    public static void main(String[] args) {
        //int[] seq = {4,8,6,12,16,14,10};
        //int[] seq = {5,4,3,2,1};
        int[] seq = {7,4,6,5};
        boolean b = new 二叉树后续遍历顺序的判断().VerifySquenceOfBST(seq);
        System.out.println(b);
    }
}
