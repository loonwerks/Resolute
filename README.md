# Resolute
Resolute allows users to define a set of claim functions and associate them with an AADL model. You can use these claim functions to represent the requirements to be satisfied, the verification actions 
used to verify them, and assumptions made by a verification action in order to produce a valid result. You will express the requirements as predicates on subrequirements and verification actions. Verification 
actions invoke Boolean computational functions to represent predicates to be evaluated and general computational functions to compute values to be compared in predicates. The computational function notation 
has its roots in Lute and REAL. You can organize claim functions into a hierarchy where a claim function is satisfied only if its subclaim functions are satisfied according to the specified predicate logic.

With the Resolute tool, users define claim functions and computational functions in Resolute annex libraries, i.e., Resolute annex clauses placed directly in an AADL package. The verification results are then 
displayed in a view labeled Assurance Case. 

## License

This tool is owned and licensed by Collins Aerospace.  A BSD-like 3-clause license is described in the [LICENSE](https://github.com/loonwerks/formal-methods-workbench/blob/master/LICENSE) file.