# Resolute
Resolute allows users to define a set of claim functions and associate them with an AADL model. You can use these claim functions to represent the requirements to be satisfied, the verification actions 
used to verify them, and assumptions made by a verification action in order to produce a valid result. You will express the requirements as predicates on subrequirements and verification actions. Verification 
actions invoke Boolean computational functions to represent predicates to be evaluated and general computational functions to compute values to be compared in predicates. The computational function notation 
has its roots in Lute and REAL. You can organize claim functions into a hierarchy where a claim function is satisfied only if its subclaim functions are satisfied according to the specified predicate logic.

With the Resolute tool, users define claim functions and computational functions in Resolute annex libraries, i.e., Resolute annex clauses placed directly in an AADL package. The verification results are then displayed in a view labeled Assurance Case. 

## License

This tool is owned and licensed by Collins Aerospace.  A BSD-like 3-clause license is described in the [LICENSE](https://github.com/loonwerks/formal-methods-workbench/blob/master/LICENSE) file.

## Branches

Development in Resolute takes place on two main branches: 'master' and
'stable.'  The 'master' branch is the leading edge of development of
Resolute and it maintains compatibility with the OSATE master branch.
Developers are encouraged to create branches from the Resolute master
branch to implement new features, address issues, or fix bugs. Once
these branch developments are ready, they may be merged into the 
master branch. ATO be ready for merging onto the master branch,
work must not break build or regression testing, must be deemed
ready for use by the developmental users, and should have a suite
of test cases.

The Resolute 'stable' branch contains the releases of Resolute (since
Resolute 2.7.1).  At time for releases, the progress on the master
branch is merged onto the stable branch.  At this point progress
on the master must be ready for release to the public user community
via a marked release in GitHub.

The Resolute tool development occurs mainly on the **master** branch
of this repository.  The 'master' branch contains the releases and the
HEAD of this branch should contain the latest release.  Individual
development efforts should be completed on branches from the master
branch and then merged back into the master via a **pull request**
including informal peer review.

It is the general policy to consider releases as final; no updates to
releases are made.  Instead all updates are made to the master branch
and incorporated into the next release.

Occasionally, it is desirable to create additional special-purpose
branches for responding to issue/bug reports. These should be made
from a branch from the release point, and if possible, merged onto the
master branch prior to completion of the next release cycle. If such
a branch spans a release, the developer should be merge the updated
master branch onto the special-purpose branch to capture the updated
versioning information and to avoid conflicts merging back into the
develop branch.

Branch names should be chosen to describe the activity to be taken on
the branch.  For example, to develop a new feature 'A', the branch
might be named 'develop-feature-A.'  Or to fix an issue recorded in
the issue base the branch might be named 'fix-issue-x' where x is the
sequence number assigned to the issue.

Tags are typically reserved for releases, but may be used to mark special points in the development process.

## Continuous Integration / Continuous Deployment
The CI/CD pipeline is carried out via GitHub actions. There are three different workflows defined. They are as follows:
   1. "Build and Test Project" (defined in [.github/workflows/build_and_test.yml](https://github.com/loonwerks/Resolute/blob/main/.github/workflows/build_and_test.yml))
      - Trigger(s): 
         * push is made to master 
         * pull request is opened, reopened, or editted
      - Job(s):
         * *verify*: verifies that the project builds without errors and all tests pass by running the command `mvn clean verify` 
   2. "Push snapshot to Github Pages" (defined in [.github/workflows/snapshot.yml](https://github.com/loonwerks/Resolute/blob/main/.github/workflows/snapshot.yml))
      - Trigger(s):
         * "Build and Test Project" successfully completes on master branch
      - Job(s):
         * *verify*: verifies that the project builds without errors all tests pass, and build is a snapshot by running the command `mvn verify -Pbuild-snapshot` 
         * *publish*: publishes the p2 repo of the current build to Resolute-Updates/snapshots/x.x.x.yyyyMMddHHmm
   3. "Push and publish release to GitHub" (defined in [.github/workflows/release.yml](https://github.com/loonwerks/Resolute/blob/main/.github/workflows/release.yml))
      - Trigger(s):
         * a tag was pushed
      - Job(s): 
         * *parse_tag*: parses the tag "x.x.x-RELEASE" into "x.x.x" and "RELEASE"
         * *verify*: if the suffix of tag is "-RELEASE", verifies that the project builds without errors all tests pass, and build is a release by running the command `mvn verify -Pbuild-release` 
         * *parse_version*: parses the version from the built p2 repo
         * *publish*: if the tag and version of the built p2 repo match, publishes the p2 repo of the current build to Resolute-Updates/releases/x.x.x
         * *release*: if the tag and version of the built p2 repo match, generates a release on the Resolute repo and attaches the p2 repo as an artifact

**Important Details about Release Tags** 
- The tag should be in the format x.x.x-RELEASE where x is the major version number, y is the minor version number, and z is the patch version number.
- Make the tag by using the following git commands:
   1. `git tag x.x.x-RELEASE`
   2. `git push origin x.x.x-RELEASE`
- The version number of com.rockwellcollins.atc.resolute needs to match the tag number when triggering a release.