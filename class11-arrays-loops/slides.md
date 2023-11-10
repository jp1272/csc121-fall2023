---
marp: true
theme: gaia
class: invert
paginate: false



---
# Lecture 11 - Arrays and Loops
CSC 121 - Object Oriented Program Design
Nadeem Abdul Hamid - Fall 2023

<!-- paginate: skip -->
<!-- _class: lead -->



---
## Objectives
<style scoped>ul  { font-size: 90%; line-height: 100%; }</style>

At the end of this lecture you should
- KNOW:
    - What arrays are and how they differ from lists

- BE ABLE TO:
    - Write loops to process and update arrays

<!-- paginate: true -->
<!-- footer: Lecture 11 - Arrays and Loops -->



---
## Hourly Temperature Recordings

Suppose we wanted to keep track of hourly temperature recordings for each day 
(https://www.ncei.noaa.gov/access/crn/qcdatasets.html)

- Starter code:
    - [DailyRecord](./code/DailyRecord.java)
    - [Tests](./code/DailyRecordTest.java)



---
## Sounds like a list!

```
public class DailyRecord {
    private ILoN readings;
    
    public DailyRecord() {
        this.readings = new MTLoN();
    }
    
    /** 
     *  Records the given temperature value for the given
     *  hour (specified in 24-hour, or "military" time, 0 ... 23).
     */
    public void recordTemp(int hour, int temp) {
        this.readings = this.readings.setValue(hour, temp);
    }
    
    /**
     * Returns the recorded temperature value for the given hour
     */
    public int getTemp(int hour) {
        return this.readings.getValue(hour);
    }


```


---
## Homework!

OK, `ILoN` can "work"...
- Complete the `setValue()` and `getValue()` methods for homework.
    - [ILoNTest](./code/ILoNTest.java)  - make these all pass
    - [ILoN](./code/ILoN.java) - shouldn't need to edit this file
    - [MTLoN](./code/MTLoN.java)
    - [ConsLoN](./code/ConsLoN.java)

But, it feels weird...




---
## How about this?

- [DailyRecord](./code/nutty/DailyRecord.java)
- [Tests](./code/nutty/DailyRecordTest.java) - It passes these!


OK, maybe not!

But, 💡 ...

---
## Arrays

**Array** - a programming language mechanism to store a fixed-size collection of elements that all have the same type.

> An array stores multiple data items of the same data type, in a contiguous block of memory, divided into a number of slots.

```
int[] readings = new int[24];
```

Arrays are *reference* types (like objects) in Java with no methods and a single field called `length`.




