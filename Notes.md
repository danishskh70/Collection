# Java-Collections-Course
Free Java Collection Resources

# What is a Module?
Is the smallest piece of software. A module is a set of methods or functions ready to be used somewhere else.

What is a Package?
It is a collection of modules. Usually what a package does, is gather a number of modules holding in general the same functional purpose. Making it easier to include all the related modules at once.

Library
Well library at it's core, is a collections of packages. It's purpose is to offer a set of functionalities ready to use without worrying about the subsequent packages. So a library is what you include when you want to add some functionality to your code. It does not force any coding style on you either.

Framework
It's a set of libraries. But this time, the framework does not just offer functionalities, but it also provides an architecture for the development work. In other words you don't include a framework. You integrate your code into it. It is the wire frame of the project. That's why a framework forces its coding style on you.

What is a Framework?
To do a specific task, we require specific classes / functions / interfaces. Like if we want to write a program related to a calculator application, we require --->

a method to take input from device to calculator application
for processing we need some functions like add(), subtract(), etc
again for logging the output of calculator application to the device we need some output writing methods like log(), display(), etc.
So, everytime, you want to create a calculator application, would you want to do it from scratch? Obviously, no. We would simply use these pre-defined codes and on top of it, we will write our own code!

So for ease, we put all these pre-written codes, may it be classes, functions, interfaces, callbacks, listeners, constants, etc etc inside one place and that is nothing but a framework.

Therefore, Framework are the bodies that contains the pre-written codes (classes and functions) in which we can add our code to overcome the problem.

Spring, Collections, etc are example of Frameworks in Java.

What is a collection in Java?
A Collection represents a single unit of objects.

List Interface ->
The List interface in Java provides a way to store the ordered collection.
It is a child interface of Collection.
It is an ordered collection of objects in which duplicate values can be stored.
Since List preserves the insertion order, it allows positional access and insertion of elements.
It is a factory of ListIterator interface.
Through the ListIterator, we can iterate the list in forward and backward directions.
The implementation classes of the List interface are ArrayList, LinkedList, Stack, and Vector.
Signature of List interface ->
public interface List extends Collection;

How do we initialize an interface?
List list1 = new ArrayList ();
List list2 = new LinkedList ();
List list3 = new Vector (); and so on..
Some basic functionalities ->
list1.add(obj); list1.add(index, obj); //move objects to right (index to N) list1.set(index, obj); //update value at index list1.remove(obj); /remove obj [ first occurance in case of multiple ] list1.remove(1); //move objects to the left equals(obj); // equates the objects with all the elements. sort(comparator); // sorts the collection on the basis of comparator

ArrayList class->
It is just like a dynamic Array.
It has initial capacity of 10.
It increases its capacity with n + n/2 +1 formula.
Stack class->
It follows Last in first out methodology.
Push , pop, peek are some commonly used methods.
It also follows capacity logic.
Linked List class ->
Queue and List both interfaces can be implemented by LinkedList class->

Elements are not stored in the memory in contiguous fashion.
LinkedList class internally uses the doubly linked list.
It does not follow the capacity logic as linked list are purely dynamic in nature.
Bonus points ->
ListIterator Interface is used to traverse the element in a backward and forward direction.
How to create a list iterator
List myList=new ArrayList();
ListIterator itr=myList.listIterator();

Functionalities of List Iterator ->
a. hasPrevious() / hasNext() b. previous() / next()

What is the Difference between ArrayList and LinkedList ->
ArrayList internally uses a dynamic array to store the elements. LinkedList internally uses a doubly linked list to store the elements.

Manipulation with ArrayList is slow because it internally uses an array. If any element is removed from the array, all the other elements are shifted in memory. Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list, so no bit shifting is required in memory.

An ArrayList class can act as a list only because it implements List only. LinkedList class can act as a list and queue both because it implements List and Deque interfaces.

ArrayList is better for storing and accessing data. LinkedList is better for manipulating data.

The memory location for the elements of an ArrayList is contiguous. The location for the elements of a linked list is not contagious.

Generally, when an ArrayList is initialized, a default capacity of 10 is assigned to the ArrayList. There is no case of default capacity in a LinkedList. In LinkedList, an empty list is created when a LinkedList is initialized.

To be precise, an ArrayList is a resizable array. LinkedList implements the doubly linked list of the list interface.

Queue Interface->
Front - deletion happens at the front end.
Rear - insertion happens at the rear end.
Using LinkedList class ->
queue.offer(element) //false in case of error //insert the element, 1.1 alternate is add() - throws exception if element can't be inserted
queue.poll(element) //null in case of error //delete the element, 2.1 alternate is remove() - throws exception if element can't be removed
queue.peek() //null in case of empty. //next element to see, 3.1 alternate is element() - throws exception
Priority Queue class
It is also a queue but with a priority and how do we implement it? using min heap(default). -> Queue minpq = new PriorityQueue(); for max heap -> -> Queue maxpq = new PriorityQueue(Comparator.reverseOrder());
Alternatively, you can write custom comparator in java.

using Dequeue Inteface ( Double ended queue )
Insertion and deletion, both can be performed at either ends. Operations ->

peek(),

peekFirst()

peekLast()

poll()

pollFirst()

pollLast()

offer()

offerFirst()

offerLast()

Map ->
Map is used for storing Key-Value pairs.
Keys will always be unique.
Values can repeat.
Data type of key and value may or may not be same.
The load factor is the measure that decides when to increase the capacity of the Map.
HashMap class->
Uses the concept of hashing to store the elements.
Order is not maintained in the map.
Some methods are : map.get() map.put() map.getOrDefault(key, defaultValue) map.putIfAbsent(key, value) map.containsKey() map.containsValue()
Map Signature ->
Map<Integer, String> map = new HashMap<Integer, String>();

//To Iterate over the keys.

for(Integer key : map.keySet()) { System.out.println(key); }

// To Iterate over the keys.

for(String value : map.values()) { System.out.println(value); }

// To Iterate over the keys.

for(Map.Entry<Integer, String> e : map.entrySet()) { System.out.println(e.getKey() + "ello ello" + e.getValue()) ; }

TreeMap class ->
Sorted Order is maintained.
Concept used -->
A red-black tree is a self-balancing binary search tree where each node has an extra bit as the colour (red or black). These colours are used to ensure that the tree remains balanced during insertions and deletions.

Although the balance of the tree is not perfect but it is good enough to reduce the searching time to around O(log n)

properties -->
The root node must be Black in colour.
The red node can not have a red colour neighbours node.
All the paths from the root to the null shoul contain same number of black nodes.
The left elements are always less than the parent element. Natural ordering is computed in logical comparison of the objects. The right elements are always greater than or equal to the parent element.

Set Interface
Duplicates are not allowed in set.
HashSet
Uses hasing concept for storing the elements.
Insertion order is not preserved.
Uses "equals" method of Object class for comparing.
Uses "hashCode" method of Object class for comparing.
Linked HashSet
Stores unique elements.
Insertion order is preserved.
Tree HashSet
Elements will be maintained in sorted order.
It follows Hashing concept.
It is build on top of SB Binary Search Tree.
A