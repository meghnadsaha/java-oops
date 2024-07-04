### Git Add Interactive

Git's interactive add mode allows you to selectively stage changes from your working directory to the staging area (index) in an interactive manner. This is useful when you have made multiple changes across various files and want to carefully choose which changes to include in your next commit.

#### Scenario

You have been working on a project and have made several changes to multiple files. Now, you want to selectively stage some changes while leaving others out of the next commit. Let's go through the steps using Git's interactive add mode.

#### Commands

1. **Check the current status:**

   Before staging changes interactively, review the current status of your repository:

   ```bash
   git status
   ```

2. **Start interactive add mode:**

   Launch Git's interactive add mode to selectively stage changes:

   ```bash
   git add -i
   ```

   This command opens up an interactive prompt where you can choose various options for staging changes.

3. **Choose an option:**

   Git interactive mode provides several options (usually numbered). For example, you might see options like:

   ```plaintext
   1: status
   2: update
   3: revert
   4: add untracked
   5: patch
   ```

   To selectively stage changes interactively, you can choose `5` for `patch` (or another appropriate option depending on your needs).

4. **Select changes to stage:**

   Git will now show you a list of files with changes. You can select files or specific lines within files to stage by typing `y` for yes, `n` for no, `d` for don't know, `s` for split, `q` for quit, `a` for all, `j` for leave unstaged, or `k` to force