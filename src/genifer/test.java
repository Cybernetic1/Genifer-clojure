package genifer;

import clojure.lang.RT;
//import clojure.lang.Var;
//import clojure.lang.Compiler;
import clojure.java.api.Clojure;
import clojure.lang.IFn;
// import java.io.StringReader;
import java.util.LinkedList;

public class test {
  public static void main(String[] args) throws Exception {

    // Load the Clojure script -- as a side effect this initializes the runtime.
    // String str = "(ns genifer)"; // (defn foofoo [a b]   (str a \" \" b))";
    // String str = "(ns genifer) (defn foofoo [a b]   (str a \"++\" b))";

    //RT.loadResourceScript("foo.clj");
    // StringReader s = new StringReader(str);
    // RT.init();
    // Compiler.load(s);

    RT.loadResourceScript("genifer/unification.clj");
    
    // Get a reference to the foo function.
    // Var foo = RT.var("genifer.unification", "unify");

    // Call it!
    LinkedList l1 = new LinkedList();
    l1.add(0, Clojure.read("X"));
    l1.add(0, new Integer(1));
    l1.add(0, "(+ 1 2)");
    
    LinkedList l2 = new LinkedList();
    l2.add(0, new Integer(-10));
    l2.add(0, new Integer(1));
    l2.add(0, "(+ 1 2)");
    // Object result = foo.invoke("[X]", "[y]");
    // System.out.println(result);
    
    IFn unify = Clojure.var("genifer.unification", "unify");
    Object result = unify.invoke(Clojure.read("[X]"), Clojure.read("[a y]"));
    System.out.println(result);
    result = Clojure.var("clojure.core", "clojure-version").invoke();
    System.out.println(result);
    result = Clojure.var("clojure.core", "first").invoke(l1);
    System.out.println(result);
    result = unify.invoke(l1, l2);
    System.out.println(result.getClass());
  }
}