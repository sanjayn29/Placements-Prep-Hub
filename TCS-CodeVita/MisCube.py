"""
MisCube
Problem Description
Noir Parker is a passionate speedcuber who spends much of his time practicing with his Rubik's Cube. His younger sister, Peni Parker, enjoys playing pranks on him. Sometimes, she shuffles his cube or comes up with more mischievous plans.

Peni's cunning scheme involves twisting one of the cube's corners and shuffling it. The image below shows this scheme.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@1e34c607:image1.pngcom.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@1e34c607:image2.png

In the above example, Peni rotated the positions of the yellow-red-blue corner of the cube. This tactic makes the cube unsolvable, increasing the challenge for her brother, Noir Parker. As Noir spends time attempting to solve the cube, he senses a shift or alteration that renders it unsolvable. This realization prompts him to recognize that something has changed in the cube, contributing to the puzzle's complexity.

The cube will have six faces Top, Front, Down, Back, Left(L) and Right(R). Each face will consist of a 2x2 square piece, with each square coloured and denoted by indices as illustrated below.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@1e34c607:image3.png

The cube faces comprise six colours, each uniquely represented by small-case alphabetical letters.

A typical cube features six fixed colours, with each face displaying a consistent colour throughout. For example, yellow colour will be opposite to white colour face. But here, cube face colour will not be constant. The colour also varies from the standard one.

Noir recognizes that his usual solving algorithm falls short, and he is reluctant to approach Peni again to inquire about the corner twist. Given the cube, can you help Noir, in finding the twisted corner!?

Note: A twisted corner on a Rubik's Cube is when a single corner piece is rotated on its own

Constraints
a <= Character used to represent colour <= z

0 < moves required to solve the cubes < 5

Input
A Single line containing the twenty-four characters space separated representing the colour present in the index in the cube.

Output
Print the letters representing the colours of the twisted corner in alphabetical order.

Time Limit (secs)
1

Examples
Example 1

Input

y y r y b r r r w w w w o o o o b y b b g g g g

Output

bry

Explanation

It is the same cube depicted in Problem Description section. The image indicates that the blue-red-yellow corner is twisted. So, the output is bry.

Example 2

Input

b y y y r g r r g g w w o o w b r b b w o o y g

Output

bry

Explanation

The image below depicts the cube.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@1e34c607:image4.png

This corner is twisted similarly to example 1, but it has been shuffled with two additional moves.
"""
data = input().split()
face_colours = []

for i in range(0, 24, 4):
    part = data[i:i + 4]
    counts = {}
    for colour in part:
        counts[colour] = counts.get(colour, 0) + 1
    face_colours.append(max(counts, key=counts.get))


top, front, down, back, left, right = face_colours
corners = [
    ((2, "top"), (4, "front"), (16, "left")),
    ((3, "top"), (5, "front"), (20, "right")),
    ((0, "top"), (12, "back"), (16, "left")),
    ((1, "top"), (13, "back"), (20, "right")),
    ((8, "down"), (6, "front"), (18, "left")),
    ((9, "down"), (7, "front"), (22, "right")),
    ((10, "down"), (14, "back"), (18, "left")),
    ((11, "down"), (15, "back"), (22, "right"))
]

normal = {
    "top": top,
    "front": front,
    "down": down,
    "back": back,
    "left": left,
    "right": right
}

for corner in corners:
    values = []
    for index, face in corner:
        values.append((data[index], face))
    wrong = False
    for colour, face in values:
        if colour != normal[face]:
            wrong = True
    if wrong:
        colours = [colour for colour, face in values]
        if len(set(colours)) == 3:
            print(''.join(sorted(colours)))
            break
else:
    print("Not enough clues")