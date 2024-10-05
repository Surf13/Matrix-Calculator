import java.lang.reflect.Array;
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

    public void outputArray(int rows,int cols,int[][]arrays){ //Outputs Given Array and col/row info
        System.out.println("-------------------------------------");
        System.out.print("Rows = " + rows);
        System.out.println(" and Cols = " + cols);
        System.out.println("Given Array: ");
        for(int i=0; i<rows;i++){
            System.out.print("[ ");
            for(int j=0; j<cols;j++){
                System.out.print(arrays[i][j]);
                if(j<col-1){
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }
    public int solveDeterminant(int rows,int cols,int[][] arrays){ //Recursive
        //Prints Out Given Information
        //outputArray();
        //Calculate Determinant
        if(rows != cols){
            System.out.println("Determinant is impossible for current Matrix");
            return Integer.MAX_VALUE;
        } else if(rows==2 && cols==2){
            int val1 = arrays[0][0] * arrays[1][1];
            int val2 = arrays[0][1] * arrays[1][0];
            return (val1-val2);
        } else if (rows>=2){
            int value = 0;
            for(int i=0; i<rows;i++){ 
                int index =0;
                //For First Position
                int[][] newArray = new int[rows-1][cols-1]; 
                for(int r=0;r<rows;r++){
                    if(r!=i){ //If not in same Row
                        for(int c=1;c<cols;c++){
                            try{
                                newArray[index][c-1] = arrays[r][c];
                            }catch(ArrayIndexOutOfBoundsException e){
                                System.out.println("Error");
                                System.out.println("index:"+index);
                                System.out.println("c-1="+(c-1));
                                System.out.println("r="+r);
                                System.out.println("c="+c);
                            }
                        
                        }
                        index++;
                    }
                 
                }
            
                value += Math.pow(-1,i) * arrays[i][0] *  (solveDeterminant(rows-1, cols-1, newArray));
            }
            return value;
        }else if(row==1 && col==1){
            return arrays[0][0];
        } else {
            System.out.println("This Error Message inside of Method:SolveDeterminant should not be possible to reach");
            return Integer.MAX_VALUE;
        }

    }
    
    public int getRow(){ return row; }

    public int getCol(){ return col; }

    public int[][] getArray() { return array; }
    public static void main(String[] args){
        Scanner choice = new Scanner(System.in);
        while(true){
            System.out.println("Please Type in the number of what you want to do: ");
            System.out.println("    1: Solve Matrix for Determinant");
            System.out.println("    2: Solve Matrix for Inverse");
            System.out.println("    3: Solve Matrix for Determinant & Inverse ");
            System.out.println("    -1: Exit Program");
            System.out.print("Choice: ");
            String strAnswer = choice.nextLine();
            System.out.println("-------------------------------------");
            int answer;
            try{

               //Convert to Integer
                answer = Integer.parseInt(strAnswer);
            } catch(NumberFormatException e) {
                System.out.println("Invalid Input");
                continue;
            }

            if(answer == 1){//Determinant
                //Call for Data
                Matrix myMatrix = new Matrix();
                myMatrix.requestData(); 
                //Cal for determiant
                int det = myMatrix.solveDeterminant(myMatrix.getRow(),myMatrix.getCol(),myMatrix.getArray()); 
                if(det !=2147483647){
                    myMatrix.outputArray(myMatrix.getRow(),myMatrix.getCol(),myMatrix.getArray());
                    System.out.println("Determinant is: "+det);
                }
                break;
            } else if (answer ==2){ //Inverse
                System.out.println("Inverse has not been Implemented");
                break;
            } else if (answer ==3){//Both Inverse & Determinant
                //Call For Data
                Matrix myMatrix = new Matrix(); 
                myMatrix.requestData();

                //Cal for Determiant
                int det = myMatrix.solveDeterminant(myMatrix.getRow(),myMatrix.getCol(),myMatrix.getArray());
                if(det !=2147483647){
                    myMatrix.outputArray(myMatrix.getRow(),myMatrix.getCol(),myMatrix.getArray());
                    System.out.println("Determinant is: "+det);
                }

                //Call For Inverse
                System.out.println("Inverse has not been Implemented");


                //Exit Program
                break;
            } else if(answer==-1){ //Exit Program
                break;
            }else{
                System.out.println("Invalid choice! Please select a valid option. \n");
            }
        }
        System.out.println("-------------------------------------");
        System.out.println("Exiting Program.");
        choice.close();

    }

    
   
}  


