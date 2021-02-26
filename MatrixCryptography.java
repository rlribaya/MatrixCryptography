import java.util.*;
public class MatrixCryptography {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // Show welcome screen
        System.out.println("Cryptography Using Matrices");
        
        // Ask for invertible matrix
        System.out.println("Please input a 3x3 invertible matrix");
        int matrixA[][] = new int[3][3];
        arrayInput(matrixA);
        
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
        
        
        
        
        /*for (int i = 0; i < msg.length(); i++) {
            if (i%3 == 0 && i != 0) {
                System.out.print("1x3 Array #" + (i/3) + ": ");
                for (int z : message) System.out.print(z + "   ");
                System.out.println();
                output[i/3 - 1] = multiply(message, matrixA);
                message = new int[3];
            }
            message[i%3] = (msg.charAt(i) == 32 ? 0 : msg.charAt(i) - 64);
        }
        
        if (msg.length() % 3 != 0) {
            System.out.print("1x3 Array #" + x + ": ");
            for (int z : message) System.out.print(z + "   ");
            output[x - 1] = multiply(message, matrixA);
            System.out.println();
        }
        */
        System.out.println("Encoded message: ");
        arrayDisplay(output);
        
        s.close();
    }
    public static void arrayInput(int[][] matrix) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Please input row " + (i+1) + " (separate each value by a <space>):");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
    }
    public static int[] multiply(int matrixA[], int matrixB[][]) {
         int product[] = new int[matrixA.length];
            for (int i = 0; i < matrixB[0].length; i++) {
                for (int j = 0; j < matrixA.length; j++) {
                    product[i] += matrixA[j] * matrixB[j][i];
                }
            }
        return product;
    }
    // Overloaded arrayDisplay
    public static void arrayDisplay(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
        }
    }
    public static void arrayDisplay(int[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i]);
        }
        System.out.println();
    }
}
