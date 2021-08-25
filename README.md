# Resolute
Resolute allows users to define a set of claim functions and associate them with an AADL model. You can use these claim functions to represent the requirements to be satisfied, the verification actions 
used to verify them, and assumptions made by a verification action in order to produce a valid result. You will express the requirements as predicates on subrequirements and verification actions. Verification 
actions invoke Boolean computational functions to represent predicates to be evaluated and general computational functions to compute values to be compared in predicates. The computational function notation 
has its roots in Lute and REAL. You can organize claim functions into a hierarchy where a claim function is satisfied only if its subclaim functions are satisfied according to the specified predicate logic.

With the Resolute tool, users define claim functions and computational functions in Resolute annex libraries, i.e., Resolute annex clauses placed directly in an AADL package. The verification results are then 
displayed in a view labeled Assurance Case. 

## License

This tool is owned and licensed by Collins Aerospace.  A BSD-like 3-clause license is described in the [LICENSE](https://github.com/loonwerks/formal-methods-workbench/blob/master/LICENSE) file.

## Development Guide

TBD

### Branches and Tags

Development in Resolute takes place on two main branches: 'master' and
'stable.'  The 'master' branch is the leading edge of development of
AGREE and it maintains compatibility with the OSATE master branch.
Developers are encouraged to create branches from the Resolute master
branch to implement new features, address issues, or fix bugs.  Once
these branch developments are ready, they may be merged into the 
master branch.  ATO be ready for merging onto the master branch,
work must not break build or regression testing, must be deemed
ready for use by the developmental users, and should have a suite
of test cases.

The Resolute 'stable' branch contains the releases of Resolute (since
Resolute 2.7.1).  At time for releases, the progress on the master
branch is merged onto the stable branch.  At this point progress
on the master must be ready for release to the public user community
vi a marked release in GitHub.

The Resolute tool development occurs on mainly on the **master** branch
of this repository.  The 'master' branch contains the releases and the
HEAD of this branch should contain the latest release.  Individual
development efforts should be completed on branches from the master
branch and then merged back into the master via a **pull request**
including informal peer review.

It is the general policy to consider releases as final; no updates to
releases are made.  Instead all updates are made to the master branch
and incorporated into the next release.

Occasionally it is desirable to create additional special-purpose
branches for responding to issue/bug reports.  These should be made
from a branch from the release point and, if possible, merged onto the
master branch prior to completion of the next release cycle.  If such
a branch spans a release, the developer should be merge the updated
master branch onto the special-purpose branch to capture the updated
versioning information and to avoid conflicts merging back into the
develop branch.

Branch names should be chosen to describe the activity to be taken on
the branch.  For example, to develop a new feature 'A', the branch
might be named 'develop-feature-A.'  Or to fix an issue recorded in
the issue base the branch might be named 'fix-issue-x' where x is the
sequence number assigned to the issue.

Tags are typically reserved for releases, but may be used to mark
special points in the development process.

### Continuous Integration / Continuous Deployment

Resolute continuous integration is carried out at
[Travis-CI](https://www.travis.org).  Daily builds of developmental
snapshots are uploaded to the GitHub
[Resolute releases](https://github.com/loonwerks/Resolute/releases) page.
Additionally, Travis-CI conducts builds and tests in response to pull
requests against the Resolute repository.

### Releases

The process for a release updates master branch with the release
version number, commits the master branch version number updates,
builds the release version, updates the version numbering to the new
development snapshot numbers, and finally commits the master branch
with the new development version numbering.  To accomplish the release
preparation, the Resolute release process applies the [Tycho Release
Workflow](https://wiki.eclipse.org/Tycho/Release_Workflow) to help
automate the process.  The steps in the release workflow are as
follows:

1. Prepare for the release by running the release workflow plugin:

   `mvn release:prepare -DreleaseVersion=x.x.x
   -DdevelopmentVersion=y.y.y-SNAPSHOT`

   where 'x.x.x' is replaced withe the desired version number for the
   release and 'y.y.y' is replaced with the desired version number for
   the next development cycle.  The SNAPSHOT qualifier must be
   appended to the development version as shown to facilitate the
   CI/CD automation of interim development builds.

   During this process maven will ask for the tag to applied to the
   release. Release tags shall be of the form 'x.y.z-RELEASE' where
   `x` is the major version number, `y` is the minor version number,
   and `z` is the patch version number.  Ordinarily, Resolute would
   follow the [Semantic Versioning](https://semver.org/) method.
   However, OSATE does not guarantee that micro versions have backward
   compatible API changes and Resolute must follow this.

   Also during the process an apparent bug in the Tycho release plugin
   will likely be encountered due to the apparent failure to be able
   to resolve the new version of the target. DON'T PANIC! If this
   occurs, edit the parent-level pom.xml and update the version of the
   target at approximately line 155, updating it to the new release
   version. Then resume the release process with the same command line
   as before.

   And, the same thing will happen again as it updates the manifests
   for the new development version.  Again edit the parent-level
   pom.xml and update the version of the target at approximately line
   155, updating to the new development version.  Then, again, resume
   the release process with the same command line as before.

1. Ordinarily one would expect to actually perform the release using
   the customary `mvn release:perform -Dgoals="clean verify"` command.
   However, this appears to run into difficulty fetching the appropriate
   tag to build.  Instead do the following:

   `git checkout x.x.x-RELEASE`
   `mvn clean verify`

   where `x.x.x` is the version number to be released.

1. Commit the release binaries into the companion releases repository at
   git@github.com:loonwerks/Resolute-releases.git:

   `git add ...`

   `git commit -m "Commit release binaries into repository"`

1. Finally, push the update develop branch to the origin repository:

   `git push`

Note that the previous instructions assume that the developer has set
up appropriate ssh keys such that interactive query for authentication
is necessary.  If this is not done, the `release:prepare` and
`release:perform` steps will apparently just hang when such
interaction is required as they are in fact headless operations.
Alternatively to setting up ssh keys, the developer may add necessary
authenication information to the maven settings as described in [Tycho
Release Workflow -- Configure the
SCM](https://wiki.eclipse.org/Tycho/Release_Workflow#Configure_the_SCM).
