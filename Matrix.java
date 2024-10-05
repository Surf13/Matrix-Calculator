import java.util.Scanner;

public class Matrix {
    
    //variables
    int row;
    int col;
    int[][] array;

    public void requestData(){
        Scanner inputContext = new Scanner(System.in);
        //Get Rows
        System.out.println("How Many Rows: ");
        String strRow = inputContext.nextLine();
        row = Integer.valueOf(strRow);
        //Get Cols
        System.out.println("How Many Cols: ");
        String strCol = inputContext.nextLine();
        col = Integer.valueOf(strCol);

        array = new int [row][col]; //Array With Data
        for(int i=0; i<row;i++){
                System.out.println("Please Give row "+ i +" data seperated by commas");
                String dataRow = inputContext.nextLine();
                String[] stringArray = dataRow.split(",");
                for(int j=0;j<col;j++){
                    array[i][j] = Integer.parseInt(stringArray[j]);
                }
        }
        
        inputContext.close();
    }

    public void outputArray(){ //Outputs Given Array and col/row info
        System.out.println("Rows = " + row);
        System.out.println("Cols = " + col);
        System.out.println("Given Array: ");
        for(int i=0; i<row;i++){
            System.out.print("[ ");
            for(int j=0; j<col;j++){
                System.out.print(array[i][j]);
                if(j<col-1){
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }
    public void solveDeterminant(){
        //Prints Out Given Information
        outputArray();

        //Calculate Determinant
        System.out.println("Determinant Calculatios: Not Implemented Yet ");

    }
    
    public static void main(String[] args){
        System.out.println("Hello from the Matrix class!");
        Matrix myMatrix = new Matrix();
        myMatrix.requestData();
        myMatrix.solveDeterminant();

    }

    
   
}  


