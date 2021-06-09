package geekforgeeks;

public class Search2DRowSortedMatrix {
    static boolean search(int matrix[][], int n, int m, int x)
    {
        // code here
        for(int i=0; i< n; i++){
            if(x >= matrix[i][0] && x<=matrix[i][m-1]){
                for(int j=0; j<m; j++){
                    if(matrix[i][j] == x)
                        return true;
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{18, 21, 27, 38, 55, 67}};
        System.out.println(search(matrix,1,6,52));
    }
}
