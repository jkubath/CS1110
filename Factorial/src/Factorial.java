/* PROJECT:  Factorial
 * AUTHOR:  Dr. Kaminski
 * DESCRIPTION:  This shows 2 algorithms for calculating Factorial for a value:
 *          - an iterative algorithm (i.e., what we've used before)
 *          - a recursive alogorithm
 *      It shows them both for  1!, then 2!, then 3!,  . . . then 15!
 * RECURSION:  a "looping mechanism" where a method CALLS ITSELF, repeatedly,
 *          until the problem is solved.
 *      A recursive approach works for problems which can repeatedly be broken
 *          down into smaller version(s) of the original problem.
 *      The breakdown of the problem is usually either:
 *              - split remaining problem into 2 halves, and then solve both of
 *                  those 2 sub-problems by splitting each again. . .
 *          OR  - split remaining problem into a size-of-1 part, which is 
 *                  solvable, AND the-rest, which needs further breakdown. 
 *      On each subsequent recursive call, the sub-problem(s) to be solved
 *          become smaller.  Eventually the problem gets to be a tiny problem,
 *          which can be "solved" without further breakdown (or problem is of
 *          size 0, which doesn't need solving).
 *      There must always be a special "exit case" so the chain of recursive
 *          calling will eventually stop - either:
 *              - when the problem is of size 0
 *              - or when the tiny problem (usually of size 1) is solved.
 *      Each time there's a method call, the system has to remember the state
 *          of things (by PUSHING the state onto the RECURSIVE STACK) so that
 *          it can return to that state on the way back up recursion.
 *          [This "remembering-stack" idea is true of any method-calling, not
 *          just recursive calling].
 *      Sometimes there is still "work to be done" on the way back UP the
 *          recursive call "loop" - e.g., combining solutions of the smaller
 *          sub-problems.
 * NOTES on RECURSIVE vs. ITERATIVE approach:
 *      1) Any problem which can be solved with recursion can always be handled
 *         with an iterative approach instead.
 *      2) The recursive solution is generally more time-intensive due to the
 *         overhead of the calling (e.g., stacking/unstacking the return states).
 *      3) A recursive approach is often a shorter (code-wise), cleaner
 *         solution.
 * 
 * Example:  5! is 120
 * 1) ITERATIVE LOOP implementation:  either do. . .
 *	    5 * 4 * 3 * 2 * 1       (could skip the * 1 part and stop at i > 1)
 *	OR  1 * 2 * 3 * 4 * 5       (could skip the 1 * part and start with 2)
 * 2) RECURSIVE implementation:
 *	GO DOWN RECURSIVELY:
 *          5! is defined as:        5 * 4!
 *          where 4! is defined as:  4 * 3!
 *          where 3! is defined as:  3 * 2!
 *          where 2! is defined as:  2 * 1!
 *          where 1! is defined as:  1           (the STOPPING condition)
 *      GO BACK UP THE RECURSIVE CALL STACK:
 *          sub-problem of 1! solved, it's 1  - use that for the 1! in 2 * 1!
 *          sub-problem of 2! solved, it's 2  - use that for the 2! in 3 * 2!
 *          sub-problem of 3! solved, it's 6  - use that for the 3! in 4 * 3!
 *          sub-problem of 4! solved, it's 24 - use that for the 4! in 5 * 4!
 *          sub-problem of 5! solved, it's 120 - OK, original problem solved
 ****************************************************************************/
public class Factorial {

    public static void main(String[] args) {

        long result = iterativeFactorial(5);      
        System.out.printf("5! is %d using iterative algorithm\n", result);
        
        result = recursiveFactorial(5);
        System.out.printf("5! is %d using recursive algorithm\n", result);
                
        System.out.println("\nTRACE OF RECURSIVE ALGORITHM");
        result = recursiveFactorialWithTrace(5);
        System.out.printf("IN MAIN:  5! is %d using recursive alg.\n", result);
        
        System.out.println("-------------------------------------------------");       
        System.out.printf("\n       %20s %20s\n", "ITERATIVE", "RECURSIVE");
        long iterResult;
        long recurResult;
        for (int theNum = 1; theNum <= 15; theNum++) {
            iterResult = iterativeFactorial(theNum);
            recurResult = recursiveFactorial(theNum);
            System.out.printf("%2d! is %20d %20d\n",
                    theNum, iterResult, recurResult);
        }
    }
    //***************************************************** ITERATIVE algorithm
    // (start at N and go down)
    private static long iterativeFactorial(int num) {      
        long total = 1;            // initialize to 1, not 0, since multiplying
        for (long i = num; i > 1; i--)        // save time, go down to 2, not 1
            total = total * i;
        return total;
    }   
    //***************************************************** RECURSIVE algorithm
    private static long recursiveFactorial(int num) {
        if (num == 1)                                   // BASE (stopping) CASE                    
            return 1;
        else                                            // RECURSIVE CASE
            return num * recursiveFactorial(num - 1);
    }
    //****************************************** RECURSIVE algorithm WITH TRACE
    private static long recursiveFactorialWithTrace(int num) {       
        System.out.printf("TOP OF METHOD:  parameter num is %d\n", num);
                
        if (num == 1) {                                 // BASE (stopping) CASE
            System.out.printf("   in BASE       (if)  CASE:  num is %d\n", num);
            return 1;
        } else {                                        // RECURSIVE CASE
            System.out.printf("   in RECURSIVE (else) CASE:  num is %d\n", num); 
            return num * recursiveFactorialWithTrace(num - 1);
        }
    }
}
