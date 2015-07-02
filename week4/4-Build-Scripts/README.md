# Build Scripts

You are working on a build tool, similar to Apache [ANT](http://ant.apache.org/)
, [make](https://www.gnu.org/software/make/), or [MSBuild](https://github.com/Microsoft/msbuild)
, which builds and links projects into executables. Your tool will be given
a list of projects to compile. Each project may have dependencies on the
projects (i.e. it requires them to be build first before it can build).

Your task is to determine the order in which the projects should be built
so that it is ensured that all dependencies of a project will be built
before the project itself.

## Input

The first line will contain a single integer N - the number of projects to
build. The second line will contain N strings - the names of the projects.
The next line will contain the project you want to build. On each of the
following N lines, on the i-th line there will be a single integer Mi,
followed by Mi strings which describe the projects on which project i
is dependent.

## Output

On a single line on the standard output, print the space-separated names
of the projects in the exact order in which they should be built. If there
is no way to build the projects (i.e. they have circular dependencies),
print "BUILD ERROR" (without the quotes).

## Limits

```
1 <= N <= 50000
```

## Example

Input:

```
5
Extensions Interface Core Common Networking
Interface
3 Common Core Networking
4 Core Common Extensions Networking
0
1 Core
2 Core Common
```

Output:

```
Core Common Networking Extensions Interface
```
