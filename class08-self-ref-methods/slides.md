---
marp: true
theme: gaia
class: invert
paginate: false



---
# Lecture 8 - Methods for Self-referential Data
CSC 121 - Object Oriented Program Design
Nadeem Abdul Hamid - Fall 2023

<!-- paginate: skip -->
<!-- _class: lead -->



---
## Objectives
<style scoped>ul  { font-size: 90%; }</style>

At the end of this lecture you should
- KNOW:
    - That designing methods for self-referential unions typically leads to self-referential method invocation (recursion)
    - That including the method signature in the interface defines a contract between the interface and all of the classes that implement the interface, requiring each of them to implement the specified method


- BE ABLE TO:
    - Design and define methods in Java for self-referential unions



<!-- paginate: true -->
<!-- footer: Lecture 8 - Methods for Self-referential Data -->



---
## Reading

- Section 15 & 16
    - the ‘shapes’ example that is presented in Sections 12, 14, and 15 – some of the discussion (w.r.t. bounding boxes, distances between shapes, etc.) may be very relevant when you are working on classes for your games

- Code for runner log examples is here:

    - [Section 15 code](../htdc-code/section15/)

        The final code is [`runnerlog3.java`](../htdc-code/section15/runnerlog3.java) and [`LogTests3.java`](../htdc-code/section15/LogTests3.java)


---

![runner log diagram](./runner-log-diagram.png)


---
