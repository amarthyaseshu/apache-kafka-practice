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


practice from CLI

4. Create Kafka Topic

C:\kafka\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

5. See configuration of a topic

C:\kafka\bin\windows\kafka-topics.bat --describe --topic test-topic --bootstrap-server localhost:9092


6. See all the topics

C:\kafka\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

7. Send Msg using a Producer

C:\kafka\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic

8. Receive Msg using a Consumer

C:\kafka\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning

9. Deleting a topic

C:\kafka\bin\windows\kafka-topics.bat --delete --topic test-topic --bootstrap-server localhost:9092


If you face issues like Kafka not starting, make sure:

Port 2181 (Zookeeper) and 9092 (Kafka) are free

JAVA is properly set (JAVA_HOME)

