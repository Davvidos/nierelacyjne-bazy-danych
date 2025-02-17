1. MATCH p=shortestPath( (darjeeling:town {name:"Darjeeling"})-[*]-(sandakphu:peak {name:"Sandakphu"}) )
   RETURN p

2. MATCH p=shortestPath( (darjeeling:town {name:"Darjeeling"})-[*]-(sandakphu:peak {name:"Sandakphu"}) )
   WHERE ALL (x IN RELATIONSHIPS(p) WHERE x.winter = 'true')
   RETURN p

3. MATCH p=(darjeeling:town {name:"Darjeeling"})-[*]->(sandakphu:peak {name:"Sandakphu"})
   RETURN p AS path,
   reduce(distance=0, r in relationships(p) | distance+r.distance) AS totalDistance
   ORDER BY totalDistance ASC

4. MATCH (airport:Airport)
   RETURN airport.name, size((airport)<-[:ORIGIN]-()) as degree
   ORDER BY degree DESC

5. MATCH p = (origin:Airport {name: 'LAX'})-[:ORIGIN|DESTINATION*..5]-(destination:Airport)
   WHERE
      origin <> destination AND
      ALL(i IN RANGE(0, LENGTH(p)-1) WHERE
         TYPE(RELATIONSHIPS(p)[i]) = ['ORIGIN', 'DESTINATION'][i%2] AND
         (
            "Airport" IN LABELS(NODES(p)[i]) OR
            (i + 2) > LENGTH(p) OR
            (apoc.date.parse(NODES(p)[i].date,'m','MM/dd/yyyy hh:mm:ss') + NODES(p)[i].duration + 30) < apoc.date.parse(NODES(p)[i+2].date,'m','MM/dd/yyyy hh:mm:ss'))
         ) AND
         REDUCE(s = 0, n IN [k IN RANGE(1, LENGTH(p), 2) | NODES(p)[k]] |
         s + [(n)<-[:ASSIGN]-(ticket) | ticket.price][0]
         ) < 3000
   RETURN destination

6. MATCH p = (origin:Airport {name: 'LAX'})-[:ORIGIN|DESTINATION*..5]-(destination:Airport {name: 'DAY'})
   WHERE
      ALL(i IN RANGE(0, LENGTH(p)-1) WHERE
         TYPE(RELATIONSHIPS(p)[i]) = ['ORIGIN', 'DESTINATION'][i%2] AND
         (
            "Airport" IN LABELS(NODES(p)[i]) OR
            (i + 2) > LENGTH(p) OR
            (apoc.date.parse(NODES(p)[i].date,'m','MM/dd/yyyy hh:mm:ss') + NODES(p)[i].duration + 30) < apoc.date.parse(NODES(p)[i+2].date,'m','MM/dd/yyyy hh:mm:ss'))
         )

   RETURN p, REDUCE(s = 0, n IN [k IN RANGE(1, LENGTH(p), 2) | NODES(p)[k]] | s + [(n)<-[:ASSIGN]-(ticket) | ticket.price][0]) as totalPrice
   ORDER BY totalPrice ASC

7. MATCH p = (origin:Airport {name: 'LAX'})-[:ORIGIN|DESTINATION*..5]-(destination:Airport {name: 'DAY'})
   WHERE
      ALL(i IN RANGE(0, LENGTH(p)-1) WHERE
      TYPE(RELATIONSHIPS(p)[i]) = ['ORIGIN', 'DESTINATION'][i%2] AND
      (
         "Airport" IN LABELS(NODES(p)[i]) OR
         (i + 2) > LENGTH(p) OR
         (apoc.date.parse(NODES(p)[i].date,'m','MM/dd/yyyy hh:mm:ss') + NODES(p)[i].duration + 30) < apoc.date.parse(NODES(p)[i+2].date,'m','MM/dd/yyyy hh:mm:ss'))
      )

   RETURN p, REDUCE(s = 0, n IN [k IN RANGE(1, LENGTH(p), 2) | NODES(p)[k]] | s + [(n)<-[:ASSIGN]-(ticket) | ticket.price][0]) as totalPrice
   ORDER BY totalPrice ASC
   LIMIT 1

8. MATCH p = (origin:Airport {name: 'LAX'})-[:ORIGIN|DESTINATION*..5]-(destination:Airport {name: 'DAY'})
   WHERE
      ALL (t IN RELATIONSHIPS(p) WHERE TYPE(t) <> 'ASSIGN' OR t.class = 'business') AND
      ALL(i IN RANGE(0, LENGTH(p)-1) WHERE
      TYPE(RELATIONSHIPS(p)[i]) = ['ORIGIN', 'DESTINATION'][i%2] AND
      (
         "Airport" IN LABELS(NODES(p)[i]) OR
         (i + 2) > LENGTH(p) OR
         (apoc.date.parse(NODES(p)[i].date,'m','MM/dd/yyyy hh:mm:ss') + NODES(p)[i].duration + 30) < apoc.date.parse(NODES(p)[i+2].date,'m','MM/dd/yyyy hh:mm:ss'))
      )
   RETURN p

9. MATCH (n:Flight)
   WITH collect(n.airline) as airlines
   UNWIND airlines as un
   return un, count(un) as cnt

10. MATCH p=(first:Airport)<-[:ORIGIN]-(f1:Flight)-[:DESTINATION]->(second:Airport)<-[:ORIGIN]-(f2:Flight)-[:DESTINATION]->(third:Airport)
    WHERE first <> second AND second <> third AND first <> third AND
    f1 <> f2 AND
    (apoc.date.parse(f1.date,'m','MM/dd/yyyy hh:mm:ss') + f1.duration + 30) < apoc.date.parse(f2.date,'m','MM/dd/yyyy hh:mm:ss')
    RETURN p, REDUCE(s = 0, n IN [k IN RANGE(1, LENGTH(p), 2) | NODES(p)[k]] | s + [(n)<-[:ASSIGN]-(ticket) | ticket.price][0]) as totalPrice
    ORDER BY totalPrice ASC
    LIMIT 1
