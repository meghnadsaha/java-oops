Certainly! Here are the commands and steps to accomplish each task:

### Scenario: Making changes to a repository and merging them via GitHub.dev

Assume you have a GitHub repository named `my-repo` and you want to follow these steps:

#### 1. Open a repo using GitHub.dev

Open the repository `my-repo` in GitHub.dev:
```bash
# Replace <username> with your GitHub username and <my-repo> with your repository name
open https://github.dev/<username>/my-repo
```

#### 2. Create a branch

Create a new branch named `feature-branch`:
```bash
git checkout -b feature-branch
```

#### 3. Commit changes to the branch

Make changes to files and commit them:
```bash
# Make changes to files
git add .
git commit -m "Made changes for feature XYZ"
git push origin feature-branch
```

#### 4. Create a pull request

Create a pull request from `feature-branch` to `main` (or your base branch):
- Go to your repository on GitHub in the browser and create the pull request using the GitHub UI.

#### 5. Merge the pull request

Merge the pull request using GitHub's interface after reviewing the changes.

#### 6. Delete the branch

Delete the `feature-branch` after merging:
```bash
git checkout main
git branch -d feature-branch   # locally delete the branch
git push origin --delete feature-branch   # delete the remote branch
```

These commands should guide you through the entire process from creating a branch to merging changes and cleaning up the branch afterward.