Certainly! Let's go through a scenario where we squash commits using `git rebase -i` to combine multiple commits into a single cohesive commit. This is useful for cleaning up the commit history before merging branches or submitting pull requests.

### Scenario: Squashing Commits

#### Introduction

In this scenario, we'll work through an example where we have multiple commits in a feature branch that we want to squash into a single commit before merging into the main branch.

#### Example Commands and Output

1. **Navigate to the Repository**

   Start by navigating to the Git repository where you have the branch with multiple commits that you want to squash.

   ```bash
   # Change directory to your Git repository
   $ cd /path/to/your/repository
   ```

2. **View Commit History**

   Use `git log --oneline` to view the recent commit history and identify the commits you want to squash.

   ```bash
   $ git log --oneline
   ```

   Output:
   ```
   abc1234 Commit 1 message
   def5678 Commit 2 message
   ghi91011 Commit 3 message
   ```

   Identify the commit hashes (`abc1234`, `def5678`, `ghi91011`) that you want to squash into a single commit.

3. **Start Interactive Rebase**

   Use `git rebase -i HEAD~3` to start an interactive rebase for the last 3 commits (`HEAD~3` refers to the last 3 commits including `HEAD`).

   ```bash
   $ git rebase -i HEAD~3
   ```

   This opens an interactive rebase editor where you can specify which commits to squash, pick, or edit.

4. **Squash Commits**

   In the interactive rebase editor, mark the commits you want to squash by changing `pick` to `squash` or `s` for the commits you want to squash into the preceding commit.

   ```bash
   pick abc1234 Commit 1 message
   squash def5678 Commit 2 message
   squash ghi91011 Commit 3 message
   ```

   Save and close the editor.

5. **Edit Commit Message**

   If you chose to squash commits, the editor will open again for you to edit the combined commit message. Modify the commit message as needed and save it.

   ```bash
   # This will open the editor with the combined commit message
   ```

   Save and close the editor.

6. **Push Changes**

   If you have already pushed the branch to a remote repository, you will need to force push (`git push --force`) the changes to update the branch with the squashed commit history.

   ```bash
   $ git push --force origin feature-branch
   ```

   **Note:** Be cautious with `git push --force` as it rewrites history and can cause problems if others are collaborating on the branch.

### Explanation

- **git rebase -i**: Initiates an interactive rebase where you can squash, reorder, edit, or drop commits interactively.
- **Interactive Rebase Editor**: Allows you to specify which commits to squash (`s` or `squash`), reorder (`move`), edit (`edit`), or drop (`drop`).
- **Squashing Commits**: Combines multiple commits into a single commit to maintain a clean and concise commit history.

Squashing commits is beneficial for keeping the Git history clean and understandable, especially before merging feature branches into the main branch or submitting pull requests. It consolidates related changes into meaningful commits, making it easier to review and understand the development history of a project.