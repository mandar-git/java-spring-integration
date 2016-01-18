# java-spring-integration


Spring Integration Aggregator Example

An example of how Aggregator Messaging Component of Spring Integration works. This example shows the usage of an Aggregator which
aggregates messages based on 2 types.

1. Based on the @Aggregator method which groups messages based on a certain criteria.
2. Based on the Spring Expression used or passed to the Aggregator defined in the context.xml.


The grouped messages can be released as a single message when a certain criteria is met. This example uses the size of payload using a Spring Expression in the context.xml to release the messages. One may also use the Header property of the message and
check if the Header contains a certain value (e.g. 'EOM' or 'TRAILER' string) to identify when to complete the grouping of aggregated messages.


Below Spring Integration components are used.

1. Gateway -> This is invoked to abstract sending messages on a particular channel. Invoking then the process() method on the Gateway sends a message to the specified request channel instead of using an explicit channel.send().

2.  Service Activator -> This method on the service activator class /component is invoked when message arrivevs on the input channel (from Gateway) and this processes the message and sends it to the Output channel

3. Aggregator -> This component groups the messages received from Service Activator and releases based on the Release Strategy.
   using either the size of the payload or a particular value in the header of the message to release. The                         grouping is based on the "type" field for the Payment message.



