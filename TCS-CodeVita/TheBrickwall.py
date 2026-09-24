"""
TheBrickwall
Problem Description
A plumber needs to install pipelines on a brick wall. To do this, some bricks must be broken to fit the pipes.

There are two types of bricks in the wall:

Red Bricks (R): Hard to break.
Green Bricks (G): Easy to break.
The plumber will only break Green Bricks to make the job easier. The wall is represented as a square grid, with each brick type and its length specified (e.g., "3R" means a Red Brick of length equal to three unit Bricks). The wall also includes a Source (S) where the pipe starts and a Destination (D) where it ends.

Pipes can be laid either vertically or horizontally, moving from the current brick to any adjacent Green Brick (up, down, left, or right). The goal is to find the minimum number of Green Bricks that must be broken to connect the source to the destination. Red Bricks cannot be used.

Assume the layout of the brick wall is shown below.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@124d02b2:image1.png

The input notation to represent the above brick wall is shown below:

3R1D
1R1R1R1G
2G1G1G
2S2R

Constraints
3<=N<=25

Input
The first line contains N, the size of the wall (N x N).
The next N lines describe the wall layout using the notation above.

Output
Print a single integer: the least number of Green Bricks that need to be broken.

Time Limit (secs)
1

Examples
Example 1

4

3R1D

1R1R1R1G

2G1G1G

2S2R

Output

4

Explanation

The input and image already shown in description.

From the image we can see that 4 bricks need to be destroyed to lay pipes between source and destination.

Example 2

Input

5

3G1R1G

1G1R1G2R

1S1R1G1R1D

2R1G1R1G

5G

Output

7

Explanation

The image below represents the above input.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@124d02b2:image2.png

From this you can see that 7 bricks must be broken to lay pipelines between source and destination.
"""
from collections import deque
n = int(input())
grid = []
start = None
end = None

for i in range(n):
    line = input()
    row = []
    j = 0
    k = 0

    while k < len(line):
        num = ""
        while k < len(line) and line[k].isdigit():
            num += line[k]
            k += 1
        ch = line[k]
        k += 1
        length = int(num)
        for _ in range(length):
            row.append(ch)
            if ch == 'S':
                start = (i, j)
            if ch == 'D':
                end = (i, j)
            j += 1
    grid.append(row)


dist = [[float('inf')] * n for _ in range(n)]
dist[start[0]][start[1]] = 0
q = deque()
q.append(start)

directions = [
    (-1, 0),
    (1, 0),
    (0, -1),
    (0, 1)
]

while q:
    x, y = q.popleft()
    for dx, dy in directions:
        nx = x + dx
        ny = y + dy
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        if grid[nx][ny] == 'R':
            continue
        cost = 1 if grid[nx][ny] == 'G' else 0
        new_dist = dist[x][y] + cost
        if new_dist < dist[nx][ny]:
            dist[nx][ny] = new_dist
            if cost == 0:
                q.appendleft((nx, ny))
            else:
                q.append((nx, ny))

print(dist[end[0]][end[1]])