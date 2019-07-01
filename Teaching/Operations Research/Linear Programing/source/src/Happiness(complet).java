import ilog.concert.*;
import ilog.cplex.*;

public class Happiness {
    
    public static void main(String[] args){
        
        double infinity = Double.MAX_VALUE;
        try {
            IloCplex cplex = new IloCplex();
            // create model and solve it
            
            IloObjective obj = cplex.addMaximize();
            
            IloRange c1 = cplex.addRange(56.0,infinity, "c1");
            IloRange c2 = cplex.addRange(70.0,infinity, "c2");
            IloRange c3 = cplex.addRange(60.0,infinity, "c3");
            IloRange c4 = cplex.addRange(150.0,infinity, "c4");
            IloRange c5 = cplex.addRange(168.0, 168.0, "c5");
            IloRange c6 = cplex.addRange(0.0,infinity, "c6");
            
            
            IloNumVar P = cplex.numVar(cplex.column(obj,  2.0).and(
                                       cplex.column(c1,  0).and(
                                       cplex.column(c2,  1.0).and(
                                       cplex.column(c3,  0).and(
                                       cplex.column(c4,  -3.0).and(
                                       cplex.column(c5,   1.0).and(
                                       cplex.column(c6,   1.0))))))),
                                       0, infinity, "P");
            
            IloNumVar O = cplex.numVar(cplex.column(obj,  1.0).and(
                                       cplex.column(c1,  1.0).and(
                                       cplex.column(c2,  1.0).and(
                                       cplex.column(c3,  0).and(
                                       cplex.column(c4,  1.0).and(
                                       cplex.column(c5,   1.0).and(
                                       cplex.column(c6,   0.0))))))),
                                       0, infinity, "O");
            
            IloNumVar S = cplex.numVar(cplex.column(obj,  0).and(
                                       cplex.column(c1,  0).and(
                                       cplex.column(c2,  0).and(
                                       cplex.column(c3,  1.0).and(
                                       cplex.column(c4,  2.0).and(
                                       cplex.column(c5,   1.0).and(
                                       cplex.column(c6,   0.0))))))),
                                       0, infinity, "S");
            
            
            cplex.exportModel("h.lp");
            cplex.solve();
            
            System.out.println("f.o: "+cplex.getObjValue());
            System.out.println("P: "+cplex.getValue(P));
            System.out.println("S: "+cplex.getValue(S));
            System.out.println("O: "+cplex.getValue(O));
            
        } catch (IloException e) {
            System.err.println("Concert exception caught: " + e);
        }
    }
}
