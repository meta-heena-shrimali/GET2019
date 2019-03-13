
/**
 * This class defines a term of a multivariate polynomial.
 */
public class Term {
    public double coefficient;
    public Variable variable;

    public Term(double coefficient, Variable variable) {
        this.coefficient = coefficient;
        this.variable = variable;
    }

}