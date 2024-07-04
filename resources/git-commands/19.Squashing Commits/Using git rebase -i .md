The `git rebase -i` command is used for interactive rebasing in Git. It allows you to manipulate and edit commits interactively before integrating them into another branch. This is particularly useful for tasks like reordering commits, editing commit messages, squashing commits together, or even removing commits altogether. Let's walk through an example scenario to demonstrate the `git rebase -i` command in action.

### Scenario: Using `git rebase -i`

#### Introduction

In this scenario, we'll use `git rebase -i` to interactively rebase a feature branch (`feature-branch`) before merging it into the main branch (`main`). We'll squash multiple commits into a single commit and edit commit messages during the interactive rebase.

#### Example Commands and Output

1. **Navigate to the Repository**

   Start by navigating to your Git repository where you have the feature branch that you want to rebase interactively.

   ```bash
   # Change directory to your Git repository
   $ cd /path/to/your/repository
   ```

2. **Start Interactive Rebase**

   Initiate an interactive rebase (`git rebase -i`) for the commits on your feature branch (`feature-branch`).

   ```bash
   $ git checkout feature-branch
   $ git rebase -i main
   ```

   This command opens up an interactive rebase editor with a list of commits since `main` branch diverged from `feature-branch`.

3. **Interactively Edit Commits**

   In the interactive rebase editor that opens:

    - **Pick**: Leave commits you want to keep as-is.
    - **Squash (s)**: Combine a commit with the one before it.
    - **Edit (e)**: Pause rebase at this commit to make changes.

   Example interactive rebase editor:
   ```
   pick abc1234 Commit 1 message
   pick def5678 Commit 2 message
   pick ghi91011 Commit 3 message

   # Rebase abc1234..ghi91011 onto main
   #
   # Commands:
   #  p, pick = use commit
   #  r, reword = use commit, but edit the commit message
   #  e, edit = use commit, but stop for amending
   #  s, squash = use commit, but meld into previous commit
   #  f, fixup = like "squash", but discard this commit's log message
   #  x, exec = run command (the rest of the line) using shell
   #  d, drop = remove commit
   #
   # These lines can be re-ordered; they are executed from top to bottom.
   #
   # If you remove a line here THAT COMMIT WILL BE LOST.
   # However, if you remove everything, the rebase will be aborted.
   #
   ```

4. **Squash Commits**

   Change `pick` to `s` or `squash` for commits you want to squash into the previous commit. Here's an example of squashing commits:

   ```bash
   pick abc1234 Commit 1 message
   squash def5678 Commit 2 message
   squash ghi91011 Commit 3 message
   ```

   Save and close the editor.

5. **Edit Commit Messages (Optional)**

   If you squashed commits, the rebase will pause to allow you to edit the combined commit message.

   ```bash
   # Editor opens for editing combined commit message
   ```

   Edit the commit message as needed, save, and close the editor.

6. **Push Changes**

   If you have already pushed the feature branch (`feature-branch`) to a remote repository, you will need to force push (`git push --force`) to update the remote branch with the rebased commits.

   ```bash
   $ git push --force origin feature-branch
   ```

   **Note:** Use `git push --force` cautiously as it rewrites history and can cause issues for others collaborating on the branch.

### Explanation

- **git rebase -i**: Initiates an interactive rebase, allowing you to interactively modify commit history.
- **Interactive Rebase Editor**: Provides options to pick, squash, edit, or drop commits based on your needs.
- **Squashing Commits**: Combines multiple commits into a single commit to keep the commit history clean and organized.
- **Editing Commit Messages**: Allows you to modify commit messages during the rebase process.
- **Pushing Changes**: After completing the rebase, force push (`git push --force`) to update the remote branch with the modified commit history.

Interactive rebasing (`git rebase -i`) is a powerful tool for maintaining a clean and coherent commit history in Git. It gives you flexibility to organize commits before integrating them into shared branches, facilitating better code review and collaboration workflows.