class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    al.add(i);//Rows
                    al.add(j);//columns
                }
            }
        }
        Change(matrix,al);
    }
    public void Change(int matrix[][], ArrayList<Integer> al){
        for(int i=0;i<al.size();i++){
            if(i%2==0){
                for(int a=0;a<matrix[0].length;a++){
                    matrix[al.get(i)][a]=0;
                }
            }else{
                for(int a=0;a<matrix.length;a++){
                    matrix[a][al.get(i)]=0;
                }
            }
        }
    }
}
