# apache-kakfka-practice
Practicing Apache Kafka concepts 

Kafka Commands

1. Run Zookeeper
1.1. Open cmd, go to kafka folder location

cd C:\kafka

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

2. Run kafka Server

2.1 Open cmd, go to kafka folder location

cd C:\kafka

.\bin\windows\kafka-server-start.bat .\config\server.properties


3. Open offset explorer

1. Cluster name: any name (eg: local kafka)
2. Bootstrap servers: localhost:9092
3. Kafka cluster version: 2.1
