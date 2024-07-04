### Git Branching

Let's explore Git branching with basic commands to create, list, switch, and delete branches.

#### 1. Create a New Branch

To create a new branch named `feature-branch`:

```bash
git branch feature-branch
```

#### 2. List Branches

To list all branches in the repository:

```bash
git branch
```

#### 3. Switch to a Branch

To switch to the `feature-branch`:

```bash
git checkout feature-branch
```

#### 4. Delete a Branch

To delete the `feature-branch` after merging or when no longer needed:

```bash
git branch -d feature-branch
```

### Explanation

- **Create a New Branch**: `git branch <branch-name>` creates a new branch without switching to it.
- **List Branches**: `git branch` lists all branches in the repository, indicating the current branch with an asterisk (`*`).
- **Switch to a Branch**: `git checkout <branch-name>` switches to the specified branch.
- **Delete a Branch**: `git branch -d <branch-name>` deletes the specified branch.

These commands allow you to effectively manage branches in your Git workflow, facilitating parallel development, feature isolation, and efficient collaboration.