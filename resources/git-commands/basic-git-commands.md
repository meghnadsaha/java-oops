## Basic Git commands :-

<hr>

### 1. Open a repo using GitHub.dev:

Navigate to `https://github.dev/username/repository`, where `username` is your GitHub username and `repository` is the name of the repository you want to open.

**Example:**
```
https://github.dev/octocat/hello-world
```

### 2. Open the forked repository in GitHub.dev:

Navigate to your forked repository's URL on GitHub.dev.

**Example:**
```
https://github.dev/your-username/forked-repo
```

### 3. Create a branch:

Use `git checkout -b branch-name` to create and switch to a new branch.

**Example:**
```bash
git checkout -b feature-branch
```

### 4. Commit changes to the branch:

First, check the status of your repository using `git status`. Then, use `git add` to stage changes and `git commit` to commit them.



### 4.1. Checking the Status of Your Repository (`git status`):

The `git status` command is used to see the current state of your repository, including:

- Which files are staged for commit.
- Which files are modified but not yet staged.
- Which files are untracked (Git doesn't know about them).

**Usage:**
```bash
git status
```

**Example Output:**
```
On branch main
Your branch is up to date with 'origin/main'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   index.html

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        newfile.txt

no changes added to commit (use "git add" and/or "git commit -a")
```

- **On branch main**: Indicates the current branch you are working on.
- **Changes not staged for commit**: Shows files that have been modified but not yet staged for commit.
- **Untracked files**: Lists files that Git does not yet know about.

### 4.2. Adding Files to the Staging Area (`git add`):

The `git add` command is used to add changes in the working directory to the staging area. This prepares them to be included in the next commit.

**Usage:**
```bash
git add <file>
```
- `<file>`: The specific file you want to stage. You can also use `.` to add all modified files.

**Example:**
```bash
git add index.html
```

This command stages the `index.html` file for the next commit.

### Summary:

- **`git status`** helps you understand the current state of your repository.
- **`git add <file>`** stages changes for commit, preparing them to be included in the next commit snapshot.


**Example:**
```bash
git status
git add index.html
git commit -m "Updated index.html with new content"
```

### 5. Create a pull request:

Go to your repository on GitHub.dev, switch to the branch you want to merge, and create a pull request.

**Example:**
- Navigate to `https://github.com/your-username/repository`.
- Switch to `feature-branch`.
- Create a pull request to merge `feature-branch` into `main`.

### 6. Merge the pull request:

Once the pull request is approved, merge it using the GitHub UI.

**Example:**
- On GitHub, navigate to your pull request.
- Click on the "Merge pull request" button.
- Confirm the merge.

### 7. Delete the branch:

After merging, delete the branch to keep your repository clean.

**Example:**
- Delete the branch using Git command after merging:
```bash
git branch -d feature-branch
```
- Alternatively, you can delete the branch via GitHub's interface after the merge.

These steps should guide you through the process of managing a Git repository using GitHub.dev, from opening and forking repositories to making changes, creating pull requests, merging them, and cleaning up branches.