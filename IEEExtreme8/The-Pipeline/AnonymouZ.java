import java.util.*;

public class Pipe{
  public void Traverse(int [][]arry,int a){
    int[] minimumCost = new int[a];
    for (int i = 0; i < a; i++) {
      minimumCost[i] = arry[i][a - 1];
    }
    for (int i = a- 2; i >= 0; i--) {
      minimumCost[0] += arry[0][i];
      for (int j = 1; j < a; j++) {
        minimumCost[j] = Math.min( minimumCost[j - 1] + arry[j][i] , minimumCost[j] + arry[j][i]);
      }
      for (int j = a- 2; j >= 0; j--) {
        minimumCost[j] = Math.min( minimumCost[j], minimumCost[j+1] + arry[j][i]);
      }
    }
    System.out.println(Minimum( minimumCost));
  }
  public static int Minimum(int[] arry){
    int min = arry[0];
    for(int i=1;i< arry.length;i++){
      if( arry[i] < min){
        min = arry[i];
      }
    }
    return min;
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int q = s.nextInt();
    int[][] water = new int[q][q];
    if (q >= 1 && q <= 1000) {
      for (int i = 0; i < q; i++) {
        for (int j = 0; j < q; j++) {
          int cost = s.nextInt();
          if (cost >= 0 && cost <= 1000000) {
            water[i][j] = cost;
          }
        }
      }
    }
    Pipe pipeline=new Pipe();
    pipeline.Traverse( water,q);
  }
}
