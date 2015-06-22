# Bandwidth Manager

A `router` is a network device which receives packets and forwards
them on their route to the next network device. In some cases due
to [network congestion](https://en.wikipedia.org/wiki/Network_congestion)
it might happen that the router receives more packets than it can send.

To ensure the best experience to the end user, the router forwards
the packets with a certain priority using a program called
[Network Scheduler](https://en.wikipedia.org/wiki/Network_scheduler).

Write a simple network scheduler which forwards the packets with
protocol-based priority. Below is a list of protocols, ordered by their
priorities (highest priority first):

* [ICMP](https://en.wikipedia.org/wiki/ICMP)
* [UDP](https://en.wikipedia.org/wiki/UDP)
* [RTM](https://en.wikipedia.org/wiki/RTM)
* [IGMP](https://en.wikipedia.org/wiki/IGMP)
* [DNS](https://en.wikipedia.org/wiki/DNS)
* [TCP](https://en.wikipedia.org/wiki/TCP)

If two packets have the same protocol, the one which came first should be
forwarded first.

The network scheduler should implement the following commands:

`rcv [protocol name] [payload]` - receives a packet with the specified
protocol and payload

`send` - returns the payload of the packet which has to be sent

## Example

```
rcv UDP zxchzrkljhklzrjlkhklzr
rcv TCP ghljkajklhgjklare
rcv ICMP ping87.129.54.123
send
\>ping87.129.54.123
send
\>zxchzrkljhklzrjlkhklzr
rcv DNS maps.google.com
send
\>maps.google.com
rcv TCP aejkgjkaegaegae
send
\>ghljkajklhgjklare
send
\>aejkgjkaegaegae
send
\>Nothing to send!
```
