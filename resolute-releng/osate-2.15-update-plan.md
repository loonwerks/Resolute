# Plan: Update Resolute to OSATE 2.15

This plan follows the same pattern used in September 2024 for the OSATE 2.14 migration (notably the `b6517ad`, `ff32442`, `3de18ad`, `d293372`, and `0ae988b` commits):

1. update target/pom dependency coordinates,
2. run build/test and fix compatibility issues,
3. refresh update-site references,
4. then perform release and next-development version bumps.

## 1) Prep and branch setup

- Create a dedicated branch (for example `update-for-osate-2.15`).
- Capture baseline build results before touching dependencies:
  - `mvn -U clean verify`
- Record current dependency pins from:
  - root `pom.xml` (`eclipse.version`, `xtext-version`, Tycho versions, OSATE p2 URL),
  - `com.rockwellcollins.atc.resolute.target.target` repository URLs and installable units.

## 2) Determine the OSATE 2.15 dependency matrix

- Identify the exact OSATE 2.15 stable p2 URL.
- From the OSATE 2.15 build metadata/release notes, extract expected companion versions for:
  - Eclipse release train,
  - Xtext,
  - MWE2,
  - Xsemantics,
  - any other repositories consumed in the target file.
- Verify whether Tycho 3.0.5 is still compatible with this stack; if not, prepare a Tycho bump in the same PR (as was done in September 2024).

## 3) Apply dependency updates (core migration commit)

- Update root `pom.xml`:
  - `eclipse.version`,
  - `xtext-version`,
  - OSATE p2 repository URL (`2.14.0-vfinal` -> `2.15.0-vfinal` or the exact released qualifier),
  - Tycho/Tycho extras if required.
- Update `com.rockwellcollins.atc.resolute.target/com.rockwellcollins.atc.resolute.target.target`:
  - bump `sequenceNumber`,
  - update repository URLs to the versions aligned with OSATE 2.15,
  - adjust installable unit IDs if any changed (similar to the 2.14 update where some IDs moved/renamed).
- Keep each logical change grouped and reviewable (single migration commit preferred).

## 4) Regenerate/reconcile generated artifacts and compile fixes

- Run full build:
  - `mvn -U clean verify`
- If Xtext/EMF APIs changed, regenerate or update generated sources in:
  - `com.rockwellcollins.atc.resolute/src-gen`,
  - `com.rockwellcollins.atc.resolute.ui/src-gen`,
  - any other generated locations touched by migration tooling.
- Fix compile/runtime issues caused by API drift (imports, package moves, deprecated API removals).
- Re-run full build until green.

## 5) Validate runtime behavior

- Execute plugin and integration tests:
  - `mvn -U verify`
- Manually smoke test in Eclipse/OSATE runtime workbench:
  - open sample projects,
  - parse/build Resolute annexes,
  - run assurance case generation,
  - check views/editors for regressions.
- Confirm no p2 resolution errors for all target environments (win32/linux/macos) used by Tycho config.

## 6) Update site references and release metadata

- Update update-site/category references if required by the new dependency baseline (same class of change as September 2024 `Update site references`).
- If this migration is bundled with a release:
  - run version-management release update across MANIFEST.MF/pom/feature/site files,
  - then apply next-development version bump.
- If not releasing immediately, keep versions at development level and defer release bump commits.

## 7) CI verification and publication readiness

- Ensure GitHub Actions equivalent of local commands pass:
  - build-and-test workflow,
  - snapshot/release constraints (depending on branch/tag context).
- Validate generated p2 repository content and installability in a clean OSATE 2.15 installation.

## 8) PR structure recommendation

Use a small sequence of commits mirroring the successful September 2024 flow:

1. **Dependency migration** (`pom.xml` + target file, plus Tycho if needed),
2. **Compatibility fixes/regenerated code**,
3. **Site reference updates** (if needed),
4. **Release version bump** (optional, only if releasing),
5. **Next development version bump** (optional, only if releasing).

## 9) Exit criteria

- OSATE 2.15 p2 repository is referenced in root `pom.xml` and target definition.
- Project builds clean with `mvn -U clean verify`.
- Tests pass and smoke tests succeed in OSATE 2.15 runtime.
- Update site is installable and free of dependency resolution errors.
- PR documents migration details, known caveats, and any deferred follow-up tasks.
