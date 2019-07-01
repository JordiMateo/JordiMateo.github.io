import ilog.concert.*;
import ilog.cplex.*;
 
public class Happiness {

 public static void main(String[] args){
        
       double infinity = Double.MAX_VALUE;
     try {
       IloCplex cplex = new IloCplex();
       // create model and solve it
        
       IloObjective obj = cplex.addMaximize();
          
       IloRange c1 = cplex.addRange(-infinity, 70.0, "c1");

        
       IloNumVar P = cplex.numVar(cplex.column(obj,  1.0).and(
               cplex.column(c1,  -1.0).and(
               cplex.column(c2,   1.0).and(
               cplex.column(c3,   1.0)))),
               0, infinity, "P");
        
        
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
