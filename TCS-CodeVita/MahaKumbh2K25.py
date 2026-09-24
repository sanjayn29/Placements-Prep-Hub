"""
MahaKumbh2K25
Problem Description
The Kumbh is a massive spiritual event held every 12 years in India, attracting millions of pilgrims. Every 12th Kumbh which comes after 144 years of previous Maha Kumbh is the most recent Maha Kumbh. Most recent such Maha Kumbh happened in 2025. This influx of devotees puts significant pressure on transportation services, especially the railways.
This grand spiritual event takes place at the sacred confluence of the Ganga, Yamuna, and the Saraswati rivers. During this time, millions of people travel from various nearby cities to participate in the holy festival, which is believed to cleanse the soul and wash away sins through a sacred dip at the confluence.

Due to the massive number of travellers, transport services around the festival site experience heavy rush and delays. Among all available modes of transport, the railways become the most preferred and widely used service by the devotees. As a result, railway stations and trains get extremely crowded, and managing the smooth movement of trains becomes a major challenge for the authorities.

To accommodate heightened demand, railway officials systematically oversee and adjust track connections throughout the day. Their main activities include:

Disconnecting certain tracks between stations to divert train routes and manage traffic.
Connecting tracks between stations to create new travel routes as needed.
Additionally, ongoing railway construction can restrict some trains from passing through specific stations. These restrictions apply only to trains starting from certain source stations.

Many families travel according to their own priorities and schedules. Before traveling, they need to check if a valid route exists from their starting station to their destination, considering the latest track arrangements and any restrictions.

Constraints
2 <= N, Q, R <= 14

Input
The first line contains a single integer, N, indicating the number of lines that define station connections.

Lines 2 to N+1 show each source station and its connected stations as follows:

source_station, station1, station2 ... stationK (Connections are bidirectional.)

Line N+2 contains single integer Q - representing the number of queries.

The following Q lines, i. e. lines N+3 to N+Q+2 contains Q queries in the below format.

source_station to destination_station: Check if travel is possible between these stations.
station1 connects station2: Connect these two stations.
station1 disconnects station2: Disconnect these two stations.
The next line, Line N+Q+3 contains a single integer, R, indicating the number of restriction lines.

The following R lines (N+Q+4 to N+Q+R+3) specify restrictions in this format:

source_station, restricted_station1, restricted_station2.... restricted_stationM.

(Trains starting from source_station cannot pass through the listed restricted stations.)

Output
For each travel query, output "yes" or "no" (without quotes) on a separate line, indicating whether the journey is possible.

Time Limit (secs)
1

Examples
Example 1

Input

3

prayagraj varanasi chitrakoot

chitrakoot ayodhya lucknow vindhyachal

sarnath ayodhya chitrakoot kushinagar jaunpur

5

prayagraj to jaunpur

prayagraj connects kushinagar

prayagraj to jaunpur

prayagraj disconnects kushinagar

prayagraj to sarnath

2

chitrakoot jaunpur varanasi

prayagraj ayodhya

Output

yes

yes

yes

Explanation

Initial connections between the stations are as follows:

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@1162410a:image1.png

When the first query is checked, the answer is visibly "yes", people can travel from prayagraj to jaunpur. There are multiple paths to go from prayagraj to jaunpur which includes one path containing ayodhya, but we must exclude that path considering the restrictions.

The second query states that the track between prayagraj and kushinagar gets connected. After this, when the third query is checked, the answer is "yes", people can travel from prayagraj to jaunpur.

The fourth query states that the track between prayagraj to kushinagar gets disconnected. After this, when the fifth query is checked, the answer remains "yes", people can travel through prayagraj to sarnath.

Example 2

Input

3

prayagraj varanasi chitrakoot

chitrakoot ayodhya lucknow vindhyachal

sarnath ayodhya kushinagar jaunpur

5

prayagraj to jaunpur

prayagraj connects kushinagar

prayagraj to jaunpur

prayagraj disconnects kushinagar

prayagraj to sarnath

2

chitrakoot jaunpur varanasi

prayagraj ayodhya

Output

no

yes

no

Explanation

The initial connections between the stations are as follows:

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@1162410a:image2.png

When the first query is checked, the answer is "no" because there is only one path from prayagraj to jaunpur which includes visiting ayodhya. We must exclude that path because of the restrictions provided.

When the second query is executed, the track between pyaragraj to kushinagar is connected. Now when checking for the third query, the answer is "yes" as we have multiple paths going from prayagraj to jaunpur.

When the fourth query is executed, the path beween prayagraj and kushinagar is disconnected.

When checking for the fifth query, the answer is "no" because for going from prayagraj to sarnath, there is only one path, which passes through ayodhya which is restricted if the train's source station is prayagraj.
"""

from collections import deque
n = int(input())
connections = {}

for _ in range(n):
    data = input().split()
    station = data[0]
    if station not in connections:
        connections[station] = set()
    for next_station in data[1:]:
        connections[station].add(next_station)
        if next_station not in connections:
            connections[next_station] = set()
        connections[next_station].add(station)

q = int(input())
queries = []
for _ in range(q):
    queries.append(input().split())

r = int(input())
blocked = {}
for _ in range(r):
    data = input().split()
    source = data[0]
    blocked[source] = set(data[1:])

answers = []
for query in queries:
    if query[1] == "to":
        source = query[0]
        destination = query[2]
        forbidden = blocked.get(source, set())
        if source == destination:
            answers.append("yes")
            continue

        visited = {source}
        queue = deque([source])
        possible = False
        while queue:
            current = queue.popleft()
            for next_station in connections.get(current, set()):
              if next_station in visited:
                    continue
                if next_station in forbidden:
                    continue
                if next_station == destination:
                    possible = True
                    break
                visited.add(next_station)
                queue.append(next_station)
            if possible:
                break
        if possible:
            answers.append("yes")
        else:
            answers.append("no")
    else:
        station1 = query[0]
        operation = query[1]
        station2 = query[2]
        if operation == "connects":
            connections.setdefault(station1, set()).add(station2)
            connections.setdefault(station2, set()).add(station1)
        elif operation == "disconnects":
            connections.get(station1, set()).discard(station2)
            connections.get(station2, set()).discard(station1)


for answer in answers:
    print(answer)