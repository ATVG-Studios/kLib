# Contribution Guideline

### File Names

1. File Names are to be written in `CamelCase` (aka `upper camel case` or `PascalCase`).  
  This rule must be applied for any files within `src`, accept for the master file "kLibInfo"
  
### Class Names

1. Class names within files are always to be written in `CamelCase` (aka `upper camel case` or `PascalCase`).

### Function Names

1. Normal Functions  
  Names must be written in `camelCase` (aka `lower camel case`).

2. DSL Functions  
  Names of functions forming a DSL may be written in `CamelCase` (aka `upper camel case` or `PascalCase`) rather
  then `camelCase` (aka `lower camel case`). 
  
## Code Style

### Language

1. In this project we use the programming language `Kotlin` and **NO OTHER**.

2. In this project we use the language `English` (EN, EN_US) and **NO OTHER**.

### Line-Endings

1. In this project we use LF (Unix) File endings and **NO OTHER**.

### Parentheses

1. Opening Parentheses (`{`) always are to be positioned at the line definition lines of Functions and (any kind of) Classes.

2. Closing Parentheses (`}`) are to be placed normally at the end of a block at the correct indent position.

3. `()` Parentheses may only be multi-lined of the content exceeds the Width of your monitor and/or makes the code more readable.

### Comments

1. Declarative comments must be written above of Functions giving at least insights about Parameter and Return Types (Used for Dokka).

2. Comments are only required of the Code does **NOT** speak for itself (accept in case of rule 1).

### Usage of `var`

1. If possible, do not use `var`.

### Package Names

1. Names are to be kept meaning full: `annotations` (Contains Annotations), `functions` (Contains Top-Level functions)

### Class File Names

1. Names are to be kept meaning gull: `ByteArray` (in extensions; Contains ByteArray extensions), `ArrayWord` (in extensions; Contains `Array<Word>` extensions)

2. If a File is created for a type generic context, the `<>` are to be removed: `Array<Word>` => `ArrayWord`.  
  However if no Type is used, no text is given: `Array<*>` => `Array`

## Commits

1. Signing Commits  
  Each and every commit must be signed with a valid PGP key or sub key. The used Key MUST use the same Email
  and Name as the committing Author.

2. Clear descriptions  
  Each and every commit must have a simple summery in the first line of the commit message. A commit message shall also
  include a more detailed summery of what changed in the commit.

3. Simple Commits  
  Each and every commit shall be kept simple. Performing big changes (like adding multiple standalone Interfaces)
  shall be put in multiple commits.

4. Licensing  
  With any commit given by any Author his or her changes are going to be distributed under the Terms of our [License](LICENSE).
  The Author accepts our license by submitting a commit to us.

## Pull Requests

1. Naming  
  Each and every pull request shall have a clear and simple name stating the proposed changes.

2. Description  
  Each and every pull request shall have a summery of changes, a reason why these changes where made and
  if possible a connected Issue listed.

3. Approval  
  Each and every pull request must be approved by the core team. Only with approval by at least 2 core team members
  (if possible) the current Project Manager is allowed to pull changes into the main development branch (master).
