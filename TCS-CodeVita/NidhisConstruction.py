"""
NidhisConstruction
Problem Description
Nidhi enjoys arranging unit cubes so that each cube is placed next to another, forming interesting geometric patterns. The goal is to create a structured configuration from these cubes.

Nidhi starts with a set of unit cubes; each assigned a unique number. She builds a structure by placing each new cube adjacent to an existing one, following a series of commands. Each command specifies:

The number of the existing cube,
The number of the new cube,
The direction in which the new cube is placed (relative to the existing cube)
You are given a cube number and your task is to process these commands and, for a given cube, output the numbers of the cubes on its four sides: Up, Down, Left, and Right (in that order).

Important Notes:

Cube numbers range from 1 to M, where M is the total number of cubes (not provided in the input).
Before processing the commands, order them in ascending order of existing cube number followed by new cube number (if exisiting cube numbers are equal).
If a new cube is placed where another already exists, the new cube replaces the old one.
The structure remains fully connected at all times.
Constraints
1 <= number of cubes <= 50

Input
The first line contains an integer N, the number of commands.

The next N lines each contain a command in the format:
<existing_cube> <new_cube> <direction>

The final line contains the number of the cube for which you need to print the four side values.

Output
Print the numbers of the cubes on the four sides (Up, Down, Left, Right) of the specified cube, separated by spaces. If there is no cube on a particular side, print -1 for that side.

Time Limit (secs)
1

Examples
Example 1

Input

8

5 6 right

1 8 top

5 7 left

1 3 left

1 2 right

1 4 down

4 5 down

5 9 down

9

Output

5 -1 -1 -1

Explanation

The given structure Nidhi constructed with cubes is shown below.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@a52ca2e:image1.png

As we can see that for the cube with number 9, the top is 5, down, left and right are empty, hence the output is 5 -1 -1 -1.

Example 2

Input

6

4 5 right

1 2 left

3 4 right

1 3 down

1 6 top

4 7 top

1

Output

6 3 2 7

Explanation

The given structure Nidhi constructed with cubes is shown below.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@a52ca2e:image2.png

As we can see that for the cube with number 1, the top, down, left and right are 6, 3, 2, 7 respectively. Hence the output is 6 3 2 7 """

n = int(input())

commands = []

for _ in range(n):
    a, b, direction = input().split()
    commands.append((int(a), int(b), direction))
target = int(input())

commands.sort(key=lambda x: (x[0], x[1]))

directions = {
    "top": (0, 1),
    "down": (0, -1),
    "left": (-1, 0),
    "right": (1, 0)
}

cube = {}
place = {}
first = commands[0][0]
cube[first] = (0, 0)
place[(0, 0)] = first

for a, b, direction in commands:
    x, y = cube[a]
    dx, dy = directions[direction]
    new_pos = (x + dx, y + dy)

    if new_pos in place:
        old_cube = place[new_pos]
        del place[new_pos]
        del cube[old_cube]

    if b in cube:
        old_pos = cube[b]
        del cube[b]
        del place[old_pos]

    cube[b] = new_pos
    place[new_pos] = b

x, y = cube[target]

positions = [
    (x, y + 1),
    (x, y - 1),
    (x - 1, y),
    (x + 1, y)
]
answer = []
for pos in positions:
    answer.append(place.get(pos, -1))

print(*answer)