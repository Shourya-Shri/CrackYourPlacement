class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> al=new ArrayList<Integer>();

        int startRow=0;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;

        while(startRow<=endRow && startCol<=endCol){
            //Top
            for(int j=startCol;j<=endCol;j++){
                al.add(matrix[startRow][j]);
            }
            //Right
            for(int i=startRow+1;i<=endRow;i++){
                al.add(matrix[i][endCol]);
            }
            //Bottom
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow==endRow){
                    break;
                }
                al.add(matrix[endRow][j]);
            }
            //Left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){
                    break;
                }
                al.add(matrix[i][startCol]);
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        return al;
    }
}
