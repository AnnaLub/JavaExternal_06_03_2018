package task_1;

public class FiguresPrinting {

    /* prints rectangle */
    static void printRectangle(int rows, int column){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || i == rows-1) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || (j == column-1)) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.print("\n");
        }
    }
    /* prints rectangular triangle */
    static void printRectangularTriangle(int side) {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i == side-1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
    }

    /* prints equilateral triangle */
    static void printEquilateralTriangle(int side){
        int topLeft = side-1;
        int topRight = side-1;
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < (side*2-1); j++) {
                if ((i == 0 && j == side-1) || j == topLeft || j == topRight || (i == side-1 && j%2 == 0)){
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            topLeft--;
            topRight++;
            System.out.print("\n");
        }
    }

    /* prints diamond */
    static void printDiamond(int side) {
        int topLeft = side-1;
        int topRight = side-1;
        for (int i = 0; i < (side*2 - 1); i++) {
            for (int j = 0; j < (side*2 - 1); j++) {
                if ((i == 0 && j == side-1) || j == topLeft || j == topRight) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            if (i == side-1) {
                int tmp = topLeft;
                topLeft = topRight;
                topRight = tmp;
            }
            topLeft--;
            topRight++;

            System.out.print("\n");
        }
    }
}
