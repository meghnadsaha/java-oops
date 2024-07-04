To pull new updates from the original GitHub repository into your forked repository, you typically need to sync your fork with the upstream repository (the original repository from which you forked). Here’s how you can do it:

### Scenario: Syncing your forked repository with the upstream repository

Assume you have forked a repository named `original-repo` to your own GitHub account as `my-fork`.

#### 1. Add the upstream repository as a remote

First, you need to add the upstream repository (`original-repo`) as a remote to your local repository:

```bash
# Navigate to your local repository
cd path/to/your/repo

# Add the upstream repository as a remote named 'upstream'
git remote add upstream https://github.com/original-owner/original-repo.git
```

Replace `https://github.com/original-owner/original-repo.git` with the actual URL of the original repository.

#### 2. Fetch the latest changes from the upstream repository

Fetch all branches and their respective commits from the upstream repository:

```bash
git fetch upstream
```

#### 3. Merge or rebase the changes into your local branch

Now, you can either merge or rebase the changes from the upstream repository into your local branch (typically `main` or `master`):

##### Using `git merge`:

```bash
git checkout main   # switch to your local main branch
git merge upstream/main   # merge changes from upstream's main branch
```

##### Using `git rebase` (if you prefer a linear history):

```bash
git checkout main   # switch to your local main branch
git rebase upstream/main   # rebase changes from upstream's main branch
```

#### 4. Push the updated local branch to your fork on GitHub

After merging or rebasing the changes from upstream into your local branch, push these changes to your forked repository on GitHub:

```bash
git push origin main
```

#### 5. Clean up (optional)

If you've created a merge commit or rebased your branch, you might want to delete the upstream branch locally:

```bash
git branch -d upstream/main   # delete the local branch tracking upstream if it was created
```

#### Syncing is now complete

Your forked repository (`my-fork`) is now synced with the latest changes from the original repository (`original-repo`). Repeat these steps whenever you want to pull in new updates from the upstream repository into your forked repository.