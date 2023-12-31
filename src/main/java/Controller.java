import matrixmultiplication.MatrixMultiplication;
import matrixmultiplication.matrix.CCS;
import matrixmultiplication.matrix.COO;
import matrixmultiplication.matrix.CRS;
import matrixmultiplication.matrixbuilders.CompressedColMatrixBuilder;
import matrixmultiplication.matrixbuilders.CompressedRowMatrixBuilder;
import matrixmultiplication.matrixbuilders.CooMatrixBuilder;

public class Controller {
    private final String path = "Introduce the path to your .mtx files";
    private final CooMatrixBuilder cooMatrixBuilder = new CooMatrixBuilder(path);
    private final COO coo = cooMatrixBuilder.getCooMatrix();
    private final CompressedRowMatrixBuilder compressedRowMatrixBuilder = new CompressedRowMatrixBuilder(coo);
    private final CompressedColMatrixBuilder compressedColMatrixBuilder = new CompressedColMatrixBuilder(coo);
    private final CLI cli = new CLI();
    public Controller() {
    }

    public void execute(){
        CRS a = compressedRowMatrixBuilder.getCRSMatrix();
        CCS b = compressedColMatrixBuilder.getCSSMatrix();
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        COO coo = matrixMultiplication.matrixMultiplication(a, b);
        cli.cli(coo);
    }
}
