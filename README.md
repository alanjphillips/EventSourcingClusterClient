Event Sourcing Cluster Demo Client (Producer)
============================================
Horizontally scaled out use of Akka Cluster Sharding with Cassandra Cluster configured for persistence. Messages are consumed from Kafka and persisted to Cassandra using akka-persistence

Producer-side
-------------
Http interface to start publishing commands

Distribute generated Kafka messages to Kafka partitions across multiple Kafka brokers