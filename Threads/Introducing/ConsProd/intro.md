The problem is: Despite of the put() and get() methods are synchronized , the producer can overwrite the data which was not got out or can forbidden the consumer how dont get the data more than once, thats why it is wrong. (for sure it depends on multiple things like CPU's speed..)