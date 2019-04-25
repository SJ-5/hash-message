# hash-message

How to run:
- Build with maven

- Run with jar
```
java -jar hash-message-1.0.jar
```

As number of request/second increase, the bottlenecks of my application would be preformance and memory.
We can do the following to scale the service:
1. Add a database to hold the results. So there won’t be memory constraint and data would be persisted after server shutdown.
2. Run more instances of the server
3. Add load balancer to distribute external requests to the servers. 
4. Use cache to reduce database queries
5. Use consistent hashing to forward same requests to the same server for better response speed and less database queries, since the result is already cached.
