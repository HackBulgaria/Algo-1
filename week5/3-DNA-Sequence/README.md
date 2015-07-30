# DNA Sequence

The [Deoxyribonucleic acid](https://en.wikipedia.org/wiki/DNA) is a complex
molecule composed from smaller molecules called Nucleotides. DNA is considered
to be the way genetic information is stored. To form DNA, nucleotides connect
to each other in a chain: each nucleotide can connect with another on one of
its both ends.

In Bioinformatics, the nucleotides are represented with letter codes. For the
purposes of our problem, we will consider that each nucleotide has an unique
representation in uppercase latin letters. The length of the representation
varies between 6 and 32 symbols.

You are given a set of nucleotides and your task is to restore the DNA chain.
Two nucleotides can connect to each other if the last three letters from the
first one match the first three letters from the second one. In the resulting
sequence, the matching letters appear only once.

For example, ABCDEF can connect to DEFCAB to form ABCDEFCAB,
but DEFCAB cannot connect in front of ABCDEF because CAB does not match ABC.

Nucleotides can also bend and rotate in a special way. Basically, their
first three letters can be swapped with their last three letters.

For example ABCTUVXYZ can be also looked at as XYZTUVABC. In other words if
we have ABCTUVXYZ and TVTWEFXYZ, they can connect to form ABCTUVXYZWEFTVT.

Your task is to try to restore the chain and give a possible sequence which
these nucleotides can form. 

## Input

The first line of the input will contain N - the number of nucleotides.
The next N lines will each contain the code of a single nucleotide.

## Output

On the single line of the output print the code of the restored sequence.
If it is not possible to connect the nucleotides in a chain,
print "IMPOSSIBLE".

## Limits

```
1<=N<=10000
```

## Example

Input:

```
9
FFFGASD
FFFJKEK
ASDFHUE
KEKLHUE
HUEWMLS
HUEUFOP
FOPGLEL
MLSALEL
ASDTTPF
```

Output:

```
FFFJKEKLHUEUFOPGLELAMLSWHUEFASDTTPF
```
