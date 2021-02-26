import java.util.*;
public class MatrixCryptography {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // Show welcome screen
        System.out.println("Cryptography Using Matrices");
        
        // Ask for invertible matrix
        System.out.println("Please input a 3x3 invertible matrix");
        int matrixA[][] = new int[3][3];
        arrayInput(matrixA, s);
        
        // Ask for message
        System.out.println("Please input a messasge:");
        String msg = s.nextLine().toUpperCase();
        
        // Determine number of 1x3 matrices
        int x = msg.length() / 3;
        x += x % 3 == 0 ? 0 : 1;
        
        // Place message into an array
        int message[] = new int [x*3];
        int output[][] = new int[x][3];
        
        for (int i = 0; i < msg.length(); i++) {
            message[i] = (msg.charAt(i) == 32 ? 0 : msg.charAt(i) - 64); // A-Z = 1-26; SP = 0
        }
        
        // Perform Encrpytion
        for (int i = 0; i < message.length; i += 3) {
            int matrix[] = new int[3];
            System.arraycopy(message,i, matrix, 0, 3);
            System.out.println("1x3 Array #" + (i+1) + ": ");
            arrayDisplay(matrix);
            output[i/3] = multiply(matrix, matrixA);
        }
        
        // Print Encoded Message
        System.out.println("Encoded Message: ");
        arrayDisplay(output);
        
        s.close();
    }
    public static void arrayInput(int[][] matrix, Scanner s) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Please input row " + (i+1) + " (separate each value by a <space>):");
            
            for (int j = 0; j < matrix[i].length; j++) 
                matrix[i][j] = s.nextInt();
        }
    }
    public static int[] multiply(int matrixA[], int matrixB[][]) {
         int product[] = new int[matrixA.length];
            for (int i = 0; i < matrixB[0].length; i++) 
                for (int j = 0; j < matrixA.length; j++) 
                    product[i] += matrixA[j] * matrixB[j][i];
                
        return product;
    }
    
    // Overloaded arrayDisplay
    public static void arrayDisplay(int[][] matrix) {
        for (int i[] : matrix) 
            for (int j : i ) 
                System.out.print(j + "   ");
        
        System.out.println();
    }
    public static void arrayDisplay(int[] matrix) {
        for (int i : matrix) 
            System.out.print(i + "   ");
        
        System.out.println();
    }
}
