package javaapplication1;
import java.util.ArrayList;
import java.util.List;


public class  PermutacionesIterator<E> implements java.util.Iterator<List<E>>{
    private List<E> inList;
    private int n, m;
    private int[] index;
    private boolean hasMore = true;


    public PermutacionesIterator(List<E> inList){
                this(inList, inList.size());
        }
   

    public PermutacionesIterator(List<E> inList, int m){
        this.inList = inList;
        this.n = inList.size();
        this.m = m;

        assert this.n >= m && m >= 0;

        this.index = new int[this.n];
        for (int i = 0; i < this.n; i++) {
            this.index[i] = i;
        }

        reverseAfter(m - 1);
    }
   

    public boolean hasNext(){
        return this.hasMore;
    }
   

    private void moveIndex(){
        int i = rightmostDip();
        if (i < 0) {
            this.hasMore = false;
            return;
        }


        int leastToRightIndex = i + 1;
        for (int j = i + 2; j < this.n; j++){
            if (this.index[j] < this.index[leastToRightIndex] &&  this.index[j] > this.index[i]){
                leastToRightIndex = j;
            }
        }

        int t = this.index[i];
        this.index[i] = this.index[leastToRightIndex];
        this.index[leastToRightIndex] = t;

        if (this.m - 1 > i){
            reverseAfter(i);    
            reverseAfter(this.m - 1);
        }
    }
   

    public List<E> next(){
        if (!this.hasMore){
            return null;
        }
        List<E> list =  new ArrayList<E>(this.m);
        for (int i = 0; i < this.m; i++){
                int thisIndexI = this.index[i];
                E element = this.inList.get(thisIndexI);
                list.add(element);
        }
        moveIndex();
        return list;
    }
   

    private void reverseAfter(int i){
        int start = i + 1;
        int end = this.n - 1;
        while (start < end){
            int t = this.index[start];
            this.index[start] = this.index[end];
            this.index[end] = t;
            start++;
            end--;
        }

    }
   

    private int rightmostDip(){
        for (int i = this.n - 2; i >= 0; i--){
            if (this.index[i] < this.index[i+1]){
                return i;
            }
        }
        return -1;
    }
       
    public void remove() {
                throw new UnsupportedOperationException();
        }
    
   
}

