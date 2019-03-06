class Solution {
    public void setZeroes(int[][] matrix) {
        //Approach 1
        /*for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    for(int k = 0; k < matrix[0].length; k++) {
                        if(matrix[i][k] != 0) {
                            matrix[i][k] = -1000;
                        }
                    }
                    for(int k = 0; k < matrix.length; k++) {
                        if(matrix[k][j] != 0) {
                            matrix[k][j] = -1000;
                        }
                    }
                }
            }
        }
        
        
        for(int y = 0; y < matrix.length; y++) {
            for(int z = 0; z < matrix[0].length; z++) {
                if(matrix[y][z] == -1000) {
                    matrix[y][z] = 0;
                }
            }
        }
        return;*/
        boolean isCol = false;
        for(int i = 0; i < matrix.length; i++) {
             if (matrix[i][0] == 0) {
                isCol = true;
              }
            for(int j = 1; j < matrix[0].length; j++) {
                
                if(matrix[i][j] == 0) {
                    //seeting the first elemen of that row and column to be 0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    
        //first row needs to be set 0 if first element is 0
        if(matrix[0][0] == 0) {
            for(int i = 0; i< matrix[0].length; i++) {
                matrix[0][i] = 0;
            }  
        }
        
        if(isCol) {
          for(int i = 0; i< matrix.length; i++) {
              matrix[i][0] = 0;
          }  
        }
    
        return;
        
    }
}

//time complexity - O(MXN), space complexity - O(1)
