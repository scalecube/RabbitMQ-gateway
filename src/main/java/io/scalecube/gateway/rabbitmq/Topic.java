package io.scalecube.gateway.rabbitmq;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.MessageProperties;

public class Topic {

  /**
   * @param durable true if we are declaring a durable queue (the queue will survive a server restart)
   * @param exclusive true if we are declaring an exclusive queue (restricted to this connection)
   * @param autoDelete true if we are declaring an autodelete queue (server will delete it when no longer in use)
   * @param arguments other properties (construction arguments) for the queue
   */

  private String name;
  private boolean durable = true;
  private boolean autoDelete = false;
  private boolean exclusive = false;
  private BasicProperties properties = MessageProperties.PERSISTENT_TEXT_PLAIN;
  private String exchange = "";

  public Topic(String name, String exchange) {
    this.name = name;
    this.exchange = exchange;
  }

  public String name() {
    return name;
  }

  // durable true if we are declaring a durable queue (the queue will survive a server restart)
  public boolean durable() {
    return durable;
  }

  // autoDelete true if we are declaring an autodelete queue (server will delete it when no longer in use)
  public boolean autoDelete() {
    return autoDelete;
  }

  public boolean exclusive() {
    return exclusive;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String name;

    private String exchange = "";

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder exchange(String exchange) {
      this.exchange = exchange;
      return this;
    }

    public Topic build() {
      return new Topic(this.name, this.exchange);
    }

    public Topic create() {
      return build();
    }
  }

  public BasicProperties properties() {
    return properties;
  }

  public String exchange() {
    return exchange;
  }

}
