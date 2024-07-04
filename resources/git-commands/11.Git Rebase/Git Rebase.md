### Introduction: Git Rebase

Git rebase is a powerful tool used to integrate changes from one branch onto another by rewriting commit history. Unlike merging, which creates new commit objects, rebasing re-applies the commits on top of the branch you are rebasing onto. This can create a cleaner, linear commit history.

#### Outline of a Simple Rebase

In this example, we'll demonstrate a simple rebase scenario where changes from a feature branch (`feature-branch`) are rebased onto the `main` branch.

#### Walkthrough of a Simple Rebase

Let's walk through the steps involved in performing a simple rebase using Git commands.

#### Scenario

Assume we have a repository with a `main` branch and a `feature-branch`. We want to rebase `feature-branch` onto `main` to incorporate recent changes from `main` into our feature branch.

#### Commands and Output

1. **Check the current status:**

   Before starting the rebase, check the current status of your repository.

   ```bash
   $ git status
   On branch feature-branch
   Your branch is up to date with 'origin/feature-branch'.

   nothing to commit, working tree clean
   ```

   Ensure you are on the correct branch (`feature-branch`) and there are no pending changes.

2. **Rebase `feature-branch` onto `main`:**

   Start the rebase process to incorporate changes from `main` into `feature-branch`.

   ```bash
   $ git rebase main
   First, rewinding head to replay your work on top of it...
   Applying: Implemented feature XYZ
   ```

   Git rewinds `feature-branch` to the point where it diverged from `main`, applies the commits from `main` onto it, and then applies the commits from `feature-branch` on top of `main`.

3. **Resolve any conflicts (if necessary):**

   If there are conflicts during the rebase process, Git will pause and prompt you to resolve them. Manually resolve conflicts in each conflicted file, then continue the rebase.

   ```bash
   # Resolve conflicts in conflicted files
   $ git add <resolved-file>
   $ git rebase --continue
   ```

4. **Complete the rebase:**

   After resolving conflicts, continue the rebase process.

   ```bash
   $ git rebase --continue
   ```

   Git completes the rebase, applying all commits from `feature-branch` onto `main`.

5. **Verify the rebase:**

   Check the commit history and verify that the rebase was successful.

   ```bash
   $ git log --oneline --graph --decorate --all
   * a1b2c3d (HEAD -> feature-branch) Implemented feature XYZ
   * e5f6g7h (main) Update README.md
   ```

   The output shows a linear commit history with `feature-branch` now incorporating changes from `main`.

6. **Push changes (if necessary):**

   If you've rebased a branch that has already been pushed to a remote repository, you may need to force-push to update the remote branch.

   ```bash
   $ git push origin feature-branch --force
   ```

   **Note:** Use caution with `--force` as it overwrites the remote branch history.

### Explanation

- **Git Rebase (`git rebase main`)**: Re-applies commits from `feature-branch` on top of `main`, creating a linear history.
- **Conflict Resolution**: If conflicts occur, manually resolve conflicts in conflicted files, stage changes (`git add`), and continue the rebase (`git rebase --continue`).
- **Verification**: Check the commit history (`git log`) to ensure the rebase was successful and the branch now reflects the changes from the base branch (`main`).
- **Pushing Changes**: If the rebased branch has been previously pushed, force-push (`git push --force`) to update the remote branch with the rebased history.

Git rebase is useful for maintaining a clean and linear commit history, especially when integrating changes from one branch into another. However, use it carefully, especially when rebasing branches that have been shared with others, as it alters commit history.