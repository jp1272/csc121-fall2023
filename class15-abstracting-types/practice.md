# Class Practice - Abstracting with Generics

Refer to the classes in the following directory:

- [practice](./code/practice/)

Complete the task below using your files in your `hw15-lists-generics` Eclipse project.

## Task

- Abstract over the `onlyFiction` and `selectOver40` methods, in the `BookList` and `RunnerList` classes, respectively, by appropriately defining a `filter` method in your `ILoT<T>` classes.

    Here are some test cases to adapt. (You will need to add `equals` and `toString` methods to all the classes in the hierarchy in order to run the tests properly.)

    ```
    assertEquals(ficbooks, allbooks.onlyFiction());
    assertEquals(new ConsLoR(br, new ConsLoR(fs, new ConsLoR(jb, mtLoR))), 
                 allrunners.selectOver40());
    ```

    > *Hint: Define an `IPredicate` interface that contains a single method header for a boolean-producing method named `select`.*

---

- **[Challenge]** Use your `filter` method to achieve the same effect as the `onlyLessThan` method in the practice code. For example,

    ```
    assertEquals(under20, allbooks.onlyLessThan(20));
    ```
