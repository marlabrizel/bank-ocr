# Implementation notes

## Progress notes
- Almost to a working I1. I think there is something funky going on with
  newlines that is causing test failures. Consider ways to refactor tests

## Next steps
Once the initial set of tests pass, next items to tackle:
- Clean up commit history: WIP commits should be rebased
- This shouldn't all live in the core ns -> refactor into separate namespaces
  that more closely follow SRP
- Add sad path testing/implementation: what should happen if an invalid entry
  gets passed through? Implement elegant failure
- Implement file i/o - entry point into application that reads in a file and
  kicks off processing sequence. Enhance tests to read from fixture file
- Continue with next iterations
